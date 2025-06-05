package Session_10.bai_1;

public class Student {
    private String studentName;
    private int studentAge;
    private double studentAvgScore;

    public Student(String studentName, int studentAge, double studentAvgScore) {
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.studentAvgScore = studentAvgScore;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    public double getStudentAvgScore() {
        return studentAvgScore;
    }

    public void setStudentAvgScore(float studentAvgScore) {
        this.studentAvgScore = studentAvgScore;
    }

    @Override
    public String toString() {
        return "Tên: " + studentName + ", Tuổi: " + studentAge + ", Điểm trung bình: " + studentAvgScore;
    }
}
