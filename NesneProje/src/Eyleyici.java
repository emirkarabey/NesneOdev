public class Eyleyici  implements IEyleyici{
    @Override
    public int sogutucuAc(int sicaklik) throws InterruptedException {

        sicaklik-=15;
        System.out.println("Soğutucu açılıyor...");
        Thread.sleep(1000);
        System.out.println("Soğutucu başarılı bir şekilde açıldı");
        return sicaklik;
    }

    @Override
    public int sogutucuyuKapat(int sicaklik) throws InterruptedException {
        sicaklik+=12;
        System.out.println("Soğutucu Kapatılıyor...");
        Thread.sleep(1000);
        System.out.println("Soğutucu başarılı bir şekilde kapatıldı");
        return sicaklik;
    }

}
