import java.util.Date;
public class Postulacion {
    private Oferta oferta;
    private Date fecha;
    private boolean anulado;
    private Date fechaAnulacion;

    public Postulacion(Oferta oferta, Date fecha) {
        this.oferta = oferta;
        this.fecha = fecha;
        this.anulado = false;
    }

    public boolean isAnulado() {
        return anulado;
    }

    public Date getFechaAnulacion() {
        return fechaAnulacion;
    }

    public void setFechaAnulacion(Date fechaAnulacion) {
        this.fechaAnulacion = fechaAnulacion;
    }

    public void setAnulado(boolean anulado) {
        this.anulado = anulado;
    }

    public Oferta getOferta() {
        return oferta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}


