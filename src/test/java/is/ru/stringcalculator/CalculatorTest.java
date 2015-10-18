package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }
	
	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}
	
	@Test
    public void testOneNumber2(){
    	assertEquals(3, Calculator.add("3"));
    }
	
	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}	
	

	@Test
    public void testMultipleNumbers(){
    	assertEquals(10, Calculator.add("1,2,3,4"));
    }
	
	@Test
    public void testMultipleLines(){
    	assertEquals(6, Calculator.add("1\n2,3"));
    }
	
	@Test
    public void testDelimiter(){
    	assertEquals(3, Calculator.add("//;\n1;2"));
    }
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
    public void testNegativeNumbers() throws RuntimeException{
    	thrown.expect(RuntimeException.class);
		thrown.expectMessage("Negatives not allowed:");
		Calculator.add("-1,2");
    }
	
	@Test
    public void testMultipleNegativeNumbers() throws RuntimeException{
    	thrown.expect(RuntimeException.class);
		thrown.expectMessage("Negatives not allowed: -1,-100,-9");
		Calculator.add("-1,2,-100,20,-9");
    }
	
	@Test
    public void testNumbersTooBig(){
    	assertEquals(2, Calculator.add("1001,2"));
    }
	
	@Test
    public void testLargerDelimiter(){
    	assertEquals(6, Calculator.add("//[***]\n1***2***3"));
    }
	
	@Test
    public void testMultipleDelimiters(){
    	assertEquals(6, Calculator.add("//[*][%]\n1*2%3"));
    }
	
}