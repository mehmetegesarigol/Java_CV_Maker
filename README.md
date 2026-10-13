# Java PDF Özgeçmiş (CV) Oluşturucu

Bu proje, **Nesne Yönelimli Programlama (OOP)** prensipleri kullanılarak Java dilinde geliştirilmiş, konsol tabanlı ve fotoğraflı bir PDF özgeçmiş (CV) oluşturma uygulamasıdır. 

Uygulama herhangi bir grafik arayüze (GUI) ihtiyaç duymadan çalışır; nesne yönelimli olarak tanımlanmış kişi, eğitim, deneyim ve yetenek bilgilerini işleyerek biçimlendirilmiş bir PDF belgesi üretir.

---

## 📌 Proje Özellikleri

- **Saf Nesne Yönelimli Tasarım:** Veriler ve işlevler mantıksal sınıflara ayrılmıştır.
- **Konsol Tabanlı (CLI):** Harici GUI kütüphanelerine ihtiyaç duymadan doğrudan konsol üzerinden çalışır.
- **Ayrı PDF Servis Mimarisi:** PDF oluşturma işlemleri `Main` sınıfında değil, bağımsız `CvPdfGenerator` sınıfında yürütülür.
- **Fotoğraf Desteği:** Özgeçmişe otomatik olarak profil fotoğrafı entegre edilir.
- **Türkçe Karakter Desteği:** Arial yazı tipi ailesi kullanılarak Türkçe karakterlerin bozulmadan basılması sağlanmıştır.
- **Esnek Veri Yapısı:** `ArrayList` veri yapısı sayesinde dinamik sayıda iş deneyimi ve yetenek eklenebilir.

---

## 🏗️ Kullanılan Sınıflar, Nesneler ve Mimari Tercihler

Projede Nesne Yönelimli Programlama'nın temel yapı taşları olan **Sınıf (Class)**, **Nesne (Object)**, **Kapsülleme (Encapsulation)** ve **Kompozisyon (Composition)** ilkeleri uygulanmıştır.

| Sınıf Adı | Rolü / Sorumluluğu | Neden Ayrı Bir Sınıf Olarak Kullanıldı? |
| :--- | :--- | :--- |
| **`Person`** | Kişinin temel kimlik, iletişim, eğitim, deneyim ve yetenek verilerini barındıran ana model sınıfıdır. | Kişiye ait tüm verilerin tek bir çatı altında toplanması ve kapsüllenmesi (encapsulation) için oluşturuldu. |
| **`Education`** | Okul adı, bölüm ve mezuniyet/eğitim tarihi bilgilerini tutar. | Eğitim bilgilerinin kişiden bağımsız bir veri tipi olarak modellenmesi ve kodun modülerliğini sağlamak amacıyla oluşturuldu. |
| **`Experience`** | Şirket adı, pozisyon, çalışma tarihi ve iş tanımı bilgilerini tutar. | Bir kişinin birden fazla iş deneyimi olabileceği için her deneyimi tekil bir nesne olarak temsil etmek amacıyla oluşturuldu. |
| **`Skill`** | Yetenek adı ve yetkinlik seviyesi bilgilerini tutar. | Kişinin yetkinliklerinin esnek ve genişletilebilir bir yapıda tutulabilmesi için modellendi. |
| **`CvPdfGenerator`**| Verilen `Person` nesnesini alıp Apache PDFBox kütüphanesi yardımıyla A4 formatında PDF'e dönüştürür. | **Tek Sorumluluk Prensibi (Single Responsibility)** gereğince PDF oluşturma mantığının veri modelinden ve `Main` sınıfından tamamen ayrılması için tasarlandı. |
| **`Main`** | Uygulamanın giriş noktasıdır. Örnek nesneleri bellekte oluşturur ve PDF üretim sürecini başlatır. | Yalnızca nesne oluşturma ve tetikleme görevini üstlenir; içinde doğrudan PDF oluşturma kodu barındırmaz. |

---

## 📂 Proje Klasör Yapısı

```text
├── src/
│   ├── Main.java                 # Uygulama başlangıç sınıfı
│   ├── Person.java               # Kişi bilgi modeli
│   ├── Education.java            # Eğitim modeli
│   ├── Experience.java           # İş deneyimi modeli
│   ├── Skill.java                # Yetenek modeli
│   ├── CvPdfGenerator.java       # PDF üretim işlemlerini yürüten servis
│   └── profile.jpg               # Özgeçmiş profil fotoğrafı
│
├── lib/
│   ├── pdfbox-2.0.30.jar         # Apache PDFBox kütüphanesi
│   ├── fontbox-2.0.30.jar        # Font desteği kütüphanesi
│   └── commons-logging-1.2.jar   # Loglama kütüphanesi
│
├── output/
│   └── Mehmet_Ege_Sarigol_CV.pdf # Oluşturulan PDF çıktısı
│
├── profile.jpg                   # Kök dizin profil fotoğrafı yedeği
├── pom.xml                       # Maven bağımlılık yapılandırması
├── .gitignore                    # Git takip dışı dosyalar
└── README.md                     # Proje dokümantasyonu
```

---

## ⚙️ Gereksinimler

- **Java JDK 17** veya üzeri
- Windows işletim sistemi (Türkçe karakter font entegrasyonu için)

---

## 🚀 Projeyi Derleme ve Çalıştırma

Projeyi komut satırından (Terminal / PowerShell) çalıştırmak için proje ana dizininde şu adımları izleyebilirsiniz:

### 1. Derleme (Compile):
```powershell
javac -encoding UTF-8 -cp "lib/*" -d bin src/*.java
```

### 2. Çalıştırma (Run):
```powershell
java -cp "lib/*;bin" Main
```

### 3. Tek Satırda Derleyip Çalıştırma:
```powershell
javac -encoding UTF-8 -cp "lib/*" -d bin src/*.java; java -cp "lib/*;bin" Main
```

Program başarıyla çalıştığında konsolda şu mesaj görüntülenir:
```text
PDF CV successfully created.
```
Üretilen PDF belgesi **`output/Mehmet_Ege_Sarigol_CV.pdf`** yolunda hazır olacaktır.

---

## 📄 Lisans ve Teslim Bilgisi

Bu proje, Nesne Yönelimli Programlama dersi kapsamında hazırlanmıştır.
Tüm hakları saklıdır.
