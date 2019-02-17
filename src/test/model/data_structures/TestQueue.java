package test.model.data_structures;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import model.data_structures.Cola;

public class TestQueue extends TestCase{

	protected Cola<Integer> queue;
	
	protected static final int[] ARREGLO = {350, 383, 105, 233, 140, 266, 356, 236, 80, 360, 221, 241, 130, 244, 352, 446, 18, 98, 97, 396};

	@Before
	public void setUp() throws Exception{
		queue= new Cola<Integer>();
		for(int actual: ARREGLO)
		{
			queue.enqueue(actual);
		}
	}
	
	@Test
	public void test() {
		try {
			int  i=1;
			assertEquals(20, queue.size());
			queue.enqueue(1);
			assertEquals(21, queue.size());
			queue.enqueue(2);
			assertEquals(22, queue.size());
			queue.enqueue(3);
			assertEquals(23, queue.size());
			assertEquals("350", queue.dequeue().toString());
			assertEquals(22, queue.size());
			assertEquals("383", queue.dequeue().toString());
			assertEquals(21, queue.size());
			queue.dequeue();
			assertEquals(20, queue.size());
			queue.dequeue();
			assertEquals(19, queue.size());
			queue.dequeue();
			assertEquals(18, queue.size());

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
