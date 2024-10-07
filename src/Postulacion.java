import java.util.Date;

public class Postulacion {
    private Oferta oferta;
    private Date fecha;
    private boolean anulado;
    private Date fechaAnulacion;
    protected Etapa etapa;

    public Postulacion(Oferta oferta, Date fecha, Etapa etapa) {
        this.oferta = oferta;
        this.fecha = fecha;
        this.anulado = false;
        this.etapa = etapa;
    }

    public void setOferta(Oferta oferta) {
        this.oferta = oferta;
    }

    public Etapa getEtapa() {
        return etapa;
    }

    public void setEtapa(Etapa etapa) {
        this.etapa = etapa;
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