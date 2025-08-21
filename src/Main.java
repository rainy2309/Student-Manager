import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Xóa sinh viên");
            System.out.println("3. Tìm sinh viên");
            System.out.println("4. In danh sách");
            System.out.println("5. Sắp xếp theo GPA");
            System.out.println("6. Thoát");
            System.out.print("Chọn: ");
            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Nhập ID: ");
                    String id = sc.nextLine();
                    System.out.print("Nhập tên: ");
                    String name = sc.nextLine();
                    System.out.print("Nhập tuổi: ");
                    int age = sc.nextInt();
                    System.out.print("Nhập GPA: ");
                    double gpa = sc.nextDouble();
                    sc.nextLine(); // clear buffer
                    Student s = new Student(id, name, age, gpa);
                    manager.addStudent(s);
                    System.out.println("Thêm thành công!");
                    break;

                case 2:
                    System.out.print("Nhập ID để xóa: ");
                    String idRemove = sc.nextLine();
                    if (manager.removeStudent(idRemove)) {
                        System.out.println("Xóa thành công!");
                    } else {
                        System.out.println("Không tìm thấy sinh viên.");
                    }
                    break;

                case 3:
                    System.out.print("Nhập ID để tìm: ");
                    String idFind = sc.nextLine();
                    Student found = manager.findStudent(idFind);
                    if (found != null) {
                        System.out.println("Tìm thấy: " + found);
                    } else {
                        System.out.println("Không tìm thấy sinh viên.");
                    }
                    break;

                case 4:
                    manager.printAll();
                    break;

                case 5:
                    manager.sortByGPA();
                    System.out.println("Danh sách sau khi sắp xếp theo GPA:");
                    manager.printAll();
                    break;

                case 6:
                    System.out.println("Thoát chương trình.");
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}
