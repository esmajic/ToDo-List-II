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

	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws ParseException, IOException {

		ArrayList<Account> accounts = new ArrayList<>();
		ArrayList<TaskToDo> tasks = new ArrayList<>();

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

		try {
			do {
				System.out.println(
						"\n=========================================" + "\n=         To Do Application             ="
								+ "\n=========================================");

				System.out.println("Enter 1 to create Account" + "\nEnter 2 to log-in to your Account"
						+ "\nEnter 3 to list all created Accounts" + "\nEnter 4 to delete Account"
						+ "\nEnter 0 to Exit");

				System.out.print("\nPlease, select desired operation: ");
				select = input.nextInt();

				if (select == 1) {

					TaskManagement account = new TaskManagement();
					account.createAccount(accounts);

				} else if (select == 2) {

					TaskManagement login = new TaskManagement();
					login.logInProcess(accounts, tasks);

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

		} catch (Exception exc) {
			System.out.println("We have a problem!");
		}

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
