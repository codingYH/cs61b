public class OffByN implements CharacterComparator{
    private int n;

    public OffByN(int N){
        n = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        if ((x + n == y) || (y + n == x)) {
            return true;
        } else {
            return false;
        }
    }
}
