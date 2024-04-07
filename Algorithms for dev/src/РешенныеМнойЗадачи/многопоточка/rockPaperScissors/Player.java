package РешенныеМнойЗадачи.многопоточка.rockPaperScissors;

import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Player implements Runnable {
    private final List<PlayersMove> playersMoves;
    private final CyclicBarrier cyclicBarrier;

    public Player(List<PlayersMove> playersMoves, CyclicBarrier cyclicBarrier) {
        this.playersMoves = playersMoves;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        int signNumber = (int) (Math.random() * 3);
        SignEnum sign = SignEnum.getSign(signNumber);
        playersMoves.add(new PlayersMove(Thread.currentThread().threadId(), sign));
        try {
            Thread.sleep(250 + (long) (Math.random() * (500 - 250)));
            System.out.println(Thread.currentThread().threadId() + " сыграл: " + sign);
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            System.out.println("Барьер сломан");
        }
    }

}