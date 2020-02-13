package es.datastructur.synthesizer;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(10);
        arb.enqueue(1.2);
        arb.dequeue();
        int[] someInts = new int[]{1, 2, 3};
        for (int x : someInts) {
            for (int y : someInts) {
                System.out.println("x: " + x + ", y:" + y);
            }
//        Assert.assertEquals(1.2, arb.peek());
//        Assert.assertEquals(2, arb.fillCount());
//        Assert.assertEquals(1.2, arb.dequeue());
        }
    }
}
