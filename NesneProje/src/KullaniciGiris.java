import javax.xml.transform.Result;
import java.sql.*;
import java.util.Locale;
import java.util.Scanner;

public class KullaniciGiris implements IKullaniciGiris {

    Scanner scanner=null;
    String kullaniciAdi,sifre;

    public KullaniciGiris(){
        scanner = new Scanner(System.in);
    }

    public KullaniciGiris(Builder builder) {
        this.scanner = new Scanner(System.in);
        this.kullaniciAdi = builder.kullaniciAdi;
        this.sifre = builder.sifre;
    }


    public Scanner getScanner() {
        return scanner;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public static class Builder{

        private String kullaniciAdi, sifre;

        public Builder(){ }

        public Builder name(String kullaniciAdi){
            this.kullaniciAdi = kullaniciAdi;
            return this;
        }

        public Builder surname(String sifre){
            this.sifre = sifre;
            return this;
        }

        public KullaniciGiris build(){
            return new KullaniciGiris(this);
        }

    }


    @Override
    public void girisYap() {
        while(true){

            System.out.println("Kullanici Adi Giriniz: ");
            kullaniciAdi = scanner.next();
            System.out.println("Şifre Giriniz: ");
            sifre = scanner.next();

            try {
                Class.forName("org.postgresql.Driver");
            } catch (Exception e) {
                System.err.println("Hata: "+ e);
            }

            try {

                Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sicaklik","postgres", "1234");
                Statement statement = c.createStatement();
                ResultSet rs = statement.executeQuery("SELECT * FROM sicaklikDeger");
                rs.next();
                String user = rs.getString("kullanici");
                rs = statement.executeQuery("SELECT * FROM sicaklikDeger");
                rs.next();
                String password = rs.getString("password");
                if(user.equals(kullaniciAdi) && password.equals(sifre)){
                    System.out.println("Kullanıcı Doğrulanıyor Lütfen Bekleyiniz...");
                    Thread.sleep(1000);
                    System.out.println("Kullanici Dogrulandi...");
                    System.out.println("Veri Tabanına Bağlanıldı...");
                    break;
                }else{
                    System.out.println("Kullanıcı Doğrulanıyor Lütfen Bekleyiniz...");
                    Thread.sleep(1000);
                    System.out.println("Kullanıcı Doğrulanamadı...Lütfen Tekrar Deneyiniz");
                    System.out.println("Veri tabanına bağlanılamadı...");
                }

            } catch (SQLException | InterruptedException throwables) {
                throwables.printStackTrace();
            }

        }
        }



    }

