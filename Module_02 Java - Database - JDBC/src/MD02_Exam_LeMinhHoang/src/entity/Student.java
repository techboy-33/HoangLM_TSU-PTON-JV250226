package entity;

import java.util.Date;

public class Student {
    private int student_id;
    private String full_name;
    private String email;
    private String phone_number;
    private Date register_date;
    private Boolean status;

    public Student() {
    }

    public Student(int student_id, String full_name, String email, String phone_number, Date register_date, Boolean status) {
        this.student_id = student_id;
        this.full_name = full_name;
        this.email = email;
        this.phone_number = phone_number;
        this.register_date = register_date;
        this.status = status;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Date getRegister_date() {
        return register_date;
    }

    public void setRegister_date(Date register_date) {
        this.register_date = register_date;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("Mã Sv: %s - Tên Sv: %s - email: %s \n" +
                        "Số điện thoại: %s - Ngày đăng ký: %s - Trạng thái: %s\n",
                student_id, full_name, email, phone_number, register_date, this.status ? "Hoạt động" : "Không hoạt động");
    }
}
