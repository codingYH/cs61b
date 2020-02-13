import org.junit.Assert;
import org.junit.Test;

public class TestOffByOne {
    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testEqualChars(){
        Assert.assertEquals(true, offByOne.equalChars('a','a'));
        Assert.assertEquals(false, offByOne.equalChars('a', 'b'));


    }
}
