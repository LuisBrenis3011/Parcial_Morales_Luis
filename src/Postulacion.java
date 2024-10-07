import java.util.Date;
 class Postulacion {
    private Date fecha;
    private boolean anulado;
    private Date fechaAnulacion;

     public Postulacion(Date fecha, boolean anulado, Date fechaAnulacion) {
         this.fecha = fecha;
         this.anulado = anulado;
         this.fechaAnulacion = fechaAnulacion;
     }
 }

