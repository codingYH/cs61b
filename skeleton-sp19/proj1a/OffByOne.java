public class OffByOne implements CharacterComparator {

    @Override
    public boolean equalChars(char x, char y) {
        if ((x + 1 == y) || (y + 1 == x)) {
            return true;
        } else {
            return false;
        }
    }
}
