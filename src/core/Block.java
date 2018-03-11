package core;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Block {

    private int blockSize;
    private BlockHeader blockHeader;
    private int transactionCount;
    private Object[] transactions;

    public Block(BlockHeader blockHeader, Object[] transactions) {
        this.blockHeader = blockHeader;
        this.transactions = transactions;
    }


    // SHA-256 암호화 해시를 두번 수행하여 블록의 해시값을 새성함.
    public String getBlockHash() throws NoSuchAlgorithmException {

        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(blockHeader.toString().getBytes());
        byte[] blockHash = messageDigest.digest();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < blockHash.length; i++) {
            sb.append(Integer.toString((blockHash[i] & 0xff) + 0x100, 16).substring(1));
        }

        String hash = sb.toString();
        return hash;
    }
}
