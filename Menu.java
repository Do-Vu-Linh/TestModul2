package testmodul2;

import testmodul2.ManagerStudent;
import testmodul2.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private static ArrayList<Gender> genders;

    static {
        genders = new ArrayList<>();
        genders.add(new Gender("Nam"));
        genders.add(new Gender("Nữ"));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManagerStudent managerStudent = new ManagerStudent();
        int choice;
        do {
            try {
                System.out.println("----CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN----");
                System.out.println("Chọn chức năng theo số(để tiếp tục");
                System.out.println("1 :Xem danh sách sinh viên");
                System.out.println("2 :Thêm mới");
                System.out.println("3 :Cập nhât");
                System.out.println("4 :Xóa");
                System.out.println("5 :Sắp xếp");
                System.out.println("6 :Đọc từ File");
                System.out.println("7 :Ghi từ File");
                System.out.println("8 :Thoát");
                System.out.println("Chọn chức năng :");

                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        managerStudent.display();

                        break;
                    case 2:
                        managerStudent.addStudent(genders, scanner);

                        break;
                    case 3:
                        managerStudent.update(genders, scanner);

                        break;
                    case 4:
                        managerStudent.delete(scanner);

                        break;
                    case 5:
                        managerStudent.sort(scanner);

                        break;
                    case 6:
                        managerStudent.readFile();

                        break;
                    case 7:
                        managerStudent.writeFile();

                        break;

                    case 8:
                        System.exit(8);

                }
            } catch (Exception e) {
                System.out.println("Nhập sai định dạng");
            }
        } while (true);
    }
}
