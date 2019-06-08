import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class MainToDo {

	public static void main(String[] args) throws ParseException, IOException {

		ArrayList<Account> accounts = new ArrayList<>();
		ArrayList<TaskToDo> tasks = new ArrayList<>();

		Scanner input = new Scanner(System.in);
		int select;

		File file1 = new File("accountsdata.txt");
		File file2 = new File("tasksdata.txt");

		if (file1.exists()) {
			System.out.println("\nFile " + file1.getName() + " alredy exists!");
			Scanner input1 = new Scanner(new FileReader(file1));
			while (input1.hasNextLine()) {
				int accountNumber = Integer.parseInt(input1.nextLine());
				String password = input1.nextLine();
				Account acc = new Account(accountNumber, password);
				accounts.add(acc);
			}
			input1.close();

		} else {
			file1 = new File("accountsdata.txt");

		}

		if (file2.exists()) {
			System.out.println("\nFile " + file2.getName() + " alredy exists!");
			Scanner input2 = new Scanner(new FileReader(file2));
			while (input2.hasNextLine()) {
				String name = input2.nextLine();
				String taskDescription = input2.nextLine();
				String creationDate = input2.nextLine();
				DateFormat mf = new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy", Locale.ENGLISH);
				Date dateTaskCreated = mf.parse(creationDate);
				boolean tagged = Boolean.parseBoolean(input2.nextLine());
				TaskToDo task = new TaskToDo(name, taskDescription, dateTaskCreated, tagged);
				tasks.add(task);
			}
			input2.close();
		} else {
			file2 = new File("tasksdata.txt");
		}

		PrintWriter output1 = new PrintWriter(file1);
		PrintWriter output2 = new PrintWriter(file2);
		
			do {
				System.out.println("\n=========================================");
				System.out.println("=         To Do Application             =");
				System.out.println("=========================================");

				System.out.println("Enter 1 to create Account");
				System.out.println("Enter 2 to log-in to your Account");
				System.out.println("Enter 3 to list all created Accounts");
				System.out.println("Enter 4 to delete Account");
				System.out.println("Enter 0 to Exit");

				System.out.print("\nPlease, select desired operation: ");
				select = input.nextInt();

				if (select == 1) {

					int accountNumber;
					TaskManagement number = new TaskManagement();
					System.out.println("\nProcess of account creation:");
					System.out.println("\nYour account number will be created randomly.");
					do {
						accountNumber = (int) (Math.random() * 1000) + 1;
					} while (number.accountNumberExists(accountNumber, accounts));
					System.out.print("\nCreate your password:  ");
					input.nextLine();
					String password = input.nextLine();
					Account account = new Account(accountNumber, password);
					accounts.add(account);
					System.out.println(
							"\nAccount with account number " + accountNumber + " has been successfully created.");

				} else if (select == 2) {
					if (accounts.size() == 0) {
						System.out.println("\nThere are no accounts in our data base. Create account to log-in.");
					} else {
						System.out.println("\n=============================");
						System.out.println("=     Account Log-in        =");
						System.out.println("=============================");
						System.out.println("\nPlease, enter your account number:  ");
						int accountNumber = input.nextInt();
						System.out.print("\nPlease, enter your PIN code to log-in to your account:  ");
						input.nextLine();
						String password = input.nextLine();
						TaskManagement todo = new TaskManagement();
						int option;
						if (todo.logIn(accountNumber, password, accounts)) {
							System.out.println("\nYou've been successfully logged in.");
							do {

								System.out.println("\n==================================");
								System.out.println("  Enter 1 to Create task");
								System.out.println("  Enter 2 to Edit task");
								System.out.println("  Enter 3 to Delete task");
								System.out.println("  Enter 4 to Tag/Untag task");
								System.out.println("  Enter 5 to List all tasks");
								System.out.println("  Enter 6 to List tagged tasks");
								System.out.println("  Enter 0 to Exit Task Management");
								System.out.println("==================================");
								System.out.println("\nPlease, enter number for desired operation: ");
								option = input.nextInt();

								if (option == 1) {

									System.out.println("\nCreating task process...");
									System.out.println("Enter account owner's name:  ");
									input.nextLine();
									String name = input.nextLine();
									System.out.println("Enter task description:  ");
									String taskDescription = input.nextLine();
									DateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy");
									System.out.println("\nEnter date of task creation (dd-MM-yyyy):  ");
									String creationDate = input.nextLine();
									Date dateTaskCreated = myFormat.parse(creationDate);
									boolean tagged = false;
									TaskToDo task = new TaskToDo(name, taskDescription, dateTaskCreated, tagged);
									tasks.add(task);
									System.out.println("\nTask has been successfully created.");

								} else if (option == 2) {
									System.out.println("\nEditing task process...");
									System.out.print("Enter task index as per list to be edited:  ");
									int taskListNumber = input.nextInt();
									System.out.println("Enter new description for desired task:  ");
									input.nextLine();
									String taskDescription = input.nextLine();
									todo.editExistingTask(taskListNumber, taskDescription, tasks);
									System.out.println("\nTask has been successfully edited.");

								} else if (option == 3) {
									System.out.println("\nDeleting task process...");
									System.out.print("Enter task index as per list to be deleted:  ");
									int taskListNumber = input.nextInt();
									todo.deleteExistingTask(taskListNumber, tasks);
									System.out.println("\nTask has been successfully deleted.");

								} else if (option == 4) {
									System.out.println("\nTagging/Untagging task process... ");
									if (tasks.size() != 0) {
										System.out.print("Enter task index as per list to be tagged/untagged:  ");
										int taskIndexNumber = input.nextInt() - 1;
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
				} else if (select == 3) {
					TaskManagement list = new TaskManagement();
					list.listOfAllAccounts(accounts);
				} else if (select == 4) {
					TaskManagement list = new TaskManagement();
					System.out.print("Enter Account list number:  ");
					int accountListNumber = input.nextInt();
					list.deleteExistingAccount(accountListNumber, accounts);
				}

			} while (select != 0);

		for (int i = 0; i < accounts.size(); i++) {
			output1.println(accounts.get(i).getAccountNumber());
			output1.println(accounts.get(i).getPassword());
		}
		output1.close();
		for (int i = 0; i < tasks.size(); i++) {
			output2.println(tasks.get(i).getAccountOwner());
			output2.println(tasks.get(i).getTaskDescription());
			output2.println(tasks.get(i).getDateCreated());
			output2.println(tasks.get(i).isTagged());
		}
		output2.close();

		System.out.println("\nThank You for using our services. Bye bye.");
		input.close();

	}

}
