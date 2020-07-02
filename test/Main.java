package test;

import java.util.*;

public class Main {

	private Teacher teacherobj = new Teacher();
	private Student st = new Student();
	private Admin admin = new Admin();

	private Status status;
	private String user, pass;
	private int id;
	private int input;

	Scanner sc2 = new Scanner(System.in);

	private boolean log_status;// to check status received from Status class

	public Main() {
		System.out.println("\n\n\t\t------------------------STUDENT RESULT PORTAL----------------------------\n\n");

	}

	// METHOD TO PERFROM THE OPERATIONS
	public void menu() {

		System.out.println("\t\t\t\nchoose 1.Admin\t  2.Teacher\t3.student");

		status = new Status();
		input = sc2.nextInt();

		try {
			// to make methods accesible according to user input.

			if (input == 1) { // FOR ADMIN OPERATIONS

				int admin_input;

				System.out.println(" login first!!\n");

				System.out.println("Enter User Name");

				user = sc2.next(); // get username of admin
				admin.setName(user);

				System.out.println("Enter id: ");
				id = sc2.nextInt();// get id of admin
				admin.setId(id);

				System.out.println("Enter Password\t default password :admin");
				pass = sc2.next(); // get password of admin
				admin.setPassword(pass);

				log_status = status.getadmin_status(user, pass); // RETURNS TRUE OR FALSE ACCORDING TO THE PROVIDED
																	// INPUT

				// if user is logged in then proceed further else login first
				if (log_status == true) {

					do {

						System.out.println(
								"select\t0.logout\t1.Add Student\t 2.Add Teachers 3.Add Subject\t 4.Assign Teachers");
						admin_input = sc2.nextInt();

						if (admin_input == 1) {
							admin.Add_students(); // CALL THE METHOD TO ADD STUDENT

						} else if (admin_input == 2) {
							admin.Add_teachers(); // CALL METHOD TO ADD TEACHERS
						} else if (admin_input == 3) {
							admin.add_subject(); // CALL METHOD TO CREATE SUBJECTS

						} else if (admin_input == 4) {
							admin.assign_teachers(); // CALL METHOD TO ASSIGN TEACHERS
						}
					} while (admin_input != 0); // CONTINUE TILL USER LOGS OUT
				}
			}

			else if (input == 2) {

				// FOR TEACHER OPERATIONS
				int teacher_input;

				System.out.println(" login first!!\n");

				System.out.println("Enter Username: ");
				user = sc2.next(); // get teacher's username

				System.out.println("Enter id: ");
				id = sc2.nextInt(); // get teacher's id assigned by admin

				System.out.println("Enter Password: ");
				pass = sc2.next(); // get teacher's password assigned by admin

				teacherobj = status.getteacher_status(user, pass, admin); // RETURNS TRUE OR FALSE ACCORDING TO PROVIDED

				// INFO

				if (log_status == true) {
					do {

						System.out.println("select :\t0.log out\t1.add result\t2.Generate result");

						teacher_input = sc2.nextInt(); // input of choices

						if (teacher_input == 1) {
							teacherobj.add_Result(admin);
							; // CALLS METHOD TO CREATE OR GENERATE REPORT OF STUDENTS

						} else if (teacher_input == 2) {
							teacherobj.show_result(); // SHOWS THE LIST OF STUDENTS WITH SUBJECT NAME AND MARKS
						}

					} while (teacher_input != 0); // UNTIL TEACHER LOGS OUT CONTINUE
				}

			}

			else if (input == 3) {

				int student_input;

				System.out.println(" login first!!\n");

				System.out.println("Enter Username: ");
				user = sc2.next(); // get student's username

				System.out.println("Enter password: ");
				pass = sc2.next(); // get student's password

				st = status.getstudent_status(user, pass, admin); // RETURNS TRUE IF USERNAME AND PASSWORD IS
																	// CORRECT

				if (log_status == true) {

					do {

						System.out.println("select: 0.log out\t1.show result");
						student_input = sc2.nextInt();

						if (student_input == 1) {
							st.myresult(admin, teacherobj);
							;// METHOD TO GET STUDENT REPORT

						}

					} while (student_input != 0); // CONTINUE UNTIL STUDENTS LOGS OUT
				}
			}

			else {
				System.out.println("Enter again....");
			}

		} catch (Exception e) {
			System.out.println("Problem with main menu.." + e); // CHECK REUNTIME EXCEPTION
		}
	}

	public static void main(String[] args) throws Exception {
		Main m = new Main();

		do {
			m.menu();
		} while (m.input != 0);

	}

}
