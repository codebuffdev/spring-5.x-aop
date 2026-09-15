package in.codebuffdev.proxydp;

import java.util.Date;

public class Administration {
    public static void main(String[] args) {

//        Student std1 = new Student(new Attendance(new Date(), false));
        StudentProxy std1 = new StudentProxy(new Attendance(new Date(), false));
        std1.attendSession(); // if student is not present he shouldn't be able to attend the session
    }
}
