
public class Account {

	private int accountNumber;
	private String password;

	public Account(int accountNumber, String password) {

		this.accountNumber = accountNumber;
		this.password = password;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", password=" + password
				+ "]";
	}

}
