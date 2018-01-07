package bigProject.webAdressChecker;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class WebAdressModelTest {

	@Before
	public void setUp() throws Exception {
		System.out.println("HelloWorld");
	}

	@Test
	public void testIsValidAdress() {
		WebAdressModel wm = new WebAdressModel();
		assertTrue(false);
		assertTrue(wm.isValidAdress("127.0.0.1"));
		assertFalse(wm.isValidAdress("11170505"));
	}

}
