import java.util.*;
public class StudentManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        boolean running = true;

        while (running) {
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Remove Student");
            System.out.println("4. Sort Students by Age");
            System.out.println("5.Search for Student");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    try{
                        System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter university: ");
                    String uni = scanner.nextLine();
                    students.add(new Student(name, age, uni));
                    break;}
                    catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid input.");
                        scanner.nextLine();
                    }
                case 2:

                    if (students.isEmpty()) {
                        System.out.println("No students found in the list.");
                        break;
                        
                    }
                    else {for (Student student : students) {
                        System.out.println("Name: " + student.getName() + ", Age: " + student.getAge() + ", University: " + student.uni);
                    }
                    break;}
                case 3:
                    System.out.print("Enter name of student to remove: ");
                    String nameToRemove = scanner.nextLine();
                    boolean removed = false;
                    for (Student student : students) {
                        if (student.getName().equalsIgnoreCase(nameToRemove)) {
                            students.remove(student);
                            System.out.println("Student removed.");
                            removed = true;
                            break;
                        }
                    }
                    if (!removed) {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    Collections.sort(students, new Comparator<Student>() {
                        @Override
                        public int compare(Student s1, Student s2) {
                            return Integer.compare(s1.getAge(), s2.getAge());
                        }
                    });
                    System.out.println("Students sorted by age.");
                    break;
                case 5:
                    System.out.print("Enter name to search: ");
                    String searchName = scanner.nextLine();
                    boolean found = false;
                    for (Student student : students) {
                        if (student.getName().equalsIgnoreCase(searchName)) {
                            System.out.println("Student found: Name: " + student.getName() + ", Age: " + student.getAge() + ", University: " + student.uni);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student not found.");
                    }
                    break;

                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

}
