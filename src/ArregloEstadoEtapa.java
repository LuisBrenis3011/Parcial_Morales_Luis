import java.util.ArrayList;
import java.util.List;

public class ArregloEstadoEtapa {
    private List<EstadoEtapa> estadosEtapa;

    public ArregloEstadoEtapa() {
        this.estadosEtapa = new ArrayList<>();
    }

    public boolean agregar(EstadoEtapa estadoEtapa) {
        return estadosEtapa.add(estadoEtapa);
    }

    public List<EstadoEtapa> getEstadosEtapa() {
        return estadosEtapa;
    }
}
