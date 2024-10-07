import java.util.Date;
public class Etapa {
    private Date fecha;
    private String glosa;

    public Etapa(Date fecha, String glosa) {
        this.fecha = fecha;
        this.glosa = glosa;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getGlosa() {
        return glosa;
    }
}
