import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class TaskManagementTest {
	
	TaskManagement tm;
	Account acc;
	TaskToDo ttd;
	ArrayList<Account> accounts = new ArrayList<>();
	ArrayList<TaskToDo> tasks = new ArrayList<>();
	
	@Before
	public void setUp() {
		tm = new TaskManagement();
		ttd = new TaskToDo("Ervin", "coding", null, true);
		tasks.add(ttd);
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
	
	@Test
	public void shouldReturnTrueWhenPasswordIsFourDigits() {
		boolean condition = tm.passwordNumeric("1234");
		assertTrue(condition);
	}
	
	@Test
	public void shouldReturnTrueWhenNumberOfTaggedTasksExists() {
		int result = tm.numberOfTaggedTasks(tasks);
		assertEquals(1, result);
	}


}
