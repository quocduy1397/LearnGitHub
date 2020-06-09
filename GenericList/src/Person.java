import java.time.LocalDate;

public class Person {
	
	private int ID;
	private String Name;
	private String Phone;
	private LocalDate Birthday;
	
	public Person() {
		super();
		ID = 0;
		Name = "Input Name";
		Phone = "Input PhoneNumber";
		Birthday = LocalDate.now();
	}
	
	public Person(int iD, String name, String phone, LocalDate birthday) {
		super();
		ID = iD;
		Name = name;
		Phone = phone;
		Birthday = birthday;
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public LocalDate getBirthday() {
		return Birthday;
	}
	public void setBirthday(LocalDate birthday) {
		Birthday = birthday;
	}
	
}
