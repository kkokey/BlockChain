package core;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class BlockHeader {

    private int version;
    private byte[] previousBlockHash;
    private int merkleRootHash;
    private int timestamp;
    private int difficultyTarget;
    private int nonce;

    public BlockHeader(byte[] previousBlockHash, Object[] transactions) {
        this.previousBlockHash = previousBlockHash;
        this.merkleRootHash = this.someMethod(transactions);
    }

    public byte[] toByteArray(){
        String tmpStr = "";
        if(previousBlockHash != null){
            tmpStr += new String(previousBlockHash, 0, previousBlockHash.length);
        }
        tmpStr += merkleRootHash;
        return tmpStr.getBytes(StandardCharsets.UTF_8);
    }

    private int someMethod(Object[] transactions){
        return Arrays.hashCode(transactions);
    }

}
