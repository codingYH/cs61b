//* This class outputs all palindromes in the words file in the current directory.
public class PalindromeFinder {
    public static void main(String[] args) {
        int minLength = 4;
        In in = new In("../library-sp18/data/words.txt");
        Palindrome palindrome = new Palindrome();
        CharacterComparator offBy2 = new OffByN(2);
        CharacterComparator offBy1 = new OffByOne();

        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength && palindrome.isPalindrome(word)) {
                System.out.println("Palindrome: "+word);
            }
            if(palindrome.isPalindrome(word, offBy1)){
                System.out.println("Palindrome offByOne: "+word);
            }
            if(palindrome.isPalindrome(word, offBy2)){
                System.out.println("Palindrome offByTwo: "+word);
            }

        }
    }
}
//Uncomment this class once you've written isPalindrome.