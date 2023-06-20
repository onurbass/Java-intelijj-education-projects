import java.time.LocalDate;

public class BuroPersoneli extends Personel {
private static int idNo=1;
    private String id;

    public BuroPersoneli(String isim, int yas, float maas, LocalDate iseGiris) {
        super(isim, yas, maas, iseGiris);

        this.id="BP-"+idNo++;
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
        BuroPersoneli.idNo = idNo;
    }
}
