import java.util.List;

public class Departman {
    private String departman;

    private List<Personel> departmandakiPersoneller;

    public Departman(String departman) {
        this.departman = departman;
    }

    @Override
    public java.lang.String toString() {
        return "Departman{" +
                "departman=" + departman +
                ", departmandakiPersoneller=" + departmandakiPersoneller +
                '}';
    }
}
