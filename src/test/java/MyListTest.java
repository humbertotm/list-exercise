package mylist;

import static org.junit.Assert.*;
import org.junit.Test;

public class MyListTest {

	@Test
	public void addAppendsElement() {
		MyList<Integer> mlist = new MyList<Integer>();
		// assert mlist.size() == 0;
		assertEquals(true, mlist.add(null));
		// assert mlist.size() == 1;
	}

	// @Test
	// public void addInsertsElement() {
	// 	MyList<Integer> mlist = new MyList<Integer>();
	// 	// assert mlist.size() == 0;
	// 	assertEquals(true, mlist.add(1));
	// 	// assert mlist.size() == 1;
	// }

}
