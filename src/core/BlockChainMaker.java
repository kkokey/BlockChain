package core;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class BlockChainMaker {

    List<Block> blockchain = new ArrayList<Block>();

    public Block makeBlock(byte[] previousBlockHash, String[] transactions){
        Block block = new Block(new BlockHeader(previousBlockHash, transactions), transactions);;
        return block;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        BlockChainMaker blockChainMaker = new BlockChainMaker();
        // Genesis block
        String[] transactions = {"Hosang sent 1k Bitcoins to Zuckerberg."};
        Block genesisBlock = blockChainMaker.makeBlock(null, transactions);
        System.out.println("Block Hash : " + genesisBlock.getBlockHash());

        // Second block
        String[] secondTransactions = {"Zuckerberg sent 500 Bitcoins to Hosang."};
        Block secondBlock = blockChainMaker.makeBlock(genesisBlock.getBlockHash().getBytes(), secondTransactions);
        System.out.println("Second Block Hash : " + secondBlock.getBlockHash());

        // Third block
        String[] thirdTransactions = {"Hosang sent 500 Bitcoins to Moon."};
        Block thirdBlock = blockChainMaker.makeBlock(secondBlock.getBlockHash().getBytes(), thirdTransactions);
        System.out.println("Third Block Hash : " + thirdBlock.getBlockHash());

    }

}
