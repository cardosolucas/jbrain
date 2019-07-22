package executor;

import exceptions.MemoryOverflowException;
import memory.Memory;

import java.util.Scanner;
import java.util.Stack;

public class Interpreter {

    Scanner comma;
    Memory memory;
    Stack<Integer> whileStacker;
    int memoryPos;

    public Interpreter(){
        this.comma = new Scanner(System.in);
        this.memory = new Memory();
        this.whileStacker = new Stack<>();
        this.memoryPos = 0;
    }

    public void execute(String program){
        for(int i = 0; i < program.length(); i++){
            try {
                try {
                    char thisChar = program.charAt(i);
                    switch (thisChar) {
                        case '>':
                            memoryPos++;
                            break;
                        case '<':
                            memoryPos--;
                            break;
                        case '+':
                            memory.sumByte(memoryPos);
                            break;
                        case '-':
                            memory.subByte(memoryPos);
                            break;
                        case '.':
                            System.out.print(memory.charAtByte(memoryPos));
                            break;
                        case ',':
                            System.out.println();
                            System.out.println("READ: ");
                            char temp = comma.next().charAt(0);
                            memory.writeAtByte(memoryPos, temp);
                            break;
                        case '[':
                            whileStacker.push(i);
                            break;
                        case ']':
                            if (memory.isByteZero(memoryPos)) {
                                whileStacker.pop();
                            } else {
                                i = whileStacker.peek();
                            }
                            break;
                        default:
                            break;
                    }
                } catch (IndexOutOfBoundsException idxe) {
                    throw new MemoryOverflowException(idxe.getMessage().toString());
                }
            } catch (MemoryOverflowException e){
                e.printStackTrace();
            }
        }
    }
}
