public class Education {
    private String schoolName;
    private String department;
    private String date;

    public Education(String schoolName, String department, String date) {
        this.schoolName = schoolName;
        this.department = department;
        this.date = date;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public String getDepartment() {
        return department;
    }

    public String getDate() {
        return date;
    }
}
