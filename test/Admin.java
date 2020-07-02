package test;

import java.util.*;

public class Admin {

	private int id;
	private String name;
	private String password;

	private List<Student> stlist = new ArrayList<Student>();

	private List<Teacher> teachlist = new ArrayList<Teacher>();

	private Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();

	private List<String> sublist = new ArrayList<String>();

	private Student st;
	private Teacher tch;

	Scanner admin_input = new Scanner(System.in);

	private List<String> list;
	private List<String> check = new ArrayList<>();

	// getters and setters for name,password and iD.

	public int getId() {

		return id; // returns Admin id
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {

		return name; // returns Admin name
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {

		return password; // returns Admin password
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// method to create list of students
	public void Add_students() {

		int stnum;

		System.out.println("Enter the number of students to be added:");
		stnum = admin_input.nextInt(); // number of students to add
		try {

			for (int i = 0; i < stnum; i++) {

				st = new Student();

				System.out.println("Enter Name of student: ");
				name = admin_input.next();

				st.setName(name); // store name into student object

				System.out.println("Enter the Id: ");
				id = admin_input.nextInt();
				st.setId(id); // store id into student object

				System.out.println("Assign password");
				password = admin_input.next();
				st.setPassword(password);
				boolean b = validatestudent(name, password);
				if (b != true) {
					stlist.add(st);

				} else {
					break;
				}
			}

		} catch (Exception e) {
			System.out.println("Try again....");

		}

	}

	private boolean validatestudent(String name2, String password2) {

		for (Student e : stlist) {
			if (name2.equals(e.getName()) && password2.equals(e.getPassword())) {
				System.out.println(" Teacher Already exists..");
				return true;
			}

		}

		return false;
	}

	// method to create list of teachers

	public void Add_teachers() {

		int teach_num;
		System.out.println("Enter number of teachers you want to add");
		teach_num = admin_input.nextInt();
		try {

			for (int i = 0; i < teach_num; i++) {
				tch = new Teacher();
				System.out.println("Enter name of Teacher:");

				name = admin_input.next(); // username

				tch.setName(name); // store name into teacher's object

				System.out.println("Enter id: ");
				id = admin_input.nextInt();
				tch.setId(id); // store id into teacher's object

				System.out.println("Enter password: ");
				password = admin_input.next(); // Assign password
				tch.setPassword(password); // store password into teacher's object
				boolean b = validateteach(name, password);
				if (b != true) {
					teachlist.add(tch);

				} else {
					break;
				}

			}

		} catch (Exception e) {
			System.out.println("Error... try again"); // to catch any exception during runtime
		}
	}

	private boolean validateteach(String name2, String password2) {

		for (Teacher e : teachlist) {
			if (name2.equals(e.getName()) && password2.equals(e.getPassword())) {
				System.out.println(" Name Already exists");
				return true;
			}

		}
		return false;

	}

	// method to create subject

	public void add_subject() {
		int sub_num;
		String sub_name;

		System.out.println("Enter the Number of Subjects you want to Add: ");
		sub_num = admin_input.nextInt(); // number of subject
		try {

			for (int i = 0; i < sub_num; i++) {
				System.out.println("Enter the Name of Subject: ");
				sub_name = admin_input.next();
				sublist.add(sub_name);
			}

		} catch (Exception e) {
			System.out.println("Something wrong...");
		}

	}

	public List<String> subject() {
		return sublist; // returns list of subject
	}

	public List<Student> studentlist() {
		return stlist; // returns studentlist
	}

	public List<Teacher> teacherlist() {
		return teachlist; // returns teacherlist;
	}

	// method which assigns teachers to students

	public void assign_teachers() {
		int input = 0;
		boolean b;
		try {
			for (int i = 0; i < teacherlist().size(); i++) {

				System.out.println("Enter the Number of student you want to assign..");
				input = admin_input.nextInt();
				list = new ArrayList<>();

				for (int j = 0; j < input; j++) {
					System.out.println("Enter Name of Student");
					name = admin_input.next();

					b = validateName(name);
					if (b != true) {
						check.add(name); // list for test
						list.add(name); // distinct student only

					} else {
						break;
					}

				}
				map.put(teacherlist().get(i).getId(), list);

			}

			System.out.println("ID\tStudent Name");
			for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {

				String student_name = entry.getValue().toString(); // to remove braces[] from list returned by map
				student_name = student_name.substring(1, student_name.length() - 1);

				System.out.println(entry.getKey() + "\t" + student_name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean validateName(String name2) {

		for (String s : check) {
			if (s.equals(name2)) {
				System.out.println("Student is already Assigned...");
				return true;
			}

		}

		return false;
	}

}