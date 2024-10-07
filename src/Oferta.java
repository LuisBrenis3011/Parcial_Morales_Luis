import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Oferta {
    private String puesto;
    private String descripcion;
    private String area;
    private Date fechaInicio;
    private Date fechaTermino;
    private List<Requisito> requisitos;

    public Oferta(String puesto, String descripcion, String area, Date fechaInicio, Date fechaTermino) {
        this.puesto = puesto;
        this.descripcion = descripcion;
        this.area = area;
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
        this.requisitos = new ArrayList<>();
    }

    public boolean agregarRequisito(int orden, String descripcion) {
        Requisito requisito = new Requisito(orden, descripcion);
        return requisitos.add(requisito);
    }

    public boolean eliminarRequisito(int orden) {
        for (Requisito requisito : requisitos) {
            if (requisito.getOrden() == orden) {
                return requisitos.remove(requisito);
            }
        }
        return false;
    }

    public List<Requisito> getRequisitos() {
        return requisitos;
    }
}


