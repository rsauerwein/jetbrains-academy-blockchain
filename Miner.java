package blockchain;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class Miner extends NetworkParticipant {
    public Miner() {
        super("Miner");
    }

    public void powerOn() {
        while (!Thread.currentThread().isInterrupted()) {
            Block block = mine();
            blockchain.addBlock(block);
        }
    }

    private Block mine() {
        Block block;
        String msg = mempool.getTransaction().toString();
        LocalDateTime start = LocalDateTime.now();
        do {
            long nonce = ThreadLocalRandom.current().nextLong(0, Long.MAX_VALUE);

            block = new Block(blockchain.getCurrentBlockHeight() + 1,
                    new Date().getTime(),
                    nonce,
                    blockchain.getDifficulty(),
                    blockchain.getLatestBlock().getBlockHash(),
                    msg);

        } while (!Thread.currentThread().isInterrupted() && !blockchain.isValidBlock(block));

        LocalDateTime end = LocalDateTime.now();
        long seconds = ChronoUnit.SECONDS.between(start, end);
        block.setMiningDuration(seconds);
        block.setMinerId(id);

        return block;
    }
}
