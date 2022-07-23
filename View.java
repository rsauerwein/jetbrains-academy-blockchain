package blockchain;

import java.util.List;
import java.util.Scanner;

public class View {
    private final Scanner scanner = new Scanner(System.in);

    public int promptDifficulty() {
        System.out.print("Enter how many zeros the hash must start with: ");
        int difficulty = Integer.parseInt(scanner.nextLine());
        System.out.println();
        return difficulty;
    }

    public void printBlockchain(List<Block> blockList) {
        for (Block block :
                blockList) {
            System.out.println("Block:");
            System.out.printf("Created by miner # %d\nminer%d gets 100 VC\nId: %d\nTimestamp: %d\nMagic number: %d\nHash of the previous block:\n%s\nHash of the block:\n%s\n%s\nBlock was generating for %d seconds\n%s\n\n",
                    block.getMinerId(), block.getMinerId(), block.getId(), block.getTimeStamp(), block.getNonce(), block.getPrevBlockHash(), block.getBlockHash(), formatBlockData(block), block.getMiningDuration(), block.getDifficultyMsg());
        }
    }

    private String formatBlockData(Block block) {
        String msg = "".equals(block.getMsg())  ? "no messages" : block.getMsg();
        String data = String.format("Block data:\n%s", msg);

        return data;
    }
}
