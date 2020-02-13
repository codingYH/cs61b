package es.datastructur.synthesizer;

import edu.princeton.cs.algs4.StdAudio;

import java.util.LinkedList;
import java.util.List;

//Note: This file will not compile until you complete task 1 (BoundedQueue).
public class GuitarString {
    /** Constants. Do not change. In case you're curious, the keyword final
     * means the values cannot be changed at runtime. */
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .996; // energy decay factor

    /* Buffer for storing sound data. */
    private BoundedQueue<Double> buffer;

    /* Create a guitar string of the given frequency.  */
    public GuitarString(double frequency) {
        buffer = new ArrayRingBuffer<>((int)Math.round(SR/frequency));
        for(int i = 0; i < buffer.capacity(); i++){
            buffer.enqueue(0.0);
        }
    }


    /* Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() {
        List<Double> bl = new LinkedList<>();
        for(int i = 0; i < buffer.capacity(); i++){
            buffer.dequeue();
            double r = Math.random() - 0.5;
            //random numbers are different from each other.
            while (bl.contains(r)) {
                r = Math.random() - 0.5;
            }
            bl.add(r);
            buffer.enqueue(r);
        }
    }

    /* Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm.
     */
    public void tic() {
            double b1 = buffer.dequeue();
            double b2 = buffer.peek();
            double br = (b1 + b2) * 0.5 * DECAY;
            buffer.enqueue(br);
    }

    /* Return the double at the front of the buffer. */
    public double sample() {
        return buffer.peek();
    }
}
