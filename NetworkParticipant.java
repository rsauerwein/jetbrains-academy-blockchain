package blockchain;

public class NetworkParticipant {
    protected static NetworkParticipants networkParticipants = NetworkParticipants.getInstance();

    protected static Blockchain blockchain = Blockchain.getInstance();
    protected static Mempool mempool = Mempool.getInstance();

    protected int id;
    protected int balance;
    protected String name;

    public NetworkParticipant(String name) {
        this.id = networkParticipants.getNextAvailableID();
        this.name = name + id;
        this.balance = 100; // Starting balance
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
