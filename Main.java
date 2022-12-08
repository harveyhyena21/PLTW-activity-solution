import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String answer = "";

        // continues looping until user provides the letter 'c' for coding or 'd' for
        // decoding
        boolean isValid = false;
        while (!isValid) {
            System.out.println("Would you like to (c)ode or (d)ecode Morse code?");
            answer = sc.nextLine();

            if (answer.equals("c")) {
                isValid = true;
                System.out.println("Enter the phrase you wish to code:");
                ArrayList<String> phrase = englishToArray(sc.nextLine());
                System.out.println(code(phrase));
            } else if (answer.equals("d")) {
                isValid = true;
                System.out.println("Enter the phrase you wish to decode:");
                ArrayList<String> phrase = morseToArray(sc.nextLine());
                System.out.println(decode(phrase));
            } else
                System.out.println("\nInvalid input. Please try again.");
        }

        sc.close();
    }

    //converts an English phrase to an ArrayList
    public static ArrayList<String> englishToArray(String s) {
        ArrayList<String> output = new ArrayList<String>();

        return output;
    }

    //converts a Morse code phrase to an ArrayList
    public static ArrayList<String> morseToArray(String s) {
        ArrayList<String> output = new ArrayList<String>();

        return output;
    }

    public static String code(ArrayList<String> s) {
        String output = "";
        return output;
    }

    public static String decode(ArrayList<String> s) {
        String output = "";
        return output;
    }
}