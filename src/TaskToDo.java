import java.util.Date;

public class TaskToDo {

	private String accountOwner;
	private String taskDescription;
	private Date dateCreated;
	private boolean tagged;

	public TaskToDo(String accountOwner, String taskDescription, Date dateCreated, boolean tagged) {
		this.accountOwner = accountOwner;
		this.taskDescription = taskDescription;
		this.dateCreated = dateCreated;
		this.tagged = tagged;
	}

	public String getAccountOwner() {
		return accountOwner;
	}

	public void setAccountOwner(String accountOwner) {
		this.accountOwner = accountOwner;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public boolean isTagged() {
		return tagged;
	}

	public void setTagged(boolean tagged) {
		this.tagged = tagged;
	}

	@Override
	public String toString() {
		return "TaskToDo [accountOwner=" + accountOwner + ", taskDescription=" + taskDescription + ", dateCreated="
				+ dateCreated + ", tagged=" + tagged + "]";
	}

	

}
