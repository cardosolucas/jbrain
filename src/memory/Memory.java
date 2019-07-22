package memory;

import java.util.ArrayList;

public class Memory {
    private MemoryUnity[] memory;

    public Memory(){
        memory = new MemoryUnity[5000];
        for(int i = 0; i < memory.length; i++){ memory[i] = new MemoryUnity(); }
    }

    public boolean getBit(int bytePos, int bitPos){
        return memory[bytePos].getBit(bitPos);
    }

    public MemoryUnity getByte(int bytePos){
        return memory[bytePos];
    }

    public void setBit(int bytePos, int bitPos, boolean value){
        memory[bytePos].setBit(bitPos, value);
    }

    public void sumByte(int bytePos){
        memory[bytePos].sum();
    }

    public void subByte(int bytePos){
        memory[bytePos].sub();
    }

    public char charAtByte(int bytePos){
        return memory[bytePos].charAt();
    }

    public void writeAtByte(int bytePos, char input){
        memory[bytePos].write(input);
    }

    public boolean isByteZero(int bytePos){
        return memory[bytePos].isZero();
    }
}
