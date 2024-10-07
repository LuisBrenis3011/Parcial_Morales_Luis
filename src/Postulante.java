import java.util.Date;
public class Postulante {
    private String DNI;
    private String email;
    private String nombres;
    private String apellidos;
    private String direccion;
    private Date nacimiento;
    private String clave;

    public Postulante(String DNI, String clave, Date nacimiento, String direccion, String apellidos, String nombres, String email) {
        this.DNI = DNI;
        this.clave = clave;
        this.nacimiento = nacimiento;
        this.direccion = direccion;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.email = email;
    }

    public boolean asignarGradoEstudio(GradoEstudio grado) {

        return false;
    }

    public boolean postular(Oferta oferta, String glosa) {

        return false;
    }

    public boolean anularPostulacion(Postulacion postulacion) {

        return false;
    }

    public Postulacion[] getPostulaciones() {

        return null;
    }
}

