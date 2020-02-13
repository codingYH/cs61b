import java.util.NoSuchElementException;

public class GuitarHero {
    private String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    public double getFrequency(String key){
        int i = keyboard.indexOf(key);
        if( i != -1){
            return 440 * Math.pow(2, (i - 24.0)/12.0);
        }
        throw new NoSuchElementException("non a keyBoard argument");
    }
}
