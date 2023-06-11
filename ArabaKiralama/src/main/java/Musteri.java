import java.util.ArrayList;
import java.util.List;

public class Musteri extends Kisi {
    private List<Araba> kiralananArabalar;

    public Musteri(String isim) {
        super(isim);
        this.kiralananArabalar=new ArrayList<>();
    }

    public Musteri() {
    }

    public List<Araba> getKiralananArabalar() {
        return kiralananArabalar;
    }

    public void setKiralananArabalar(List<Araba> kiralananArabalar) {
        this.kiralananArabalar = kiralananArabalar;
    }

    @Override
    public String toString() {
        return "Musteri" + super.toString();
    }
}
