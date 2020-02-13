import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {
    StudentArrayDeque<Integer> student = new StudentArrayDeque<>();
    ArrayDequeSolution<Integer> solution = new ArrayDequeSolution<>();

    @Test
    public void testStudentDeque(){
        Boolean outPut = true;
        while (outPut == true){
            double r = StdRandom.uniform();
            if(r < 0.1){
                outPut = (student.isEmpty() == solution.isEmpty());
            }
            if((r > 0.1) &&(r < 0.2)){
                if ((student != null)&&(solution != null)) {
                    outPut = (student.removeFirst() == solution.removeFirst());
                }
            }
            if(r > 0.2){
                student.addFirst(2);
                solution.addFirst(2);

            }
        }
    }

}
