package blockchain;

import java.util.ArrayDeque;
import java.util.Deque;

public class Mempool {
    private static Mempool instance;
    private Deque<Transaction> transactions;

    private Mempool() {
        transactions = new ArrayDeque<>();
    }

    public static Mempool getInstance() {
        if (instance == null) {
            instance = new Mempool();
        }

        return instance;
    }

    public Transaction getTransaction() {
        if (transactions.size() < 5) {
            generateRandomTransactions(20);
        }
        return transactions.poll();
    }

    public void generateRandomTransactions(int n) {
        Deque<NetworkParticipant> sortedParticipants = NetworkParticipants.getInstance().getNetworkParticipantsSortedByNetWorth();

        for (int i = 0; i < n; i++) {
            NetworkParticipant receiver = sortedParticipants.poll();
            NetworkParticipant sender = sortedParticipants.pollLast();

            receiver.setBalance(receiver.getBalance() + 10);
            sender.setBalance(sender.getBalance() - 10);

            transactions.push(new Transaction(sender, receiver, 10));
        }
    }
}
