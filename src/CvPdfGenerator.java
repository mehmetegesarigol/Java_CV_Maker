import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.File;
import java.io.IOException;

public class CvPdfGenerator {

    public void generateCV(Person person) {
        try {
            // PDF dokümanı ve A4 sayfası oluştur
            PDDocument document = new PDDocument();
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            // Font ayarları (Türkçe karakterler için sistemdeki Arial fontunu kullan)
            PDFont regularFont;
            PDFont boldFont;

            File arialFile = new File("C:/Windows/Fonts/arial.ttf");
            File arialBoldFile = new File("C:/Windows/Fonts/arialbd.ttf");

            if (arialFile.exists() && arialBoldFile.exists()) {
                regularFont = PDType0Font.load(document, arialFile);
                boldFont = PDType0Font.load(document, arialBoldFile);
            } else {
                regularFont = PDType1Font.HELVETICA;
                boldFont = PDType1Font.HELVETICA_BOLD;
            }

            PDPageContentStream cs = new PDPageContentStream(document, page);

            float y = 770;
            float margin = 50;

            // Fotoğraf ekleme (varsa profile.jpg dosyasını ekler)
            File photoFile = new File("profile.jpg");
            if (!photoFile.exists()) {
                photoFile = new File("src/profile.jpg");
            }

            if (photoFile.exists()) {
                try {
                    PDImageXObject image = PDImageXObject.createFromFileByExtension(photoFile, document);
                    cs.drawImage(image, 450, y - 60, 85, 85);
                } catch (Exception e) {
                    System.out.println("Fotoğraf eklenirken bir hata oluştu: " + e.getMessage());
                }
            }

            // Ad ve Soyad
            cs.beginText();
            cs.setFont(boldFont, 20);
            cs.newLineAtOffset(margin, y);
            cs.showText(person.getFullName());
            cs.endText();

            y -= 25;

            // İletişim Bilgileri
            cs.beginText();
            cs.setFont(regularFont, 10);
            cs.newLineAtOffset(margin, y);
            cs.showText("E-posta: " + person.getEmail() + "  |  Tel: " + person.getPhone() + "  |  Şehir: " + person.getCity());
            cs.endText();

            y -= 20;

            // Ayırıcı çizgi
            cs.setLineWidth(1);
            cs.moveTo(margin, y);
            cs.lineTo(545, y);
            cs.stroke();

            y -= 30;

            // Hakkımda Bölümü
            cs.beginText();
            cs.setFont(boldFont, 13);
            cs.newLineAtOffset(margin, y);
            cs.showText("Hakkımda");
            cs.endText();

            y -= 18;

            cs.beginText();
            cs.setFont(regularFont, 10);
            cs.newLineAtOffset(margin, y);
            cs.showText(person.getAbout());
            cs.endText();

            y -= 35;

            // Eğitim Bölümü
            cs.beginText();
            cs.setFont(boldFont, 13);
            cs.newLineAtOffset(margin, y);
            cs.showText("Eğitim");
            cs.endText();

            y -= 20;

            if (person.getEducation() != null) {
                Education edu = person.getEducation();

                cs.beginText();
                cs.setFont(boldFont, 11);
                cs.newLineAtOffset(margin, y);
                cs.showText(edu.getSchoolName() + " - " + edu.getDepartment());
                cs.endText();

                cs.beginText();
                cs.setFont(regularFont, 10);
                cs.newLineAtOffset(430, y);
                cs.showText(edu.getDate());
                cs.endText();

                y -= 30;
            }

            // İş Deneyimleri Bölümü
            cs.beginText();
            cs.setFont(boldFont, 13);
            cs.newLineAtOffset(margin, y);
            cs.showText("İş Deneyimleri");
            cs.endText();

            y -= 20;

            for (Experience exp : person.getExperiences()) {
                cs.beginText();
                cs.setFont(boldFont, 11);
                cs.newLineAtOffset(margin, y);
                cs.showText(exp.getPosition() + " - " + exp.getCompanyName());
                cs.endText();

                cs.beginText();
                cs.setFont(regularFont, 10);
                cs.newLineAtOffset(430, y);
                cs.showText(exp.getDate());
                cs.endText();

                y -= 15;

                cs.beginText();
                cs.setFont(regularFont, 10);
                cs.newLineAtOffset(margin, y);
                cs.showText("- " + exp.getDescription());
                cs.endText();

                y -= 25;
            }

            y -= 5;

            // Yetenekler Bölümü
            cs.beginText();
            cs.setFont(boldFont, 13);
            cs.newLineAtOffset(margin, y);
            cs.showText("Yetenekler");
            cs.endText();

            y -= 20;

            for (Skill skill : person.getSkills()) {
                cs.beginText();
                cs.setFont(regularFont, 10);
                cs.newLineAtOffset(margin, y);
                cs.showText("- " + skill.getSkillName() + " (" + skill.getLevel() + ")");
                cs.endText();

                y -= 16;
            }

            cs.close();

            // Çıktı klasörünü kontrol et ve dosyayı kaydet
            File outputDir = new File("output");
            if (!outputDir.exists()) {
                outputDir.mkdir();
            }

            document.save("output/Mehmet_Ege_Sarigol_CV.pdf");
            document.close();

            System.out.println("PDF CV successfully created.");

        } catch (IOException e) {
            System.out.println("PDF oluşturulurken hata meydana geldi: " + e.getMessage());
        }
    }
}
