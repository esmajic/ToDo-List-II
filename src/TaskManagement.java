import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class TaskManagement {

	public void createAccount(ArrayList<Account> accounts) {
		int accountNumber;
		TaskManagement number = new TaskManagement();
		System.out.println("\nProcess of account creation:");
		System.out.println("\nYour account number will be created randomly.");
		do {
			accountNumber = (int) (Math.random() * 1000) + 1;
		} while (number.accountNumberExists(accountNumber, accounts));
		String password = "";
		do {
			if (password.length() == 0) {
				System.out.print("\nCreate your password:  ");
				MainToDo.input.nextLine();
				password = MainToDo.input.nextLine();
			} else {
				System.out.println("Password must consist four digits! Please, create password:  ");
				password = MainToDo.input.nextLine();
			}
		} while (password.length() != 4 || !number.passwordNumeric(password));
		Account account = new Account(accountNumber, password);
		accounts.add(account);
		System.out.println("\nAccount with account number " + accountNumber + " has been successfully created.");
	}

	public void logInProcess(ArrayList<Account> accounts, ArrayList<TaskToDo> tasks) throws ParseException {

		System.out.println("\n=============================" + "\n=     Account Log-in        ="
				+ "\n=============================" + "\nPlease, enter your account number:  ");
		int accountNumber = MainToDo.input.nextInt();
		System.out.print("\nPlease, enter your PIN code to log-in to your account:  ");
		MainToDo.input.nextLine();
		String password = MainToDo.input.nextLine();
		TaskManagement todo = new TaskManagement();
		if (todo.logIn(accountNumber, password, accounts)) {
			System.out.println("\nYou've been successfully logged in.");
			int option;
			do {
				System.out.println("\n===================================" + "\n=         Task Management         ="
						+ "\n===================================" + "\n  Enter 1 to Create task"
						+ "\n  Enter 2 to Edit task" + "\n  Enter 3 to Delete task" + "\n  Enter 4 to Tag/Untag task"
						+ "\n  Enter 5 to List all tasks" + "\n  Enter 6 to List tagged tasks"
						+ "\n  Enter 0 to Exit Task Management" + "\n=================================="
						+ "\nPlease, enter number for desired operation: ");
				option = MainToDo.input.nextInt();

				if (option == 1) {

					System.out.println("\nCreating task process...");
					System.out.println("Enter account owner's name:  ");
					MainToDo.input.nextLine();
					String name = MainToDo.input.nextLine();
					System.out.println("Enter task description:  ");
					String taskDescription = MainToDo.input.nextLine();
					DateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy");
					System.out.println("\nEnter date of task creation (dd-MM-yyyy):  ");
					String creationDate = MainToDo.input.nextLine();
					Date dateTaskCreated = myFormat.parse(creationDate);
					boolean tagged = false;
					TaskToDo task = new TaskToDo(name, taskDescription, dateTaskCreated, tagged);
					tasks.add(task);
					System.out.println("\nTask has been successfully created.");

				} else if (option == 2) {
					System.out.println("\nEditing task process...");
					System.out.print("Enter task index as per list to be edited:  ");
					int taskListNumber = MainToDo.input.nextInt();
					System.out.println("Enter new description for desired task:  ");
					MainToDo.input.nextLine();
					String taskDescription = MainToDo.input.nextLine();
					todo.editExistingTask(taskListNumber, taskDescription, tasks);
					System.out.println("\nTask has been successfully edited.");

				} else if (option == 3) {
					System.out.println("\nDeleting task process...");
					System.out.print("Enter task index as per list to be deleted:  ");
					int taskListNumber = MainToDo.input.nextInt();
					todo.deleteExistingTask(taskListNumber, tasks);
					System.out.println("\nTask has been successfully deleted.");

				} else if (option == 4) {
					System.out.println("\nTagging/Untagging task process... ");
					if (tasks.size() != 0) {
						System.out.print("Enter task index as per list to be tagged/untagged:  ");
						int taskIndexNumber = MainToDo.input.nextInt() - 1;
						todo.tagUntagTask(taskIndexNumber, tasks);
					}

				} else if (option == 5) {
					System.out.println("\nListing all tasks...(run option again for reversed order): ");
					if (tasks.size() != 0) {
						todo.listAllTasks(tasks);
					}

				} else if (option == 6) {
					todo.listTaggedTasks(tasks);

				} else if (option == 0) {
					System.out.println("Thank you for using Task Management.");
				}

			} while (option != 0);
		} else {
			System.out.println("\nWrong account number and/or password has been entered. Try again.");
		}
	}

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

	public int numberOfTaggedTasks(ArrayList<TaskToDo> tasks) {
		int counter = 0;
		for (int i = 0; i < tasks.size(); i++) {
			if (tasks.get(i).isTagged()) {
				counter++;
			}
		}
		return counter;
	}

	public void listTaggedTasks(ArrayList<TaskToDo> tasks) {
		System.out.println("\nList of all tagged tasks:  ");
		if (numberOfTaggedTasks(tasks) == 0) {
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
