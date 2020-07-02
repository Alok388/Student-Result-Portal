package test;

import java.util.*;

public class Teacher {

	private int id;
	private String name;
	private String password;
	private String student_marks;

	private List<String> marks;
	private List<String> subject_list = new ArrayList<String>();
	private List<Student> student_list = new ArrayList<Student>();

	private Map<Integer, List<String>> stmarks = new HashMap<Integer, List<String>>(); // subject id and marks

	Scanner teacher_input = new Scanner(System.in);

	// GETTERS AND SETTERS FOR NAME,PASSWORD AND ID.
	public int getId() {

		return id; // returns teacher id
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {

		return name; // RETURNS NAME
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {

		return password; // RETURNS PASSWORD
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStudent_marks() {
		student_marks = teacher_input.next();
		return student_marks;
	}

	public void setStudent_marks(String student_marks) {
		this.student_marks = student_marks;
	}

	// METHOD TO ADD RESULT

	public void add_Result(Admin admin) {
		student_list = admin.studentlist();
		subject_list = admin.subject();

		try {

			for (int i = 0; i < student_list.size(); i++) {

				System.out.println("Enter marks for student id: " + admin.studentlist().get(i).getId());
				id = student_list.get(i).getId(); // GET STUDENT ID

				marks = new ArrayList<String>();

				for (int j = 1; j <= subject_list.size(); j++) {
//					
					System.out.println("Enter marks for subject: " + j);

					student_marks = this.getStudent_marks();
					this.setStudent_marks(student_marks);
					marks.add(student_marks); // ADD MARKS TO MARKS ARRAYLIST

				}

				getStmarks().put(id, marks);// TO STORE OBJECT OF EACH STUDENTS SUBJECTS MARKS

			}
		} catch (Exception e) {
			System.out.println("Problem while adding Result..");
		}

	}

	// TO SHOW REPORT OF STUDENTS

	public void show_result() {

		System.out.println("id\t subjects");
		System.out.println();

		try {

			String subject_format = subject_list.toString();
			/*
			 * subject returns like [sub1,sub2,sub3] so to remove braces ([]) and ,used
			 * replace method and substring method
			 */
			subject_format = subject_format.substring(1, subject_format.length() - 1);
			subject_format = subject_format.replace(",", " ");
			System.out.println("\t" + subject_format);

			System.out.println();

			for (Map.Entry<Integer, List<String>> entry : stmarks.entrySet()) {

				String mark = entry.getValue().toString(); // to remove braces[] from list returned by map
				mark = mark.substring(1, mark.length() - 1);

				System.out.println(entry.getKey() + "\t" + mark);
			}
		} catch (Exception e) {
			System.out.println("problem while adding student result" + e);
		}
	}

	public Map<Integer, List<String>> getStmarks() {
		return stmarks;
	}

	public void setStmarks(Map<Integer, List<String>> stmarks) {
		this.stmarks = stmarks;
	}
}
