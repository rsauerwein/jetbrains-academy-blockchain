package blockchain;

public class Transaction {
    private static int nextId = 1;
    private int id;
    private NetworkParticipant sender;
    private NetworkParticipant receiver;
    private int amount;

    public Transaction(NetworkParticipant sender, NetworkParticipant receiver, int amount) {
        this.id = nextId++;
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return sender.name + " sent " + amount + " VC to " + receiver.name;
    }
}
