import java.util.*;

class Student {
    private int id;
    private String name;
    private double cgp;

    public Student(int id, String name, double cgp) {
        this.id = id;
        this.name = name;
        this.cgp = cgp; 
    }

    public String getName() {
        return name;
    }

    public double getCgp() {
        return cgp;
    }

    public int getId() {
        return id;
    }
}

class StudentComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        if (Double.compare(s1.getCgp(), s2.getCgp()) != 0) {
            return Double.compare(s2.getCgp(), s1.getCgp());
        }

        int nameCompare = s1.getName().compareTo(s2.getName());
        if (nameCompare != 0) {
            return nameCompare;
        }                                                                                                                               //2311CS020674

        return Integer.compare(s1.getId(), s2.getId()); 
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of students:");
        int n = 0;

        if (scanner.hasNextInt()) {
            n = scanner.nextInt();
        }

        List<Student> students = new ArrayList<>();

        System.out.println("Enter the details:");
        for (int i = 0; i < n; i++) {
            if (scanner.hasNextInt()) {
                int id = scanner.nextInt();
                String name = scanner.next();
                double cgp = scanner.nextDouble();
                students.add(new Student(id, name, cgp));
            }
        }

        students.sort(new StudentComparator());

        System.out.println("Output:");
        for (Student student : students) { 
            System.out.println(student.getName());
        }

        scanner.close();
    }                                                                                                                                                                    //2311CS020674

}
