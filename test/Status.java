package test;

import java.util.ArrayList;
import java.util.List;

public class Status {

	private String admin_password = "admin"; // STATIC PASSWORD RESERVED FOR ADMIN ONLY

	private String username, userpassword;

	private List<Student> student_list = new ArrayList<Student>();
	private List<Teacher> teacher_list = new ArrayList<Teacher>();

	// Methods to return login status

	// returns admin login status
	public boolean getadmin_status(String user_name, String password) throws Exception {

		if (password.equals(admin_password)) {

			System.out.println("Welcome " + user_name);// SHOW ADMIN NAME
			System.out.println("you have successfully logged in...\n"); // SHOW STATUS SUCCESS OR NOT
			return true;

		} else {
			System.out.println("try again");
			return false;
		}
	}

	// returns status of teacher login
	public Teacher getteacher_status(String user_name, String password, Admin admin) {

		teacher_list = admin.teacherlist();

		try {

			for (Teacher t : teacher_list) {

				if (user_name.equals(t.getName())) {

					username = teacher_list.get(t.getId()).getName(); // SEARCH FOR USERNAME
					userpassword = teacher_list.get(t.getId()).getPassword(); // VALID PASSWORD

					return t;
				}

			}
		} catch (Exception e) {
			System.out.println("problem with teacher login...");
			e.printStackTrace();
		}

		if (password.equals(userpassword) && username.equals(user_name)) { // MATCHES USERNAME AND PASSWORD

			System.out.println("Welcome " + user_name); // PRINT USERNAME
			System.out.println("you have successfully logged in...");

		} else {
			System.out.println("try again");

		}
		return null;

	}

	// returns status of student login
	public Student getstudent_status(String user_name, String password, Admin add) {
		student_list = add.studentlist();
		try {

			for (Student s : student_list) {

				if (user_name.equals(s.getName())) {

					username = student_list.get(s.getId()).getName();// CHECKS FOR VALID STUDENT NAME
					userpassword = student_list.get(s.getId()).getPassword(); // CHECKS FOR VALID PASSWORD ASSIGNED BY
																				// ADMIN
					return s;

				}

			}
		} catch (Exception e) {
			System.out.println("problem with student login..");
		}

		if (password.equals(userpassword) && username.equals(user_name)) { // CHECK WHETHER PASSWORD AND USERNAME
																			// MATCHES

			System.out.println("Welcome " + user_name); // SHOW USERNAME
			System.out.println("you have successfully logged in...");

		} else {
			System.out.println("try again");

		}
		return null;

	}

}
