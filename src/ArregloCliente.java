import java.util.ArrayList;
import java.util.List;
public class ArregloCliente {
    private List<Cliente> clientes;

    public ArregloCliente() {
        this.clientes = new ArrayList<>();
    }

    public boolean agregar(Cliente cliente) {
        return clientes.add(cliente);
    }

    public Cliente buscar(String RUC) {
        for (Cliente cliente : clientes) {
            if (cliente.getRUC().equals(RUC)) {
                return cliente;
            }
        }
        return null;
    }

    public List<Cliente> buscarNombre(String nombre) {
        List<Cliente> encontrados = new ArrayList<>();
        for (Cliente cliente : clientes) {
            if (cliente.getNombre().equalsIgnoreCase(nombre)) {
                encontrados.add(cliente);
            }
        }
        return encontrados;
    }
}


