import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class TaskManagementTest {
	
	TaskManagement tm;
	Account acc;
	ArrayList<Account> accounts = new ArrayList<>();
	
	@Before
	public void setUp() {
		tm = new TaskManagement();
		acc = new Account(500, "1234");
		accounts.add(acc);
		
	}

	@Test
	public void shouldReturnTrueWhenAccountNumberPreExists() {
		boolean condition = tm.accountNumberExists(500, accounts);
		assertTrue(condition);
	}
	
	@Test
	public void shouldReturnTrueWhenPasswordMatchOnLogIn() {
		boolean condition = tm.logIn(500, "1234", accounts);
		assertTrue(condition);
	}

}
