package hust.soict.globalict.test.disc;
import hust.soict.globalict.aims.disc.DigitalVideoDisc;

public class TestPassingParameter {
     public static void main(String[] args) {

        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        System.out.println("Before swap:");
        System.out.println("jungle dvd title: "+ jungleDVD.getTitle());
        System.out.println("cindrella dvd title: "+ cinderellaDVD.getTitle());

        swap(jungleDVD, cinderellaDVD);

        System.out.println("After swap:");
        System.out.println("jungle dvd title: "+ jungleDVD.getTitle());
        System.out.println("cindrella dvd title: "+ cinderellaDVD.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());

        System.out.println("After changeTitle:");
        System.out.println("jungle dvd title: "+ jungleDVD.getTitle());
    }

    public static void swap(DigitalVideoDisc x, DigitalVideoDisc y) {
        DigitalVideoDisc temp = x;
        x = y;
        y = temp;
    }

    public static void changeTitle(DigitalVideoDisc dvd, String newTitle) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(newTitle);
        dvd = new DigitalVideoDisc(oldTitle);
    }
}
