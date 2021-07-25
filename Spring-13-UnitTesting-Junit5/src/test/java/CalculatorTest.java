import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void add() {
        int actual =Calculator.add(2,3);
        assertEquals(5,actual);
    }


    @Test
    void testcase2(){
        assertTrue(Calculator.operator.equals("add"));

    }
}