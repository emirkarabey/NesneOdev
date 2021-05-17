import java.util.Scanner;

public class Islemler implements IIslemler{

    @Override
    public int islemSec() {
        System.out.println("");
        System.out.println("Lütfen işlem seçiniz...");
        System.out.println("1-Sıcaklık Göster...");
        System.out.println("2-Soğutucuyu Aç...");
        System.out.println("3-Soğutucuyu Kapat...");
        System.out.println("4-Çıkış...");

        Scanner scanner = new Scanner(System.in);
        int secim=scanner.nextInt();
        return secim;
    }
}
