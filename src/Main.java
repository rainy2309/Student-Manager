import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Student Manager =====");
            System.out.println("1. Add student");
            System.out.println("2. Show all students");
            System.out.println("3. Find student by ID");
            System.out.println("4. Delete student");
            System.out.println("5. Exit");
            System.out.print("👉 Choose: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // clear buffer
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter age: ");
                    int age = sc.nextInt();

                    Student student = new Student(id, name, age);
                    manager.addStudent(student);
                    break;

                case 2:
                    manager.showStudents();
                    break;

                case 3:
                    System.out.print("Enter ID to find: ");
                    int findId = sc.nextInt();
                    manager.findStudentById(findId);
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    int delId = sc.nextInt();
                    manager.deleteStudent(delId);
                    break;

                case 5:
                    System.out.println("👋 Goodbye!");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("⚠️ Invalid choice!");
            }
        }
    }
}
