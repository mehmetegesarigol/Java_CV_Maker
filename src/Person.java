import java.util.ArrayList;

public class Person {
    private String fullName;
    private String email;
    private String phone;
    private String city;
    private String about;
    
    private Education education;
    private ArrayList<Experience> experiences;
    private ArrayList<Skill> skills;

    public Person(String fullName, String email, String phone, String city, String about) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.city = city;
        this.about = about;
        this.experiences = new ArrayList<>();
        this.skills = new ArrayList<>();
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getCity() {
        return city;
    }

    public String getAbout() {
        return about;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public ArrayList<Experience> getExperiences() {
        return experiences;
    }

    public void addExperience(Experience experience) {
        this.experiences.add(experience);
    }

    public ArrayList<Skill> getSkills() {
        return skills;
    }

    public void addSkill(Skill skill) {
        this.skills.add(skill);
    }
}
