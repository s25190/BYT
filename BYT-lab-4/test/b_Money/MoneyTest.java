package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MoneyTest {
	Currency SEK, DKK, NOK, EUR;
	Money SEK100, EUR10, SEK200, EUR20, SEK0, EUR0, SEKn100;
	
	@Before
	public void setUp() throws Exception {
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);
		SEK100 = new Money(10000, SEK);
		EUR10 = new Money(1000, EUR);
		SEK200 = new Money(20000, SEK);
		EUR20 = new Money(2000, EUR);
		SEK0 = new Money(0, SEK);
		EUR0 = new Money(0, EUR);
		SEKn100 = new Money(-10000, SEK);
	}

	@Test
	public void testGetAmount() {
		assertEquals("test get amount regular", new Integer(1000), EUR10.getAmount());
		assertEquals("test get amount zero", new Integer(0), EUR0.getAmount());
	}

	@Test
	public void testGetCurrency() {
		assertEquals("test get currency", EUR, EUR10.getCurrency());
	}

	@Test
	public void testToString() {
		assertEquals("test toString zero", "0 EUR", EUR0.toString());
		assertEquals("test toString", "10 EUR", EUR10.toString());
	}

	@Test
	public void testGlobalValue() {
		assertEquals("test GlobalValue SEK", new Integer(1500), SEK100.universalValue());
		assertEquals("test GlobalValue EUR", new Integer(3000), EUR20.universalValue());
	}

	@Test
	public void testEqualsMoney() {
		assertEquals("test equals false", false, EUR20.equals(SEK100));
	}

	@Test
	public void testAdd() {
		assertEquals("test add SEK + EUR", "200 SEK", SEK100.add(EUR10).toString());
	}

	@Test
	public void testSub() {
		assertEquals("test sub negative", "-100 SEK", SEK100.sub(SEK200).toString());
	}

	@Test
	public void testIsZero() {
		assertEquals("test is zero true", true, SEK0.isZero());

	}

	@Test
	public void testNegate() {
		assertEquals("test negate", "-100 SEK", SEK100.negate().toString());

	}

	@Test
	public void testCompareTo() {
		assertEquals("test compare eq", 0, SEK100.compareTo(SEK100));
		assertEquals("test compare less", -1, SEK100.compareTo(EUR20));
		assertEquals("test comapre more", +1, SEK200.compareTo(SEK0));
	}
}
