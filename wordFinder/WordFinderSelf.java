import java.util.Scanner;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;


class WordFinderSelf {
    
    public static HashMap<Character, Integer> getCharCountMap(String word) {
        HashMap <Character, Integer> currentWordMap = new HashMap<>();
        
        for(int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            int currentCharCount = currentWordMap.containsKey(currentChar) ?
                                   currentWordMap.get(currentChar) : 0;
            currentWordMap.put(currentChar, currentCharCount + 1);
        }

        return currentWordMap;
    }


    
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        System.out.println("Please give me your pool of letters: ");
        String letters = s.nextLine().toUpperCase();

        HashMap <Character, Integer> lettersMap = getCharCountMap(letters);
        

        BufferedReader b = new BufferedReader(new FileReader("/home/granfelino/own/algorithms1/dictionary.txt"));

        
        for(String currentWord = b.readLine(); currentWord != null; currentWord = b.readLine()) {
            HashMap <Character, Integer> currentWordMap = getCharCountMap(currentWord);

            boolean canMake = true;
            for(char currentChar : currentWordMap.keySet()) {
                int lettersTempCharCount = lettersMap.containsKey(currentChar) ?
                lettersMap.get(currentChar) : 0;

                if(lettersTempCharCount < currentWordMap.get(currentChar)) {
                    canMake = false;
                    break;
                }
            }

            if(canMake) { System.out.println(currentWord); };


        }

        s.close();
        b.close();
    }
}