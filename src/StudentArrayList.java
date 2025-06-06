import java.util.*;

class Student {
    private String name;
    private int age;
    String uni;

    public Student(String name, int age, String uni) {
        this.name = name;
        this.age = age;
        this.uni = uni;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
public class StudentArrayList {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Sharan", 25, "Wright State"));
        students.add(new Student("Kou", 24, "MIT"));
        students.add(new Student("Likith", 24, "Stanford"));

        for (Student student : students) {
            System.out.println("Name: " + student.getName() + ", Age: " + student.getAge() + ", University: " + student.uni);
        }

        // Sorting the list based on age
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Integer.compare(s1.getAge(), s2.getAge());
            }
        });
        System.out.println("\nSorted by age:");
        for (Student student : students) {
            System.out.println("Name: " + student.getName() + ", Age: " + student.getAge() + ", University: " + student.uni);
        }
    }

}
