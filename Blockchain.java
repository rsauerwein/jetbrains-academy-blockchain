package blockchain;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Blockchain implements Serializable {
    private static Blockchain instance;
    private static final long serialVersionUID = 1L;

    private List<Block> blockList;
    private int difficulty;

    private Blockchain() {
        blockList = new ArrayList<>();
        difficulty = 0;

        long nonce = ThreadLocalRandom.current().nextLong(0, Long.MAX_VALUE);
        Block genesisBlock = new Block(1,
                new Date().getTime(),
                nonce,
                difficulty,
                "0",
                "");
        genesisBlock.setMiningDuration(0);
        genesisBlock.setMinerId(1);
        blockList.add(genesisBlock);

        // difficulty++;
        genesisBlock.setAdjustedDifficulty(difficulty);

        // Serialize the current Blockchain
/*        try {
            SerializationUtils.serialize(this, "blockchain.dat");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    public static Blockchain getInstance() {
        if (instance == null) {
            instance = new Blockchain();
        }
        return instance;
    }

    public Block getLatestBlock() {
        return blockList.get(blockList.size() - 1);
    }

    public List<Block> getBlockList() {
        return Collections.unmodifiableList(blockList);
    }

    public List<Block> getLatestBlocks(int n) {
        List<Block> res = new ArrayList<>();

        for (int i = blockList.size() - n; i < blockList.size(); i++) {
            res.add(blockList.get(i));
        }

        return Collections.unmodifiableList(res);
    }

    public synchronized int getCurrentBlockHeight() {
        return blockList.size();
    }

    public int getDifficulty() {
        return difficulty;
    }

    public synchronized void addBlock(Block block) {
        // Refuse invalid blocks
        if (!isValidBlock(block)) {
            return;
        }

        // Add the verified Block to the Blockchain
        blockList.add(block);

        // Adjust mining difficulty
        if (block.getMiningDuration() < 60) {
            difficulty++;
        } else {
            difficulty--;
        }
        block.setAdjustedDifficulty(difficulty);

        // Serialize the current Blockchain
/*        try {
            SerializationUtils.serialize(this, "blockchain.dat");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    public boolean isValidBlock(Block block) {
        for (int i = 0; i < difficulty; i++) {
            if (block.getBlockHash().charAt(i) != '0') {
                return false;
            }
        }

        if (!block.getPrevBlockHash().equals(getLatestBlock().getBlockHash())) {
            return false;
        }

        return true;
    }
}
