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
        //System.out.println(personelManager.departmanlar);
        GenelMudur genelMudur = new GenelMudur("fsfs",31,1000f, LocalDate.of(1998,5,6));
        System.out.println(PersonelManager.personeller);
    }

    public  void departmanOlustur() {
        EDepartmanlar[] departman = EDepartmanlar.values();

        for (int i = 0; i < departman.length; i++) {
            this.departmanlar.add(new Departman(departman[i]));
        }

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
