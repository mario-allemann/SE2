package bigProject.webAdressChecker;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class WebAdressModelTest {

	@After
	public void setUp() throws Exception {
		System.out.println("HelloWorld");
	}

	@Test
	public void testIsValidAdress() {
		WebAdressModel wm = new WebAdressModel();
		try {
			int i = Integer.parseInt("H");
			fail();
		} catch (Exception e) {
			assertTrue(true);
		}
		
		assertTrue(wm.isValidAdress("127.0.0.1"));
		assertFalse(wm.isValidAdress("11170505"));
	}

}
