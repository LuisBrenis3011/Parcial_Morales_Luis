import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ArregloPostulante arregloPostulante = new ArregloPostulante();
    private static List<Oferta> ofertas = new ArrayList<>();
    private static ArregloGradoEstudio arregloGradoEstudio = new ArregloGradoEstudio();

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("\n--- Sistema de Gestión de Postulantes ---");
            System.out.println("1. Registrar postulante");
            System.out.println("2. Registrar oferta");
            System.out.println("3. Postular a una oferta");
            System.out.println("4. Listar postulaciones de un postulante");
            System.out.println("5. Anular una postulación");
            System.out.println("0. Salir");
            System.out.print("Elija una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    registrarPostulante();
                    break;
                case 2:
                    registrarOferta();
                    break;
                case 3:
                    postularOferta();
                    break;
                case 4:
                    listarPostulaciones();
                    break;
                case 5:
                    anularPostulacion();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida, intente nuevamente.");
                    break;
            }
        } while (opcion != 0);

        scanner.close();
    }

    private static void registrarPostulante() {
        System.out.println("\n--- Registrar Postulante ---");
        System.out.print("DNI: ");
        String dni = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Nombres: ");
        String nombres = scanner.nextLine();
        System.out.print("Apellidos: ");
        String apellidos = scanner.nextLine();
        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();
        System.out.print("Fecha de nacimiento (dd/MM/yyyy): ");
        String fechaNacimientoStr = scanner.nextLine();
        Date fechaNacimiento = parseFecha(fechaNacimientoStr);
        System.out.print("Clave: ");
        String clave = scanner.nextLine();

        Postulante postulante = new Postulante(dni, email, nombres, apellidos, direccion, fechaNacimiento, clave);
        if (arregloPostulante.agregar(postulante)) {
            System.out.println("Postulante registrado exitosamente.");
        } else {
            System.out.println("Error al registrar postulante.");
        }
    }

    private static void registrarOferta() {
        System.out.println("\n--- Registrar Oferta ---");
        System.out.print("Puesto: ");
        String puesto = scanner.nextLine();
        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();
        System.out.print("Área: ");
        String area = scanner.nextLine();
        System.out.print("Fecha de inicio (dd/MM/yyyy): ");
        String fechaInicioStr = scanner.nextLine();
        Date fechaInicio = parseFecha(fechaInicioStr);
        System.out.print("Fecha de término (dd/MM/yyyy): ");
        String fechaTerminoStr = scanner.nextLine();
        Date fechaTermino = parseFecha(fechaTerminoStr);

        Oferta oferta = new Oferta(puesto, descripcion, area, fechaInicio, fechaTermino);
        ofertas.add(oferta);
        System.out.println("Oferta registrada exitosamente.");
    }

    private static void postularOferta() {
        System.out.println("\n--- Postular a una Oferta ---");
        System.out.print("Ingrese el DNI del postulante: ");
        String dni = scanner.nextLine();
        Postulante postulante = arregloPostulante.buscar(dni);

        if (postulante == null) {
            System.out.println("Postulante no encontrado.");
            return;
        }

        System.out.println("Ofertas disponibles:");
        for (int i = 0; i < ofertas.size(); i++) {
            System.out.println((i + 1) + ". " + ofertas.get(i).getPuesto() + " - Área: " + ofertas.get(i).getArea());
        }
        System.out.print("Seleccione la oferta a la que desea postular (número): ");
        int indiceOferta = Integer.parseInt(scanner.nextLine()) - 1;

        if (indiceOferta < 0 || indiceOferta >= ofertas.size()) {
            System.out.println("Opción de oferta no válida.");
            return;
        }

        Oferta ofertaSeleccionada = ofertas.get(indiceOferta);

        System.out.print("Ingrese la glosa de la etapa actual: ");
        String glosaEtapa = scanner.nextLine();
        System.out.print("Ingrese la fecha de la etapa (dd/MM/yyyy): ");
        String fechaEtapaStr = scanner.nextLine();
        Date fechaEtapa = parseFecha(fechaEtapaStr);

        Etapa etapa = new Etapa(fechaEtapa, glosaEtapa);

        if (postulante.postular(ofertaSeleccionada, etapa)) {
            System.out.println("Postulación realizada con éxito.");
        } else {
            System.out.println("Error al realizar la postulación.");
        }
    }

    private static void listarPostulaciones() {
        System.out.println("\n--- Listar Postulaciones ---");
        System.out.print("Ingrese el DNI del postulante: ");
        String dni = scanner.nextLine();
        Postulante postulante = arregloPostulante.buscar(dni);

        if (postulante == null) {
            System.out.println("Postulante no encontrado.");
            return;
        }

        System.out.println("Postulaciones de " + postulante.getNombres() + ":");
        for (Postulacion postulacion : postulante.getPostulaciones()) {
            Etapa etapa = postulacion.getEtapa();
            System.out.println("Oferta: " + postulacion.getOferta().getPuesto() + ", Fecha: " + postulacion.getFecha() +
                    ", Etapa: " + etapa.getGlosa() + " (" + etapa.getFecha() + "), Anulado: " +
                    (postulacion.isAnulado() ? "Sí" : "No"));
        }
    }

    private static void anularPostulacion() {
        System.out.println("\n--- Anular Postulación ---");
        System.out.print("Ingrese el DNI del postulante: ");
        String dni = scanner.nextLine();
        Postulante postulante = arregloPostulante.buscar(dni);

        if (postulante == null) {
            System.out.println("Postulante no encontrado.");
            return;
        }

        List<Postulacion> postulaciones = postulante.getPostulaciones();
        if (postulaciones.isEmpty()) {
            System.out.println("El postulante no tiene postulaciones.");
            return;
        }

        System.out.println("Postulaciones del postulante:");
        for (int i = 0; i < postulaciones.size(); i++) {
            System.out.println((i + 1) + ". " + postulaciones.get(i).getOferta().getPuesto() + " - Fecha: " + postulaciones.get(i).getFecha());
        }
        System.out.print("Seleccione la postulación a anular (número): ");
        int indicePostulacion = Integer.parseInt(scanner.nextLine()) - 1;

        if (indicePostulacion < 0 || indicePostulacion >= postulaciones.size()) {
            System.out.println("Opción de postulación no válida.");
            return;
        }

        Postulacion postulacionSeleccionada = postulaciones.get(indicePostulacion);
        postulante.anularPostulacion(postulacionSeleccionada);
        System.out.println("Postulación anulada con éxito.");
    }

    private static Date parseFecha(String fechaStr) {
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(fechaStr);
        } catch (Exception e) {
            System.out.println("Fecha no válida, se usará la fecha actual.");
            return new Date();
        }
    }
}



