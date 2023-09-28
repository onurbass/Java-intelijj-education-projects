import java.util.Scanner;

public class AppMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("yas gir");
        int yas = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ad gir");
        String ad=scanner.nextLine();


        Personal personal1=new Personal(ad,yas);

        System.out.println("Personelin adı => "+personal1.getIsim()+" Yaşı =>"+personal1.getYas());


    }
}
