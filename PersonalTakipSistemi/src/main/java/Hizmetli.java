import java.time.LocalDate;

public class Hizmetli extends Personel {
    private static int idNo=1;
    private String id;
    public Hizmetli(String isim, int yas, float maas, LocalDate iseGiris) {
        super(isim, yas, maas, iseGiris);

        this.id="H-"+idNo++;
        PersonelManager.getPersoneller().put(this.id,this);
        setDepartman(PersonelManager.getDepartmanlar().get(0));
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static int getIdNo() {
        return idNo;
    }

    public static void setIdNo(int idNo) {
        Hizmetli.idNo = idNo;
    }
}
