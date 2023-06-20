import java.util.List;

public class Departman {
    private EDepartmanlar departman;

    private List<Personel> departmandakiPersoneller;

    public Departman(EDepartmanlar departman) {
        this.departman = departman;
    }

    @Override
    public String toString() {
        return "Departman{" +
                "departman=" + departman +
                '}';
    }
}
