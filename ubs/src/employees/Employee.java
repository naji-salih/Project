package employees;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Employee {

	private long id;
	private String name;
	private String lastName;
	private String birthDate;
	private String role;
	private String department;
	private String email;
	private static final AtomicLong counter = new AtomicLong(100);
	private static final List<Employee> employeeList = new ArrayList<Employee>();

	public Employee(String name, String lastName, String birthDate, String role, String department, String email,
			long id) {
		this.name = name;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.role = role;
		this.department = department;
		this.email = email;
		this.id = id;
	}

	public Employee(String name, String lastName, String birthDate, String role, String department, String email) {
		this.name = name;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.role = role;
		this.department = department;
		this.email = email;
		this.id = counter.incrementAndGet();
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static AtomicLong getCounter() {
		return counter;
	}

	public static List<Employee> getEmployeelist() {
		return employeeList;
	}

	static {
		employeeList.add(new Employee("John", "Smith", "12-12-1980", "Manager", "Sales", "john.smith@abc.com"));
		employeeList.add(new Employee("Laura", "Adams", "02-11-1979", "Manager", "IT", "laura.adams@abc.com"));
		employeeList
				.add(new Employee("Peter", "Williams", "22-10-1966", "Coordinator", "HR", "peter.williams@abc.com"));
		employeeList
				.add(new Employee("Joana", "Sanders", "11-11-1976", "Manager", "Marketing", "joana.sanders@abc.com"));
		employeeList.add(new Employee("John", "Drake", "18-08-1988", "Coordinator", "Finance", "john.drake@abc.com"));
		employeeList.add(
				new Employee("Samuel", "Williams", "22-03-1985", "Coordinator", "Finance", "samuel.williams@abc.com"));
	}

	public static List<Employee> getListInstance() {
		return employeeList;
	}
}
