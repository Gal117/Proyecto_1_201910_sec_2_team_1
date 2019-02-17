package test.model.data_structures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import model.data_structures.Pila;

public class TestStack {

	private Pila<Integer> stack;
	
	protected static final int[] ARREGLO= {350, 383, 105, 233, 140, 266, 356, 236, 80, 360, 221, 241, 130, 244, 352, 446, 18, 98, 97, 396};

	@Before
	public void setUp() throws Exception{
		stack= new Pila<Integer>();
		for(int actual: ARREGLO)
		{
			stack.push(actual);
		}
	}
	
	@Test
	public void test() {
		try {
			assertEquals(20, stack.size());
			stack.push(1);
			assertEquals(21, stack.size());
			stack.push(2);
			assertEquals(22, stack.size());
			stack.push(3);
			assertEquals(23, stack.size());
			assertEquals("3", stack.pop().toString());
			assertEquals(22, stack.size());
			assertEquals("2", stack.pop().toString());
			assertEquals(21, stack.size());
			stack.pop();
			assertEquals(20, stack.size());
			stack.pop();
			assertEquals(19, stack.size());
			stack.pop();
			assertEquals(18, stack.size());

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
