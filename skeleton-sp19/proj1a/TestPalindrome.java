import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static CharacterComparator comparator = new OffByOne();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        assertEquals(true, palindrome.isPalindrome(""));
        assertEquals(true, palindrome.isPalindrome("a"));
        assertEquals(false, palindrome.isPalindrome("Aa"));
        assertEquals(true, palindrome.isPalindrome("baccab"));

    }

    @Test

    public void testIsPalindromeOfByOne(){
        assertEquals(true, palindrome.isPalindrome("", comparator));
        assertEquals(true, palindrome.isPalindrome("a",comparator));
        assertEquals(false, palindrome.isPalindrome("Aa",comparator));
        assertEquals(true, palindrome.isPalindrome("flake",comparator));

    }
}