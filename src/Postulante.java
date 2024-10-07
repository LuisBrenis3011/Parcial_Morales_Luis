import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Postulante {
    private String DNI;
    private String email;
    private String nombres;
    private String apellidos;
    private String direccion;
    private Date nacimiento;
    private String clave;
    private List<Postulacion> postulaciones;

    public Postulante(String DNI, String email, String nombres, String apellidos, String direccion, Date nacimiento, String clave) {
        this.DNI = DNI;
        this.email = email;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.nacimiento = nacimiento;
        this.clave = clave;
        this.postulaciones = new ArrayList<>();
    }

    public boolean asignarGradoEstudio(GradoEstudio grado) {

        return true;
    }

    public boolean postular(Oferta oferta) {
        Postulacion postulacion = new Postulacion(oferta, new Date());
        return postulaciones.add(postulacion);
    }

    public boolean anularPostulacion(Postulacion postulacion) {
        postulacion.setAnulado(true);
        postulacion.setFechaAnulacion(new Date());
        return true;
    }

    public List<Postulacion> getPostulaciones() {
        return postulaciones;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setPostulaciones(List<Postulacion> postulaciones) {
        this.postulaciones = postulaciones;
    }
}

