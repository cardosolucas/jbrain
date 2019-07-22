package ui;

import executor.Interpreter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Cli {

    private static void printHeader(){
        System.out.println("   _________           _       \n" +
                "  |_  | ___ \\         (_)      \n" +
                "    | | |_/ /_ __ __ _ _ _ __  \n" +
                "    | | ___ \\ '__/ _` | | '_ \\ \n" +
                "/\\__/ / |_/ / | | (_| | | | | |\n" +
                "\\____/\\____/|_|  \\__,_|_|_| |_|\n" +
                "                               \n" +
                "                               ");
        System.out.println("By Lucas Cardoso");
        System.out.println("https://github.com/cardosolucas");
    }

    public static void main(String[] args) {
        if(args.length == 0) {
            Interpreter i = new Interpreter();
            Scanner comma = new Scanner(System.in);
            printHeader();
            while (true) {
                System.out.print(">> ");
                String temp = comma.next();
                if (temp.equals("\n")) {
                    continue;
                }
                if (temp.equals("clear")) {
                    i = new Interpreter();
                }
                i.execute(temp);
            }
        } else if(args.length == 1){
            try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
                String reader = br.readLine();
                String program = new String();
                while(reader != null){
                    program += reader;
		    reader = br.readLine();
                }
                Interpreter i = new Interpreter();
                printHeader();
                i.execute(program);
            } catch (Exception e){
                e.printStackTrace();
            }

        }
    }
}
