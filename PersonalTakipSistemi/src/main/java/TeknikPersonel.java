import java.time.LocalDate;

public class TeknikPersonel extends Personel {
    private static int idNo=1;
    private String id;



    public TeknikPersonel(String isim, int yas, float maas, LocalDate iseGiris) {
        super(isim, yas, maas, iseGiris);

        this.id="TP-"+idNo++;
        PersonelManager.getPersoneller().put(this.id,this);
        setDepartman(PersonelManager.getDepartmanlar().get(5));
    }

    public static int getIdNo() {
        return idNo;
    }

    public static void setIdNo(int idNo) {
        TeknikPersonel.idNo = idNo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "TeknikPersonel{} " + super.toString();
    }
}
