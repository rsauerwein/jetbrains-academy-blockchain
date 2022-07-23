package blockchain;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MiningFacility {
    private Miner[] miners;
    private ExecutorService executor;

    public MiningFacility(int n) {
        miners = new Miner[n];
        executor = Executors.newFixedThreadPool(n);

        for (int i = 0; i < n; i++) {
            miners[i] = new Miner();
        }
    }

    public void powerOn() {
        for (Miner miner :
                miners) {
            executor.submit(() -> miner.powerOn());
        }
    }

    public void powerOff() {
        try {
            executor.awaitTermination(14, TimeUnit.SECONDS);
            executor.shutdownNow();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
