package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CurrencyTest {
	Currency SEK, DKK, NOK, EUR;
	
	@Before
	public void setUp() throws Exception {
		/* Setup currencies with exchange rates */
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);
	}

	@Test
	public void testGetName() {
		assertEquals("should be SEK","SEK",SEK.getName());
	}
	
	@Test
	public void testGetRate() {
		assertEquals("should be 0.15",new Double(0.15),SEK.getRate());
	}
	
	@Test
	public void testSetRate() {
		SEK.setRate(0.30);
		assertEquals("should be 0.30",new Double(0.30),SEK.getRate());
	}
	
	@Test
	public void testGlobalValue() {
		assertEquals("should be 150",new Integer(150),EUR.universalValue(100));
	}
	
	@Test
	public void testValueInThisCurrency() {
		assertEquals("should be 10",new Integer((int)(100*0.15/1.5)),SEK.valueInThisCurrency(100, EUR));
	}

}
