import java.util.ArrayList;
import java.util.Collections;

public class TaskManagement {

	public boolean logIn(int accountNumber, String password, ArrayList<Account> accounts) {
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getAccountNumber() == accountNumber) {
				if (accounts.get(i).getPassword().equals(password)) {
					return true;
				}
			}
		}

		return false;
	}

	public boolean accountNumberExists(int accountNumber, ArrayList<Account> accounts) {
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getAccountNumber() == accountNumber) {
				return true;
			}
		}
		return false;
	}

	public void editExistingTask(int taskListNumber, String taskTextEdit, ArrayList<TaskToDo> tasks) {
		if (tasks.size() > 0) {
			tasks.get(taskListNumber - 1).setTaskDescription(taskTextEdit);
		} else {
			System.out.println("There are no tasks in our task data base");
		}
	}

	public void deleteExistingTask(int taskListNumber, ArrayList<TaskToDo> tasks) {
		if (tasks.size() != 0) {
			tasks.remove(taskListNumber - 1);
			System.out.println("\nTask has been successfully deleted.");
		} else
			System.out.println("\nTasks list is empty.");
	}

	public void deleteExistingAccount(int accountListNumber, ArrayList<Account> accounts) {
		if (accounts.size() != 0) {
			accounts.remove(accountListNumber - 1);
			System.out.println("\nAccount has been successfully deleted.");
		} else
			System.out.println("\nAccounts list is empty.");
	}

	public void listAllTasks(ArrayList<TaskToDo> tasks) {
		Collections.reverse(tasks);
		if (tasks.size() == 0) {
			System.out.println("Task list is empty.");
		} else {
			for (int i = 0; i < tasks.size(); i++) {
				System.out.println((i + 1) + ". Name:  " + tasks.get(i).getAccountOwner() + ", Task description: "
						+ tasks.get(i).getTaskDescription() + ", created on:  " + tasks.get(i).getDateCreated()
						+ ", Task is tagged?  " + tasks.get(i).isTagged());
			}
		}
	}

	public void listOfAllAccounts(ArrayList<Account> accounts) {
		System.out.println("\nList of all created accounts:  ");
		if (accounts.size() == 0) {
			System.out.println("\nThere are no created accounts. List is empty.");
		} else {
			for (int i = 0; i < accounts.size(); i++) {
				System.out.println((i + 1) + ". Account number: " + accounts.get(i).getAccountNumber() + ", PIN code:  "
						+ accounts.get(i).getPassword());
			}
		}
	}

	public void tagUntagTask(int taskIndexNumber, ArrayList<TaskToDo> tasks) {
		if (tasks.get(taskIndexNumber).isTagged() == false) {
			tasks.get(taskIndexNumber).setTagged(true);
			System.out.println("\nTask is successfully tagged.");
		} else if (tasks.get(taskIndexNumber).isTagged() == true) {
			tasks.get(taskIndexNumber).setTagged(false);
			System.out.println("\nTask is successfully un-tagged.");
		}
	}

	public void listTaggedTasks(ArrayList<TaskToDo> tasks) {
		System.out.println("\nList of all tagged tasks:  ");
		if (tasks.size() == 0) {
			System.out.println("\nThere are no tasks in the list.");
		} else {
			for (int i = 0; i < tasks.size(); i++) {
				if (tasks.get(i).isTagged() == true) {
					System.out.println((i + 1) + ". Account owner: " + tasks.get(i).getAccountOwner()
							+ ", Task Description:  " + tasks.get(i).getTaskDescription() + ", Date created: "
							+ tasks.get(i).getDateCreated() + ", Task tagged? : " + tasks.get(i).isTagged());
				}
			}
		}
	}

	public boolean passwordNumeric(String password) {
		int counter = 0;
		for (int i = 0; i < password.length(); i++) {
			if (Character.isDigit(password.charAt(i))) {
				counter++;
			}
		}
		if (counter == password.length()) {
			return true;
		} else {
			return false;
		}

	}

}
