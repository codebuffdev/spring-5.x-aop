package in.codebuffdev.proxydp;

public class Student implements DailySession {

    private Attendance attendance;

    public Student(Attendance attendance) {
        this.attendance = attendance;
    }

    public Attendance getAttendance() {
        return attendance;
    }

    public void setAttendance(Attendance attendance) {
        this.attendance = attendance;
    }

    @Override
    public void attendSession() {
        // to prevent absent student from attending the session we need to have a validation logic
        // we don't want it here (write it the proxy class)
        System.out.println("Student attending Session");
    }
}
