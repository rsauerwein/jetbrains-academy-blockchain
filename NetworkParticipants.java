package blockchain;

import java.util.*;
import java.util.stream.Collectors;

public class NetworkParticipants {
    private static NetworkParticipants instance;
    private int nextAvailableID;
    private List<NetworkParticipant> networkParticipantList;

    private NetworkParticipants() {
        nextAvailableID = 1;
        networkParticipantList = new ArrayList<>();
    }

    public static NetworkParticipants getInstance() {
        if (instance == null) {
            instance = new NetworkParticipants();
        }

        return instance;
    }

    public void addNetworkParticipant(NetworkParticipant networkParticipant) {
        networkParticipantList.add(networkParticipant);
    }

    public int getNextAvailableID() {
        return nextAvailableID++;
    }

    public List<NetworkParticipant> getNetworkParticipantList() {
        return Collections.unmodifiableList(networkParticipantList);
    }

    public Deque<NetworkParticipant> getNetworkParticipantsSortedByNetWorth() {
        return networkParticipantList.stream()
                .sorted(Comparator.comparing(NetworkParticipant::getBalance))
                .collect(Collectors.toCollection(ArrayDeque::new));
    }

    /**
     * Yes, ugly ;)
     */
    public void generateRandomParticipants() {
        networkParticipantList.add(new NetworkParticipant("Alice"));
        networkParticipantList.add(new NetworkParticipant("Bob"));
        networkParticipantList.add(new NetworkParticipant("Satoshi"));
        networkParticipantList.add(new NetworkParticipant("Catagent"));
        networkParticipantList.add(new NetworkParticipant("Mirakulix"));
        networkParticipantList.add(new NetworkParticipant("Drogelix"));
        networkParticipantList.add(new NetworkParticipant("Krutzifix"));
        networkParticipantList.add(new NetworkParticipant("Hodor"));
        networkParticipantList.add(new NetworkParticipant("Walter"));
        networkParticipantList.add(new NetworkParticipant("Daisy"));
        networkParticipantList.add(new NetworkParticipant("Alice"));
        networkParticipantList.add(new NetworkParticipant("Bob"));
        networkParticipantList.add(new NetworkParticipant("Satoshi"));
        networkParticipantList.add(new NetworkParticipant("Catagent"));
        networkParticipantList.add(new NetworkParticipant("Mirakulix"));
        networkParticipantList.add(new NetworkParticipant("Drogelix"));
        networkParticipantList.add(new NetworkParticipant("Krutzifix"));
        networkParticipantList.add(new NetworkParticipant("Hodor"));
        networkParticipantList.add(new NetworkParticipant("Walter"));
        networkParticipantList.add(new NetworkParticipant("Daisy"));
        networkParticipantList.add(new NetworkParticipant("Alice"));
        networkParticipantList.add(new NetworkParticipant("Bob"));
        networkParticipantList.add(new NetworkParticipant("Satoshi"));
        networkParticipantList.add(new NetworkParticipant("Catagent"));
        networkParticipantList.add(new NetworkParticipant("Mirakulix"));
        networkParticipantList.add(new NetworkParticipant("Drogelix"));
        networkParticipantList.add(new NetworkParticipant("Krutzifix"));
        networkParticipantList.add(new NetworkParticipant("Hodor"));
        networkParticipantList.add(new NetworkParticipant("Walter"));
        networkParticipantList.add(new NetworkParticipant("Daisy"));
        networkParticipantList.add(new NetworkParticipant("Alice"));
        networkParticipantList.add(new NetworkParticipant("Bob"));
        networkParticipantList.add(new NetworkParticipant("Satoshi"));
        networkParticipantList.add(new NetworkParticipant("Catagent"));
        networkParticipantList.add(new NetworkParticipant("Mirakulix"));
        networkParticipantList.add(new NetworkParticipant("Drogelix"));
        networkParticipantList.add(new NetworkParticipant("Krutzifix"));
        networkParticipantList.add(new NetworkParticipant("Hodor"));
        networkParticipantList.add(new NetworkParticipant("Walter"));
        networkParticipantList.add(new NetworkParticipant("Daisy"));
        networkParticipantList.add(new NetworkParticipant("Alice"));
        networkParticipantList.add(new NetworkParticipant("Bob"));
        networkParticipantList.add(new NetworkParticipant("Satoshi"));
        networkParticipantList.add(new NetworkParticipant("Catagent"));
        networkParticipantList.add(new NetworkParticipant("Mirakulix"));
        networkParticipantList.add(new NetworkParticipant("Drogelix"));
        networkParticipantList.add(new NetworkParticipant("Krutzifix"));
        networkParticipantList.add(new NetworkParticipant("Hodor"));
        networkParticipantList.add(new NetworkParticipant("Walter"));
        networkParticipantList.add(new NetworkParticipant("Daisy"));
        networkParticipantList.add(new NetworkParticipant("Alice"));
        networkParticipantList.add(new NetworkParticipant("Bob"));
        networkParticipantList.add(new NetworkParticipant("Satoshi"));
        networkParticipantList.add(new NetworkParticipant("Catagent"));
        networkParticipantList.add(new NetworkParticipant("Mirakulix"));
        networkParticipantList.add(new NetworkParticipant("Drogelix"));
        networkParticipantList.add(new NetworkParticipant("Krutzifix"));
        networkParticipantList.add(new NetworkParticipant("Hodor"));
        networkParticipantList.add(new NetworkParticipant("Walter"));
        networkParticipantList.add(new NetworkParticipant("Daisy"));
        networkParticipantList.add(new NetworkParticipant("Alice"));
        networkParticipantList.add(new NetworkParticipant("Bob"));
        networkParticipantList.add(new NetworkParticipant("Satoshi"));
        networkParticipantList.add(new NetworkParticipant("Catagent"));
        networkParticipantList.add(new NetworkParticipant("Mirakulix"));
        networkParticipantList.add(new NetworkParticipant("Drogelix"));
        networkParticipantList.add(new NetworkParticipant("Krutzifix"));
        networkParticipantList.add(new NetworkParticipant("Hodor"));
        networkParticipantList.add(new NetworkParticipant("Walter"));
        networkParticipantList.add(new NetworkParticipant("Daisy"));
    }
}
