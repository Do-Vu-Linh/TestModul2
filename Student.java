package testmodul2;

import java.io.Serializable;

public class Student implements Serializable {

    private  int id;
    private  String name;
    private  int age;
    private Gender gender;
    private String address;
    private Double averageScore;

    public Student(int id, String name, int age, Gender gender, String address, Double averageScore) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.averageScore = averageScore;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(Double averageScore) {
        this.averageScore = averageScore;
    }

    @Override
    public String toString() {
        return "Sinh viên{" +
                "id=" + id +
                ", tên ='" + name + '\'' +
                ", tuổi =" + age +
                ", giới tính=" + gender.getName() +
                ", địa chỉ ='" + address + '\'' +
                ", điểm trung bình=" + averageScore +
                '}';
    }

}
