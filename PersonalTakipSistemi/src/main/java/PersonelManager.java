import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonelManager {
    private static List<Departman> departmanlar = new ArrayList();
    private static Map<String,Personel> personeller=new HashMap<>();

    public static void main(String[] args) {
        PersonelManager personelManager = new PersonelManager();
        personelManager.departmanOlustur();
        Hizmetli hizmetli = new Hizmetli("fsfs",31,31f,LocalDate.of(1998,5,5));
        System.out.println(departmanlar);
        System.out.println(personeller);
    }

    public  void departmanOlustur() {
        departmanlar.add(new Departman("Hizmet"));
        departmanlar.add(new Departman("Teknik"));
        departmanlar.add(new Departman("Yonetim"));
        departmanlar.add(new Departman("IK"));
        departmanlar.add(new Departman("Muhasebe"));
        departmanlar.add(new Departman("Buro"));

    }



    public static <T> void kayitEt(List<T> list, T object) {
        list.add(object);
    }

    public static List<Departman> getDepartmanlar() {
        return departmanlar;
    }

    public static void setDepartmanlar(List<Departman> departmanlar) {
        PersonelManager.departmanlar = departmanlar;
    }

    public static Map<String, Personel> getPersoneller() {
        return personeller;
    }

    public static void setPersoneller(Map<String, Personel> personeller) {
        PersonelManager.personeller = personeller;
    }
}
