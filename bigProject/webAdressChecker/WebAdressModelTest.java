package bigProject.webAdressChecker;

import static org.junit.Assert.*;

import org.junit.Test;

public class WebAdressModelTest {
	WebAdressModel wm = new WebAdressModel();
	@Test
	public void testIsValidAdress() {

//		assertEquals(wm.isValidAdress("192.168.1.121"), true);
//		assertEquals(wm.isValidAdress("127.0.0.1"), true);
		assertTrue(wm.isValidAdress("fhnw.ch"));
		assertFalse(wm.isValidAdress("hallo"));
		assertFalse(wm.isValidAdress("0"));
		assertTrue(wm.isValidAdress("2001:0db8:85a3:08d3:1319:8a2e:0370:7344"));
//		assertFalse(wm.isValidAdress("2001:0db8:85a3:08d3:1319:8a2e:0370:734"));
	}

	@Test
	public void testIsValidPort() {
		assertFalse(wm.isValidPort("0"));
		assertFalse(wm.isValidPort("-500"));
		assertFalse(wm.isValidPort("hallo345"));
		assertTrue(wm.isValidPort("500"));
	}

}
