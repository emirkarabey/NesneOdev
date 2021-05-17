public class AgArayuzu {

    private IKullaniciGiris kullaniciGiris;
    private IIslemler islemler;
    private SicaklikAlgilayici sicaklikAlgilayici;
    private IEyleyici eyleyici;

    int sicaklik=-1;
    int islem=0;
    public AgArayuzu() throws InterruptedException {
       kullaniciGiris = new KullaniciGiris();
       islemler = new Islemler();
       sicaklikAlgilayici = new SicaklikAlgilayici();
       eyleyici = new Eyleyici();
       kullaniciGiris.girisYap();

       while(true){
           islem = islemler.islemSec();
           if(islem==1){
               System.out.println("Sıcaklık Ölçülüyor...");
               Thread.sleep(2000);
               sicaklik = sicaklikAlgilayici.sicaklik;
               System.out.println("Suanki sıcaklık: "+ sicaklik);
           }else if(islem == 2){
               sicaklik = eyleyici.sogutucuAc(sicaklik);
               sicaklikAlgilayici.sicaklik = sicaklik;
           }else if(islem == 3){
               sicaklik = eyleyici.sogutucuyuKapat(sicaklik);
                sicaklikAlgilayici.sicaklik = sicaklik;
           }else if(islem ==4){
               System.out.println("Sistemden çıkış yapılıyor...");
               Thread.sleep(1000);
               System.out.println("Çıkış yapıldı...");
               break;
           }else{
               System.out.println("Lütfen geçerli bir seçim yapınız...");
           }
       }
    }

}
