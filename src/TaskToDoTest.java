import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TaskToDoTest {

	TaskToDo todo;

	@Before
	public void setUp() {
		String accountOwner = "Ervin";
		String taskDescription = "coding";
		boolean tagged = false;
		todo = new TaskToDo(accountOwner, taskDescription, null, tagged);
	}

	@Test
	public void shouldReturnAccountOwnerNameWhenMethodInvoked() {
		String accountOwner = "Ervin";
		assertEquals("Ervin", accountOwner);
	}

	@Test
	public void shouldSetAccountOwnerNameWhenMethodInvoked() {
		String accountOwner = "Ervin";
		todo.setAccountOwner(accountOwner);
		assertEquals("Ervin", accountOwner);
	}

	@Test
	public void shouldReturnTaskDescriptionWhenMethodInvoked() {
		String taskDescription = "coding";
		assertEquals("coding", taskDescription);
	}

	@Test
	public void shouldSetTaskDescriptionWhenMethodInvoked() {
		String taskDescription = "coding";
		todo.setTaskDescription(taskDescription);
		assertEquals("coding", taskDescription);
	}

	@Test
	public void shouldReturnTaggedWhenMethodInvoked() {
		boolean tagged = false;
		assertEquals(false, tagged);
	}

	@Test
	public void shouldSetTaggedWhenMethodInvoked() {
		boolean tagged = false;
		todo.setTagged(tagged);
		assertEquals(false, tagged);
	}

	@Test
	public void shouldReturnStringOfObjectWhenMethodInvoked() {
		String string = todo.toString();
		assertEquals(string, todo.toString());
	}

}
