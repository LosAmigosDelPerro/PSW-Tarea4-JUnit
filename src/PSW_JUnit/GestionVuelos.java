package PSW_JUnit;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class GestionVuelos {
    private List<Vuelo> listaVuelos;

    public GestionVuelos() {
        listaVuelos = new ArrayList<>();
    }

    public void crearVuelo(String codigoVuelo, Integer numAsientos, String fechaYHoraSalida, String fechaYHoraLlegada, String origen, String destino) {
        if (buscarVueloPorCodigo(codigoVuelo) != null) {
            System.out.println("\n El código ingresado ya está siendo ocupado por otro vuelo, intente con otro\n");
            return;
        }
        Vuelo vuelo = new Vuelo(codigoVuelo, numAsientos, fechaYHoraSalida, fechaYHoraLlegada, origen, destino);
        listaVuelos.add(vuelo);
        System.out.println("Vuelo creado exitosamente");
    }

    public Vuelo buscarVueloPorCodigo(String codigo) {
        for (Vuelo vuelo : listaVuelos) {
            if (vuelo.getCodigoVuelo().equals(codigo)) {
                return vuelo;
            }
        }
        return null; // Si no se encuentra el vuelo con ese codigo
    }

    public List<Vuelo> obtenerTodosLosVuelos() {
        return listaVuelos;
    }

    /***public boolean actualizarVuelo(String codigo, Integer numAsientosPedidos) {
        for (int i = 0; i < listaVuelos.size(); i++) {
            if (listaVuelos.get(i).getCodigoVuelo().equals(codigo)) {
                return listaVuelos.get(i).actualizarAsientosOcupados(numAsientosPedidos);
            }
        }
        return false;
    }***/

    public boolean crearReservas(String codigo, Integer numAsientosPedidos, String nombrePasajero) {
        for (int i = 0; i < listaVuelos.size(); i++) {
            if (listaVuelos.get(i).getCodigoVuelo().equals(codigo)) {
                return listaVuelos.get(i).hacerReserva(nombrePasajero, numAsientosPedidos);
            }
        }
        return false;
    }

    public List<Vuelo> buscarVuelosPorOrigenYDestino(String origen, String destino) {
        List<Vuelo> listaFiltrada = new ArrayList<>();
        for (Vuelo vuelo : listaVuelos) {
            if (vuelo.getOrigen().equals(origen) && vuelo.getDestino().equals(destino)) {
                listaFiltrada.add(vuelo);
            }
        }
        return listaFiltrada;
    }

    public void eliminarVuelo(String codigo) {
        listaVuelos.removeIf(vuelo -> vuelo.getCodigoVuelo().equals(codigo));
    }
}