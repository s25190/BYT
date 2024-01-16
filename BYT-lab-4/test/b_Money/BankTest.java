package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BankTest {
	Currency SEK, DKK;
	Bank SweBank, Nordea, DanskeBank;
	
	@Before
	public void setUp() throws Exception {
		DKK = new Currency("DKK", 0.20);
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		Nordea = new Bank("Nordea", SEK);
		DanskeBank = new Bank("DanskeBank", DKK);
		SweBank.openAccount("Ulrika");
		SweBank.openAccount("Bob");
		Nordea.openAccount("Bob");
		DanskeBank.openAccount("Gertrud");
	}

	@Test
	public void testGetName() {
		assertEquals("should return DanskeBank", "DanskeBank",  DanskeBank.getName());
	}

	@Test
	public void testGetCurrency() {
		assertEquals("should return SEK", "SEK" ,  Nordea.getCurrency().getName());
	
	}

	@Test
	public void testOpenAccount() throws AccountExistsException, AccountDoesNotExistException {
		DanskeBank.openAccount("kub");
		//assertEquals("should return true", "kub" ,  DanskeBank.getBalance("kub"));

	}

	@Test
	public void testDeposit() throws AccountDoesNotExistException {
		SweBank.deposit("Bob", new Money(10000, SEK));
		SweBank.deposit("Bob", new Money(10000, SEK));
		assertEquals( new Integer(20000) ,  SweBank.getBalance("Bob"));
	
	}

	@Test
	public void testWithdraw() throws AccountDoesNotExistException {
		SweBank.deposit("Bob", new Money(10000, SEK));
		SweBank.withdraw("Bob", new Money(10000, SEK));
		assertEquals( new Integer(0) ,  SweBank.getBalance("Bob"));
		SweBank.withdraw("Bob", new Money(20000, SEK));
	}
	
	@Test
	public void testGetBalance() throws AccountDoesNotExistException {
		assertEquals( new Integer(0) ,  SweBank.getBalance("Ulrika"));
		
	}
	
	@Test
	public void testTransfer() throws AccountDoesNotExistException {
		SweBank.deposit("Ulrika", new Money(10000, SEK));
		SweBank.transfer("Ulrika", "Bob", new Money(10000, SEK));    
		assertEquals("transfer fromAccount balance", new Integer(0) ,  SweBank.getBalance("Ulrika"));
		assertEquals("transfer toAccount balance", new Integer(10000) ,  SweBank.getBalance("Bob"));
		SweBank.transfer("Ulrika", "Bob", new Money(10000, SEK));
		assertEquals("transfer fromAccount balance", new Integer(0) ,  SweBank.getBalance("Ulrika"));
		assertEquals("transfer toAccount balance", new Integer(10000) ,  SweBank.getBalance("Bob"));
	}
	
	@Test
	public void testTimedPayment() throws AccountDoesNotExistException {
		fail("Write test case here");
	}
}
