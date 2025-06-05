package Lession_07.bai_4;

public class Student {
    private String name;
    private int age;
    private String classRoom;
    private double avgScore;

    public Student(String name, int age, String classRoom, double avgScore) {
        this.name = name;
        this.age = age;
        this.classRoom = classRoom;
        this.avgScore = avgScore;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public double getAvgScore() {
        return avgScore;
    }
}
