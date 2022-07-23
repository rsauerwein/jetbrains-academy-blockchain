package blockchain;

import java.io.Serializable;
import java.security.MessageDigest;
import java.util.Date;

public class Block implements Serializable {
    private static final long serialVersionUID = 1L;

    // Blockchain data
    private long id;
    private long timeStamp;
    private long nonce;
    private int difficulty;
    private String blockHash;
    private String prevBlockHash;
    private String msg;
    private Transaction[] transactions;
    private int minerId;

    // Application Metadata which doesn't belong to the Blockchain
    private long miningDuration;
    private int adjustedDifficulty;

    Block(long id, long timeStamp, long nonce, int difficulty, String prevBlockHash, String msg) {
        this.id = id;
        this.timeStamp = timeStamp;
        this.nonce = nonce;
        this.difficulty = difficulty;
        this.prevBlockHash = prevBlockHash;
        this.msg = msg;
        calculateHash();
    }

    public String getBlockHash() {
        return blockHash;
    }

    public long getId() {
        return id;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public String getPrevBlockHash() {
        return prevBlockHash;
    }

    public long getNonce() {
        return nonce;
    }

    public long getMiningDuration() {
        return miningDuration;
    }

    public int getMinerId() {
        return minerId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMiningDuration(long miningDuration) {
        this.miningDuration = miningDuration;
    }

    public void setMinerId(int minerId) {
        this.minerId = minerId;
    }

    public void setAdjustedDifficulty(int adjustedDifficulty) {
        this.adjustedDifficulty = adjustedDifficulty;
    }

    private void calculateHash() {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            /* Applies sha256 to our input */
            byte[] hash = digest.digest(this.toString().getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            for (byte elem: hash) {
                String hex = Integer.toHexString(0xff & elem);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            blockHash = hexString.toString();
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return id + timeStamp + prevBlockHash + nonce + difficulty + minerId + msg;
    }

    public String getDifficultyMsg() {
        String msg;

        if (difficulty < adjustedDifficulty) {
            msg = "N was increased to " + difficulty;
        } else {
            msg = "N was decreased to " + difficulty;
        }

        return msg;
    }
}
