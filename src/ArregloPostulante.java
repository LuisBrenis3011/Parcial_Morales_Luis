import java.util.ArrayList;
import java.util.List;

public class ArregloPostulante {
    private List<Postulante> postulantes;

    public ArregloPostulante() {
        this.postulantes = new ArrayList<>();
    }

    public boolean agregar(Postulante postulante) {
        return postulantes.add(postulante);
    }

    public Postulante buscar(String DNI) {
        for (Postulante postulante : postulantes) {
            if (postulante.getDNI().equals(DNI)) {
                return postulante;
            }
        }
        return null;
    }
}

