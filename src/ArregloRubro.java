import java.util.ArrayList;
import java.util.List;

public class ArregloRubro {
    private List<Rubro> rubros;

    public ArregloRubro() {
        this.rubros = new ArrayList<>();
    }

    public boolean agregar(Rubro rubro) {
        return rubros.add(rubro);
    }

    public Rubro buscar(String nombre) {
        for (Rubro rubro : rubros) {
            if (rubro.getNombre().equalsIgnoreCase(nombre)) {
                return rubro;
            }
        }
        return null;
    }
}
