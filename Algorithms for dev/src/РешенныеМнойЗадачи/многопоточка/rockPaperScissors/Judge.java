package РешенныеМнойЗадачи.многопоточка.rockPaperScissors;

import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Exchanger;

public class Judge implements Runnable {

    private final List<PlayersMove> playersSigns;
    private final Exchanger<Long> exchanger;

    public Judge(List<PlayersMove> playersSigns, Exchanger<Long> exchanger) {
        this.playersSigns = playersSigns;
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        HashSet<PlayersMove> signs = new HashSet<>(playersSigns);
        if (signs.size() > 2 || signs.size() == 1) {
            System.out.println("Никто не выиграл");
            try {
                exchanger.exchange(-1l);
                playersSigns.clear();
                return;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
        SignEnum judgeDecision = getJudgeDecision(List.copyOf(signs));
        List<PlayersMove> winnerPlayersMoves = playersSigns.stream().filter(sign -> sign.getSignEnum().equals(judgeDecision)).toList();
        if (winnerPlayersMoves.size() != 1) {
            System.out.println("Никто не выиграл");
            try {
                exchanger.exchange(-1l);
                playersSigns.clear();
                return;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                exchanger.exchange(winnerPlayersMoves.get(0).getPlayersId());
                System.out.println("Победил игрок: " + winnerPlayersMoves.get(0).getPlayersId());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private SignEnum getJudgeDecision(List<PlayersMove> signs) {
        SignEnum first = signs.get(0).getSignEnum();
        SignEnum second = signs.get(1).getSignEnum();
        SignEnum winner = null;
        switch (first) {
            case rock -> {
                winner = second == SignEnum.scissors ? first : second;
            }
            case paper -> {
                winner = second == SignEnum.rock ? first : second;
            }
            case scissors -> {
                winner = second == SignEnum.paper ? first : second;
            }
        }
        return winner;
    }
}