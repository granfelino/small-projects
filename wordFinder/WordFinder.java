import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.HashMap;
public class WordFinder {
    
    public static HashMap<Character, Integer> getCharacterCountMap(String letters) {

        HashMap<Character, Integer> lettersCountMap = new HashMap<>();

        for (int i = 0; i < letters.length(); i++) {
            char currentChar = letters.charAt(i);
            int count = lettersCountMap.containsKey(currentChar) ? 
                        lettersCountMap.get(currentChar) : 0;

            lettersCountMap.put(currentChar, count + 1);
        }

        return lettersCountMap;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new FileReader("/home/granfelino/own/algorithms1/dictionary.txt"));        
        Scanner s = new Scanner(System.in);

        System.out.println("Put in the pool of letters: ");
        String letters = s.nextLine().toUpperCase();

        HashMap<Character, Integer> lettersCountMap = getCharacterCountMap(letters);

        System.out.println("Here is a list of valid words: ");

        for(String currentWord = b.readLine(); currentWord != null; currentWord = b.readLine()) {
            HashMap<Character, Integer> currentWordMap = getCharacterCountMap(currentWord);     

            boolean canMakeCurrentWord = true;
            for (Character character : currentWordMap.keySet()) {
                int currentWordCharCount = currentWordMap.get(character);
                int lettersCharCount = lettersCountMap.containsKey(character) ?
                                       lettersCountMap.get(character) : 0;
                                       
                if (currentWordCharCount > lettersCharCount) {
                    canMakeCurrentWord = false;
                    break;
                }
            } 
            if (canMakeCurrentWord) {
                System.out.println(currentWord);
            }
        }

        s.close();
        b.close();
    
    }
}
