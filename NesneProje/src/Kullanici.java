public class Kullanici implements Observer {

    int sicaklik;
    @Override
    public void update(Observable observable) {
        if(sicaklik<0){
            System.out.println("İçerisi çok soğudu...");
        }else if(sicaklik>60){
            System.out.println("İçerisi çok sıcak...");
        }

    }
}
