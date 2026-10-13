public class Experience {
    private String companyName;
    private String position;
    private String date;
    private String description;

    public Experience(String companyName, String position, String date, String description) {
        this.companyName = companyName;
        this.position = position;
        this.date = date;
        this.description = description;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getPosition() {
        return position;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }
}
