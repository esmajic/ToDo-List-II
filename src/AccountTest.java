import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AccountTest {

		Account account;

		@Before
		public void setUp() {
			int accountNumber = 1000;
			String password="0000";
			account = new Account(accountNumber,password);
		}
		
		@Test
		public void shouldReturnNameWhenMethodInvoked() {
			int accountNumber = 500;
			assertEquals(500, accountNumber);
		}
		
		@Test
		public void shouldSetNameWhenMethodInvoked() {
			int accountNumber = 500;
			account.setAccountNumber(accountNumber);
			assertEquals(500, accountNumber);
		}
		
		@Test
		public void shouldReturnPasswordWhenMethodInvoked() {
			String password = "0000";
			assertEquals("0000", password);
		}
		
		@Test
		public void shouldSetPasswordWhenMethodInvoked() {
			String password = "0000";
			account.setPassword(password);
			assertEquals(account.getPassword(), password);
		}
		
		@Test
		public void shouldReturnStringOfObjectWhenMethodInvoked() {
			String string = account.toString();
			assertEquals(string,account.toString());
		}
	}
	
