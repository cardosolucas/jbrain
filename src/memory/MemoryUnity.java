package memory;

import java.util.BitSet;

public class MemoryUnity {
    //byte
    private BitSet bits;

    private String toBinaryString(){
        String res = "";
        for(int i = 0; i < bits.length(); i++){
            if(bits.get(i)){
                res += "1";
            } else {
                res += "0";
            }
        }
        while(res.length() < 8){ res += "0"; }
        return res;
    }

    private BitSet toBitSet(String binaryString){
        BitSet temp = new BitSet(8);
        for(int i = 0; i < binaryString.length(); i++){
            if(binaryString.charAt(i) == '0'){
                temp.set(i,false);
            } else {
                temp.set(i,true);
            }
        }
        return temp;
    }

    public MemoryUnity(){
        bits = new BitSet(8);
    }

    public boolean getBit(int position){
        return bits.get(position);
    }

    public void setBit(int position, boolean value){
        bits.set(position, value);
    }

    public boolean isZero(){
        return bits.isEmpty();
    }

    public void sum(){
        if(bits.get(7)){
            int index = 6;
            while (bits.get(index)){
                index--;
            }
            bits.set(7, false);
            bits.flip(index,7);
        } else {
            bits.flip(7);
        }
    }

    public void sub(){
        if(bits.isEmpty()){
            bits.set(0,7,true);
            bits.set(7, true);
        } else {
            if (bits.get(7)) {
                bits.flip(7);
            } else {
                int index = 6;
                while (!bits.get(index)) {
                    index--;
                }
                bits.set(7, true);
                bits.flip(index, 7);
            }
        }
    }

    public char charAt(){
        return (char) Integer.parseInt(toBinaryString(), 2);
    }

    public void write(char input){
        String temp = Integer.toString(input, 2);
        temp = "0" + temp;
        this.bits = toBitSet(temp);
    }
}
