package mylist;

import static org.junit.Assert.*;
import org.junit.Test;

public class MyListTest {

	@Test(expected = IllegalArgumentException.class)
	public void addAppendsElement() {
		MyList<Integer> mlist = new MyList<Integer>();
		assertEquals(0, mlist.size());
		assertEquals(true, mlist.add(1));
		assertEquals(1, mlist.size());
		assertEquals(true, mlist.add(2));
		assertEquals(2, mlist.size());
		mlist.add(null);
	}

	// @Test
	// public void addInsertsElement() {
	// 	MyList<Integer> mlist = new MyList<Integer>();
	// 	// assert mlist.size() == 0;
	// 	assertEquals(true, mlist.add(1));
	// 	// assert mlist.size() == 1;
	// }

}
