/* TO DO (in order)
 * check if phrase inputted is correct for decoding or coding (e.g. not putting latin alphabet characters for decoding part)
 * tells user more (like to include slashes and spaces and what to use for dots and dashes)
 * add punctuation to arrays (maybe even numbers?)
 * if punctuation is added, would have to adjust code so spaces aren't added before the punctuation
 * edit to create activity obvi
 * write steps for the activity and hints maybe?
 */

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

        boolean again = true;

        // repeats while the user wants to keep coding/decoding
        while (again) {
            // continues looping until user provides the letter 'c' for coding or 'd'
            // for decoding
            boolean isValid = false;
            while (!isValid) {
                System.out.println("\nWould you like to (c)ode or (d)ecode Morse code?");
                answer = sc.nextLine();

                if (answer.equals("c")) {
                    isValid = true;
                    System.out.println("\nEnter the phrase you wish to code (no punctuation):");
                    // converts the phrase into an ArrayList separated by words
                    ArrayList<String> phrase = englishToArray(sc.nextLine());
                    System.out.println("\nYour coded phrase:\n" + code(phrase));

                } else if (answer.equals("d")) {
                    isValid = true;
                    System.out.println("\nEnter the phrase you wish to decode (no punctuation):");
                    // converts the phrase into an ArrayList separated by slashes (words)
                    ArrayList<String> phrase = morseToArray(sc.nextLine());
                    // System.out.println(phrase);
                    System.out.println("\nYour decoded phrase:\n" + decode(phrase));

                } else
                    System.out.println("\nInvalid input. Please try again.");
            }

            isValid = false;

            // repeats while the user enters a valid input
            while (!isValid) {
                System.out.println("\nWould you like to code or decode something else? (Y)es or (n)o?");
                answer = sc.nextLine();
                if (answer.toLowerCase().equals("n")) {
                    again = false;
                    isValid = true;
                    System.out.println("\nThanks for using this Morse code coder/decoder!");
                } else if (answer.toLowerCase().equals("y"))
                    isValid = true;
                else
                    System.out.println("\nInvalid input. Please try again.");
            }
        }

        sc.close();
    }

    // converts an English phrase to an ArrayList with each element being one word
    public static ArrayList<String> englishToArray(String phrase) {
        ArrayList<String> output = new ArrayList<String>();

        boolean stop = false;

        // repeats through the entire phrase word by word
        while (!stop) {
            // if on the last word, adds the remaining phrase string; to prevent the off by one problem
            // else, adds the word to the ArrayList, then deletes the word from the phrase
            if (phrase.indexOf(" ") == -1) {
                output.add(phrase);
                stop = true;
            } else {
                output.add(phrase.substring(0, phrase.indexOf(" ")));
                phrase = phrase.substring(phrase.indexOf(" ") + 1);
            }
        }

        return output;
    }

    // converts a Morse code phrase to an ArrayList with each element being one word
    public static ArrayList<String> morseToArray(String phrase) {
        ArrayList<String> output = new ArrayList<String>();

        boolean stop = false;

        // repeats through the entire phrase word by word
        while (!stop) {
            // if on the last word, adds the remaining phrase string; to prevent the off by one problem
            // else, adds the word to the ArrayList, then deletes the word from the phrase
            if (phrase.indexOf(" /") == -1) {
                output.add(phrase);
                stop = true;
            } else {
                output.add(phrase.substring(0, phrase.indexOf(" /")));
                phrase = phrase.substring(phrase.indexOf(" /") + 3);
            }
        }

        return output;
    }

    // codes the phrase
    public static String code(ArrayList<String> phrase) {
        String output = "";

        //loops through each word
        for (int i = 0; i < phrase.size(); i++) {
            //loops through each letter
            for (int j = 0; j < phrase.get(i).length(); j++) {
                // finds the morse sequence that matches the latin alphabet letter and adds it 
                // to the output string
                for (int k = 0; k < alphabet.length; k++) {
                    if (phrase.get(i).substring(j, j + 1).equals(alphabet[k]))
                        output += morseAlphabet[k];
                }
                // adds a space to separate each letter
                output += " ";
            }
            // adds a slash to separate each word
            if (i != phrase.size() - 1)
                output += "/ ";
        }

        return output;
    }

    // decodes the phrase
    public static String decode(ArrayList<String> phrase) {
        String output = "";
        
        //new ArrayList that will contain each word, separated by each letter
        ArrayList<String> letter = new ArrayList<String>();
        boolean stop = false;

        //loops through each word
        for (int i = 0; i < phrase.size(); i++) {
            letter.clear();

            //utilizes the same function as "toArray" methods to add to the letter ArrayLists
            stop = false;
            while (!stop) {
                letter.add(phrase.get(i).substring(0, phrase.get(i).indexOf(" ")));
                phrase.set(i, phrase.get(i).substring(phrase.get(i).indexOf(" ") + 1));
                if (phrase.get(i).indexOf(" ") == -1) {
                    letter.add(phrase.get(i));
                    stop = true;
                }
            }

            // uncomment to debug your code
            // System.out.println(letter);

            //loops through each letter
            for (int j = 0; j < letter.size(); j++) {
                // finds the latin alphabet letter that matches the morse sequence and adds it 
                // to the output string
                for (int k = 0; k < morseAlphabet.length; k++) {
                    if (letter.get(j).equals(morseAlphabet[k]))
                        output += alphabet[k];

                }
            }
            
            //separates words by a space
            output += " ";
        }

        return output;
    }
}