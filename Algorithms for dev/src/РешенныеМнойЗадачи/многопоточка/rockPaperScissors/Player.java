package РешенныеМнойЗадачи.многопоточка.rockPaperScissors;

import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class Player implements Runnable {
    private final List<PlayersMove> list;
    private final CyclicBarrier cyclicBarrier;

    public Player(List<PlayersMove> list, CyclicBarrier cyclicBarrier) {
        this.list = list;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        int signNumber = (int) (Math.random() * 3);
        SignEnum sign = SignEnum.getSign(signNumber);
        list.add(new PlayersMove(Thread.currentThread().getId(), sign));
        try {
            Thread.sleep(100 + (long) (Math.random() * (200 - 100)));
            System.out.println(Thread.currentThread().getId() + " сыграл: " + sign);
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            System.out.println("Барьер сломан");
        }
    }

}