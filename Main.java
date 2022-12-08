import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String answer = "";

        //continues looping until user provides the letter 'c' for coding or 'd' for decoding
        boolean isValid = false;
        while (!isValid) {
            System.out.println("Would you like to (c)ode or (d)ecode Morse code?");
            answer = sc.nextLine();

            if (answer.equals("c")) {
                isValid = true;
                System.out.println("Enter the phrase you wish to code:");
                code();
            }
            else if (answer.equals("d")) {
                isValid = true;
                System.out.println("Enter the phrase you wish to decode:");
            }
            else System.out.println("\nInvalid input. Please try again.");
        }
        
        sc.close();
    }

    public static void toArray() {

    }

    public static void code() {

    }

    public static void decode() {

    }
}