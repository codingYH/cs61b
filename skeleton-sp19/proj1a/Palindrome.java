public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> listDeque = new LinkedListDeque<>();
        //String.length()
        for (int i = 0; i < word.length(); i++) {
            //string.charAt()
            listDeque.addLast(word.charAt(i));
        }
        return listDeque;
    }

    public boolean isPalindrome(String word) {
        if (word == null) {
            return true;
        }
        if (word.length() == 1) {
            return true;
        } else {
            Deque<Character> frontListDeque = new LinkedListDeque<>();
            Deque<Character> backListDeque = new LinkedListDeque<>();
            for (int i = 0; i < word.length() / 2; i++) {
                //addLast
                frontListDeque.addLast(word.charAt(i));
            }
            for (int i = word.length() / 2; i < word.length(); i++) {
                //addFirst reverse front
                backListDeque.addFirst(word.charAt(i));
            }
            //odd remove the middle one
            if (word.length() % 2 != 0) {
                backListDeque.removeLast();
            }
            if (frontListDeque.size() != backListDeque.size()) {
                return false;
            } else {
                for (int i = 0; i < frontListDeque.size(); i++) {
                    if (!frontListDeque.get(i).equals(backListDeque.get(i))) {
                        return false;
                    }
                }
                return true;
            }
        }
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word == null) {
            return true;
        }
        if (word.length() == 1) {
            return true;
        } else {
            Deque<Character> frontListDeque = new LinkedListDeque<>();
            Deque<Character> backListDeque = new LinkedListDeque<>();
            for (int i = 0; i < word.length() / 2; i++) {
                //addLast
                frontListDeque.addLast(word.charAt(i));
            }
            for (int i = word.length() / 2; i < word.length(); i++) {
                //addFirst reverse front
                backListDeque.addFirst(word.charAt(i));
            }
            //odd remove the middle one
            if (word.length() % 2 != 0) {
                backListDeque.removeLast();
            }
            if (frontListDeque.size() != backListDeque.size()) {
                return false;
            } else {
                for (int i = 0; i < frontListDeque.size(); i++) {
                    if (!cc.equalChars(frontListDeque.get(i), backListDeque.get(i))) {
                        return false;
                    }
                }
                return true;
            }
        }
    }
}
