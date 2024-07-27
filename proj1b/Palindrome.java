public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> res = new ArrayDeque<>();
        int len = word.length();
        if (len > 0) {
            for (int i = 0; i < len; i++) {
                res.addLast(word.charAt(i));
            }
            return res;
        } else {
            return null;
        }
    }

    public boolean isPalindrome(String word) {
        Deque<Character> obj = wordToDeque(word);
        int len = word.length();
        for (int i = 0; i < len / 2; i++) {
            if (obj.get(i) != obj.get(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        int len = word.length();
        Deque<Character> obj = wordToDeque(word);
        for (int i = 0; i < len / 2; i++) {
            if (!cc.equalChars(obj.get(i), obj.get(len - i - 1))) {
                return false;
            }
        }
        return true;
    }
}
