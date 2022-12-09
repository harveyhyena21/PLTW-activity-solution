import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    // the latin and morse code alphabet in arrays
    private static final String[] alphabet = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
            "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };
    private static final String[] morseAlphabet = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
            ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
            "-.--", "--.." };

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String answer = "";

        // continues looping until user provides the letter 'c' for coding or 'd'
        // for decoding
        boolean isValid = false;
        while (!isValid) {
            System.out.println("Would you like to (c)ode or (d)ecode Morse code?");
            answer = sc.nextLine();

            if (answer.equals("c")) {
                isValid = true;
                System.out.println("\nEnter the phrase you wish to code (no punctuation):");
                ArrayList<String> phrase = englishToArray(sc.nextLine());
                System.out.println(code(phrase));

            } else if (answer.equals("d")) {
                isValid = true;
                System.out.println("\nEnter the phrase you wish to decode (no punctuation):");
                ArrayList<String> phrase = morseToArray(sc.nextLine());
                //System.out.println(phrase);
                System.out.println(decode(phrase));

            } else
                System.out.println("\nInvalid input. Please try again.");
        }

        sc.close();
    }

    // converts an English phrase to an ArrayList with each element being one word
    public static ArrayList<String> englishToArray(String phrase) {
        ArrayList<String> output = new ArrayList<String>();

        boolean stop = false;

        while (!stop) {
            output.add(phrase.substring(0, phrase.indexOf(" ")));
            phrase = phrase.substring(phrase.indexOf(" ") + 1);
            if (phrase.indexOf(" ") == -1) {
                output.add(phrase);
                stop = true;
            }
        }

        return output;
    }

    // converts a Morse code phrase to an ArrayList with each element being one word
    public static ArrayList<String> morseToArray(String phrase) {
        ArrayList<String> output = new ArrayList<String>();

        boolean stop = false;

        while (!stop) {
            
            output.add(phrase.substring(0, phrase.indexOf(" /")));
            phrase = phrase.substring(phrase.indexOf(" /") + 3);
            if (phrase.indexOf(" /") == -1) {
                output.add(phrase);
                stop = true;
            } else {
                
            }
        }

        return output;
    }

    // codes the phrase
    public static String code(ArrayList<String> phrase) {
        String output = "";

        for (int i = 0; i < phrase.size(); i++) {
            for (int j = 0; j < phrase.get(i).length(); j++) {
                for (int k = 0; k < alphabet.length; k++) {
                    if (phrase.get(i).substring(j, j + 1).equals(alphabet[k]))
                        output += morseAlphabet[k];
                }
                output += " ";
            }
            if (i != phrase.size() - 1)
                output += "/ ";
        }

        return output;
    }

    // decodes the phrase
    public static String decode(ArrayList<String> phrase) {
        String output = "";

        ArrayList<String> letter = new ArrayList<String>();
        boolean stop = false;

        for (int i = 0; i < phrase.size(); i++) {
            letter.clear();

            stop = false;
            while (!stop) {
                letter.add(phrase.get(i).substring(0, phrase.get(i).indexOf(" ")));
                phrase.set(i, phrase.get(i).substring(phrase.get(i).indexOf(" ") + 1));
                if (phrase.indexOf(" ") == -1) {
                    letter.add(phrase.get(i));
                    stop = true;
                }
            }

            System.out.println(letter);
            for (int j = 0; j < letter.size(); j++) {
                for (int k = 0; k < morseAlphabet.length; k++) {
                    if (letter.get(j).equals(morseAlphabet[k]))
                        output += alphabet[k];
                
                }
            }
            
            output += " ";
        }

        return output;
    }
}