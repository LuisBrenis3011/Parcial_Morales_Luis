public class EstadoEtapa {
    private String nombre;
    private boolean estado;

    public EstadoEtapa(String nombre) {
        this.nombre = nombre;
        this.estado = true;
    }

    public boolean habilitar() {
        this.estado = true;
        return true;
    }

    public boolean deshabilitar() {
        this.estado = false;
        return true;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isEstado() {
        return estado;
    }
}

