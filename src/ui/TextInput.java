package ui;

import java.util.Scanner;
/**
 * @author Jonas, Sofus, Lasse, Sebastian, Henrik
 * 
 */
public class TextInput {

    public TextInput() {

    }
    
    public static int inputNumber(String question) {   
        Scanner keyboard = new Scanner(System.in);
        int number = 0;
        printQuesiton(question);
        while (!keyboard.hasNextInt()){
            System.out.println("Input skal være et tal - prøv igen");
            keyboard.nextLine();
        }
        number = keyboard.nextInt();
        return number;
    }
    
    public static String inputString(String question) {
        Scanner keyboard = new Scanner(System.in);
        printQuesiton(question);
        return keyboard.nextLine();
    }
    
    public static int inputInt(String question) {
        Scanner keyboard = new Scanner(System.in);
        printQuesiton(question);
        return keyboard.nextInt();
    }
    
    public static double inputDouble(String question) {
    	Scanner keyboard = new Scanner(System.in);
    	printQuesiton(question);
    	return keyboard.nextDouble();
    }
    
    private static void printQuesiton(String question) {
        System.out.print(" " + question + ": ");
    }

}
