package test;

import java.util.*;

public class Student {

	private int id;
	private String name;
	private String password;

	private Map<Integer, List<String>> map;
	private List<String> subject_list = new ArrayList<String>();

	Scanner student_input = new Scanner(System.in);

	// GETTERS AND SETTERS FOR STUDENT NAME,ID,PASSWORD
	public int getId() {

		return id; // returns student id

	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {

		return name; // returns student name
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {

		return password; // returns student password
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// method to print student result according to user id
	public void myresult(Admin admin, Teacher teacher) {
		subject_list = admin.subject();
		map = teacher.getStmarks();
		System.out.println(" Enter your id:");

		try {

			id = student_input.nextInt(); // to get student id

			String value = map.get(id).toString(); /*
													 * to remove braces [] because it prints direct list object
													 */
			value = value.substring(1, value.length() - 1);
			System.out.println();

			for (int i = 0; i < subject_list.size(); i++) {

				System.out.print(subject_list.get(i) + " ");
			}

			System.out.println();
			System.out.println(value); // prints the marks in different subjects

		} catch (Exception e) {
			System.out.println("problem with student result.." + e); // for runtime exception
		}
	}
}
