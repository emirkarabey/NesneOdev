import java.util.Random;

public class SicaklikAlgilayici extends ISicaklikAlgilayici{

    public SicaklikAlgilayici(){
        Random random = new Random();
        sicaklik = random.nextInt(40);
    }
    @Override
    public int sicaklikGoster() {
        return sicaklik;
    }
}
