package blockchain;

import java.io.IOException;

public class Controller {
    Blockchain blockchain;
    NetworkParticipants networkParticipants;
    View view;

    public Controller() {
        view = new View();
        blockchain = Blockchain.getInstance();
        networkParticipants = NetworkParticipants.getInstance();
    }
    public void start() {
        networkParticipants.generateRandomParticipants();
        Mempool.getInstance().generateRandomTransactions(20);

        // Deserialize blockchain.dat - if there is no blockchain.dat, start a new Blockchain
        // Currently disabled, as Jetbrains tests can't deal with a too high network difficulty (proof of work)
/*        try {
            blockchain = (Blockchain) SerializationUtils.deserialize("blockchain.dat");
        } catch (IOException e) {
            blockchain = Blockchain.getInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/

        MiningFacility miningFacility = new MiningFacility(20);
        miningFacility.powerOn();

        miningFacility.powerOff();
        view.printBlockchain(blockchain.getLatestBlocks(15));
    }
}
