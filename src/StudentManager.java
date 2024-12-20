import java.util.ArrayList;
import java.util.Scanner;
class Student {
    private String name;
    private int age;
    private double score;
    public Student(String name, int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public double getScore() {
        return score;
    }
    public void display() {
        System.out.println("Tên: " + name + " Tuổi: " + age + " Điểm: " + score);
    }
}
public class StudentManager {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    public static void addStudent() {
        System.out.print("Nhập tên: ");
        String name = sc.nextLine();
        System.out.print("Nhập tuổi: ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập điểm: ");
        double score = Double.parseDouble(sc.nextLine());
        students.add(new Student(name, age, score));
        System.out.println("Đã thêm rồi đấy");
    }
    public static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("Không có khứa nào trong danh sách");
            return;
        }
        System.out.println("Danh sách sinh viên:");
        for (Student student : students) {
            student.display();
        }
    }
    public static void searchStudent() {
        System.out.print("Nhập tên sinh viên: ");
        String name = sc.nextLine();
        boolean found = false;
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                student.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không thấy ai tên " + name);
        }
    }
    public static void deleteStudent() {
        System.out.print("Nhập tên sinh viên cần xóa: ");
        String name = sc.nextLine();
        boolean removed = students.removeIf(student -> student.getName().equalsIgnoreCase(name));
        if (removed) {
            System.out.println("Xóa xong rồi đấy");
        } else {
            System.out.println("Không thấy ai tên " + name);
        }
    }
    public static void main(String[] args) {
        while (true) {
            System.out.println("===== MENU =====");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Hiển thị danh sách sinh viên");
            System.out.println("3. Tìm sinh viên theo tên");
            System.out.println("4. Xóa sinh viên theo tên");
            System.out.println("5. Thoát chương trình");
            System.out.print("Thích số nào: ");

            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Chọn lại đi!??!?");
            }
        }
    }
}
