import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {

    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

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
    public void testisPalindrome() {
        assertTrue(palindrome.isPalindrome("tacat"));
        assertFalse(palindrome.isPalindrome("ab"));
        assertTrue(palindrome.isPalindrome("abcdefggfedcba"));
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("a"));
    }
    OffByOne cc = new OffByOne();
    @Test
    public void testisPalindrome2() {
        assertTrue(palindrome.isPalindrome("flake", cc ));

    }
}
