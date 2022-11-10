package testmodul2;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;


public class ManagerStudent  {
    private ArrayList<Student> students ;
    public ManagerStudent(){
       students = readFile();
    }

    public void addStudent(ArrayList<Gender> genders ,Scanner scanner){
        try {
            System.out.println("Nhập mã sinh viên");
            int id  = Integer.parseInt(scanner.nextLine());
            System.out.println("Nhập tên sinh viên");
            String name = scanner.nextLine();
            System.out.println("Nhập tuổi sinh viên");
            int age = Integer.parseInt(scanner.nextLine());
            System.out.println("Nhập giới tính");
            Gender gender = getGenderByIndex( genders, scanner) ;
            System.out.println("Nhập địa chỉ");
            String address = scanner.nextLine();
            System.out.println("Nhập điểm trung bình :");
            Double averageScore = Double.parseDouble(scanner.nextLine());
            students.add(new Student(id,name,age,gender,address,averageScore));

        }catch (NumberFormatException | InputMismatchException e) {
            System.out.println(e.getMessage());
        }
    }
    public void update(ArrayList<Gender> genders, Scanner scanner) {
        try {
            System.out.println("Nhập ID cần sửa: ");
            int id = Integer.parseInt(scanner.nextLine());
            Student studentUpdate;
            if ((studentUpdate = checkExist(id)) != null) {
                System.out.println("Nhập ID mới :");
                int newid = Integer.parseInt(scanner.nextLine());
                studentUpdate.setId(newid);
                System.out.println("Nhập tên mới: ");
                String name = scanner.nextLine();
                if (!name.equals("")) {
                    studentUpdate.setName(name);
                }
                System.out.println("Nhập tuối mới ");
                String age = scanner.nextLine();
                if (!age.equals("")) {
                    studentUpdate.setAge(Integer.parseInt(age));
                }
                System.out.println("Nhập giới tính :");
                Gender gender;
                if ((gender = getGenderByIndex(genders, scanner)) != null) {
                    studentUpdate.setGender(gender);
                }
                System.out.println("Nhập địa chỉ : ");
                String address = scanner.nextLine();
                if (!address.equals("")) {
                    studentUpdate.setAddress(address);
                }
                System.out.println("Nhập điểm trung bình :");
                String AverageScore = scanner.nextLine();
                if (!AverageScore.equals("")) {
                    studentUpdate.setAverageScore(Double.parseDouble(AverageScore));
                }

                writeFile();
            } else {
                System.err.println("Không có id phù hơp");
            }
        } catch (NumberFormatException | InputMismatchException e) {
            e.printStackTrace();
        }
    }
    public void delete(Scanner scanner) {
        try {
            System.out.println("Nhập sinh viên muốn xóa : ");
           int id = Integer.parseInt(scanner.nextLine());
            Student studenttDelete;
            if ((studenttDelete = checkExist(id)) != null) {
                System.out.println("Chắc chắn xóa ");
                System.out.println("1 là xóa");
                System.out.println("2 là không");
                int choice = Integer.parseInt(scanner.nextLine());

                if(choice==1){
                    System.out.println("Đã xóa");
                students.remove(studenttDelete);}
                writeFile();
            } else {
                System.err.println("Không tìm được sinh viên");
            }
        } catch (NumberFormatException | InputMismatchException e) {
            System.err.println(e.getMessage());
        }
    }
    private Gender getGenderByIndex(ArrayList<Gender> genders, Scanner scanner) {
        for (int i = 0; i < genders.size(); i++) {
            System.out.println((i + 1) + ". " + genders.get(i).getName());
        }
        System.out.println("0. Không chọn");
        int choice;
        try {
            do {
                System.out.println("Nhập lựa chọn ");
                choice = Integer.parseInt(scanner.nextLine());
                if (choice == 0) {
                    return null;
                }
                if (choice > 0 && choice <= genders.size()) {
                    return genders.get(choice - 1);
                }
                System.err.println("Mời chọn lại");
            } while (choice < 0 || choice > genders.size());
        } catch (NumberFormatException | InputMismatchException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
    private Student checkExist(int id) {
        for (Student p : students) {
            if (p.getId()== id){
                return p;
            }
        }
        return null;
    }
    public void display() {
        for (Student p : students) {
            System.out.println(p);
        }
    }

    public void sort (Scanner scanner) {
        do{
            System.out.println("1. Sắp xếp tăng dần ");
            System.out.println("2.Sắp xếp giảm dần");
            System.out.println("3.Thoát");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1: sortup();
                break;
                case 2: sortdown();
                break;
                case 3:return;
            }

        }while (true) ;

    }

    public void sortup() {
        ArrayList<Student> student = (ArrayList<Student>) students.clone();
        student.sort(Comparator.comparing(Student::getAverageScore));
        for (Student std : student) {
            System.out.println(std);
        }
    }


    public void sortdown() {
        ArrayList<Student> student = (ArrayList<Student>) students.clone();
        student.sort(Comparator.comparing(Student::getAverageScore));
        for (int i = student.size() - 1; i >= 0; i--) {
            System.out.println(student.get(i));
        }
    }
    public void writeFile() {
        File file = new File("C:\\Users\\X\\Desktop\\java\\untitled\\src\\testmodul2\\student.txt");
        try (ObjectOutputStream objectOutputStream
                     = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(students);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public ArrayList<Student> readFile() {
        File file = new File("C:\\Users\\X\\Desktop\\java\\untitled\\src\\testmodul2\\student.txt");
        ArrayList<Student> studentArrayList = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            if (fileInputStream.available() > 0) {
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                studentArrayList = (ArrayList<Student>) objectInputStream.readObject();
            }
            return studentArrayList;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return studentArrayList;
    }

}
