package РешенныеМнойЗадачи.многопоточка.rockPaperScissors;

import java.util.*;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class RockPaperScissors {

    public static void main(String[] args) throws InterruptedException {
        startGame(3, 5);
    }

    /**
     *  Суть такая: игроки синхронизированы с помощью CyclicBarrier. В конце своего хода они вызывают cb.await().
     *  Последний игрок, кто вызывает .await() становится судьёй и выполняет его функции.
     *  Судья принимает решение, и вызывая winnerIdExchanger.exchange(id) возвращает в главные поток id победителя или -1 если никто не выиграл.
     *  Считаем до первых 5 побед, потом глушим executor.
     */
    public static void startGame(int countOfThreads, int countOfWins) throws InterruptedException {
        List<PlayersMove> playersMoves = Collections.synchronizedList(new ArrayList<>());
        Exchanger<Long> winnerIdExchanger = new Exchanger<>();

        Judge judge = new Judge(playersMoves, winnerIdExchanger);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(countOfThreads, judge);

        List<Player> playersList = new ArrayList<>();
        for (int i = 0; i < countOfThreads; i++) {
            playersList.add(new Player(playersMoves, cyclicBarrier));
        }
        ExecutorService executorService = Executors.newFixedThreadPool(countOfThreads);

        long countOfGames = 0;
        Map<Long, Integer> idScoreMap = new HashMap<>();
        while (!idScoreMap.containsValue(countOfWins)) {
            countOfGames++;
            playersMoves.clear();
            for (Player player : playersList) {
                executorService.submit(player);
            }
            Long winnerId = winnerIdExchanger.exchange(-1L);
            if (winnerId == -1) continue;

            idScoreMap.put(winnerId, idScoreMap.getOrDefault(winnerId, 0) + 1);
        }

        System.out.println("Счёт:\n" + idScoreMap.entrySet()
                .stream()
                .map(entry -> "Id: " + entry.getKey() + ", Очки: " + entry.getValue())
                .collect(Collectors.joining("\n"))
        );
        System.out.println("Количество игр: " + countOfGames);

        executorService.shutdown();
    }
}
