public class Main {

    public static void main(String[] args) {

        // Kişi bilgileri
        Person person = new Person(
                "Mehmet Ege Sarıgöl",
                "mehmetegesarigol@gmail.com",
                "+90 505 004 62 70",
                "Kırklareli",
                "Yazılım Mühendisliği öğrencisi. Java ve nesne yönelimli programlama alanında kendini geliştiriyor."
        );

        // Eğitim bilgisi
        Education education = new Education(
                "Kırklareli Üniversitesi",
                "Yazılım Mühendisliği",
                "2025 - Halen"
        );
        person.setEducation(education);

        // İş deneyimleri 
        Experience exp1 = new Experience(
                "Nova Yazılım",
                "Junior Software Developer",
                "2026",
                "Java projelerinde temel geliştirme ve bakım çalışmalarında bulundu."
        );

        Experience exp2 = new Experience(
                "Code",
                "Java Developer Intern",
                "2025",
                "Temel Java uygulamaları ve algoritma geliştirme çalışmalarında yer aldı."
        );

        Experience exp3 = new Experience(
                "Tech",
                "Software Intern",
                "2025",
                "Yazılım ekibine uygulama testlerinde ve hata çözümlerinde destek oldu."
        );

        person.addExperience(exp1);
        person.addExperience(exp2);
        person.addExperience(exp3);

        // Yetenekler (4 adet)
        Skill skill1 = new Skill("Java", "Beginner");
        Skill skill2 = new Skill("Python", "Beginner");
        Skill skill3 = new Skill("C", "Beginner");
        Skill skill4 = new Skill("HTML / CSS", "Beginner");

        person.addSkill(skill1);
        person.addSkill(skill2);
        person.addSkill(skill3);
        person.addSkill(skill4);

        CvPdfGenerator pdfGenerator = new CvPdfGenerator();
        pdfGenerator.generateCV(person);
    }
}
