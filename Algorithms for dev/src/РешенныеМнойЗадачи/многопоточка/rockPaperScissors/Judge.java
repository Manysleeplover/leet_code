package РешенныеМнойЗадачи.многопоточка.rockPaperScissors;

import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Exchanger;

public class Judge implements Runnable {

    private final List<PlayersMove> playersMoves;
    private final Exchanger<Long> winnerIdExchanger;

    public Judge(List<PlayersMove> playersMoves, Exchanger<Long> winnerIdExchanger) {
        this.playersMoves = playersMoves;
        this.winnerIdExchanger = winnerIdExchanger;
    }

    @Override
    public void run() {
        HashSet<PlayersMove> signs = new HashSet<>(playersMoves);
        if (signs.size() > 2 || signs.size() == 1) {
            exchangeWinnerId(-1L);
            System.out.println("Никто не выиграл");
            return;
        }

        SignEnum judgeDecision = getJudgeDecision(List.copyOf(signs));
        List<PlayersMove> winnerPlayersMoves = playersMoves.stream()
                .filter(sign -> sign.signEnum().equals(judgeDecision))
                .toList();

        if (winnerPlayersMoves.size() != 1) {
            exchangeWinnerId(-1);
            System.out.println("Никто не выиграл");

        } else {
            exchangeWinnerId(winnerPlayersMoves.get(0).playersId());
            System.out.println("Победил игрок: " + winnerPlayersMoves.get(0).playersId());
        }
    }

    private void exchangeWinnerId(long id) {
        try {
            winnerIdExchanger.exchange(id);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private SignEnum getJudgeDecision(List<PlayersMove> signs) {
        SignEnum first = signs.get(0).signEnum();
        SignEnum second = signs.get(1).signEnum();
        SignEnum winner = null;

        switch (first) {
            case rock -> winner = second == SignEnum.scissors ? first : second;
            case paper -> winner = second == SignEnum.rock ? first : second;
            case scissors -> winner = second == SignEnum.paper ? first : second;
        }

        return winner;
    }
}