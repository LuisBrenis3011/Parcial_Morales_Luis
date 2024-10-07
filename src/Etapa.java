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

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setGlosa(String glosa) {
        this.glosa = glosa;
    }
}
