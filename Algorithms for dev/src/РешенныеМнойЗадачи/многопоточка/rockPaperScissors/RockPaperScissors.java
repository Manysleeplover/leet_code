package РешенныеМнойЗадачи.многопоточка.rockPaperScissors;

import java.util.*;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class RockPaperScissors {


    public static void main(String[] args) throws InterruptedException {
        RockPaperScissors rockPaperScissors = new RockPaperScissors();
        rockPaperScissors.startGame(2, 5);
    }


    public void startGame(int countOfThreads, int countOfWins) throws InterruptedException {
        List<PlayersMove> playersMove = Collections.synchronizedList(new ArrayList<>());
        Exchanger<Long> winnerIdExchanger = new Exchanger<>();
        Judge judge = new Judge(playersMove, winnerIdExchanger);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(countOfThreads, judge);
        Map<Long, Integer> idScoreMap = new HashMap<>();

        List<Player> playersList = new ArrayList<>();
        for (int i = 0; i < countOfThreads; i++) {
            playersList.add(new Player(playersMove, cyclicBarrier));
        }

        ExecutorService executorService = Executors.newFixedThreadPool(countOfThreads);

        long countOfGames = 0;
        while (!idScoreMap.containsValue(countOfWins)) {
            countOfGames++;
            playersMove.clear();
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
                .collect(Collectors.joining("\n")));
        System.out.println("Количество игр: " + countOfGames);

        System.exit(0);
    }
}
