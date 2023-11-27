package PSW_JUnit;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Vuelo {
	
	private String codigoVuelo;
	private Integer numAsientos;
	private Integer numAsientosOcupados;
	private LocalDateTime fechaYHoraSalida; //asumimos por simplicidad que siempre un vuelo sale y llega el mismo dia
	private LocalDateTime fechaYHoraLlegada;
	private String origen;
	private String destino;

	private List<Reserva> listaReservas;


	

	public String getCodigoVuelo() {
		return codigoVuelo;
	}

	public void setCodigoVuelo(String codigovuelo) {
		this.codigoVuelo = codigovuelo;
	}

	public Integer getNumAsientos() {
		return numAsientos;
	}

	public void setNumAsientos(Integer numAsientos) {
		this.numAsientos = numAsientos;
	}

	public Integer getNumAsientosOcupados() {
		return numAsientosOcupados;
	}

	public void setNumAsientosOcupados(Integer numAsientosOcupados) {
		this.numAsientosOcupados = numAsientosOcupados;
	}

	public LocalDateTime getFechaYHoraSalida() {
		return fechaYHoraSalida;
	}

	public void setFechaYHoraSalida(LocalDateTime fechaYHoraSalida) {
		this.fechaYHoraSalida = fechaYHoraSalida;
	}

	public LocalDateTime getFechaYHoraLlegada() {
		return fechaYHoraLlegada;
	}

	public void setFechaYHoraLlegada(LocalDateTime fechaYHoraLlegada) {
		this.fechaYHoraLlegada = fechaYHoraLlegada;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen= origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino= destino;
	}


	public int actualizarAsientosOcupados(int asientosOcupadosAAgregar) {
        int nuevoTotalAsientosOcupados = this.numAsientosOcupados + asientosOcupadosAAgregar;

        if (nuevoTotalAsientosOcupados >= 0 && nuevoTotalAsientosOcupados <= this.numAsientos) {
            this.numAsientosOcupados = nuevoTotalAsientosOcupados;
			return 1;
        } else {
            System.out.println("La actualización excede el número total de asientos disponibles o es negativa.");
			return 0;
        }
    }

	public String generarCodigoReserva(int asientos) {
		Integer asientosOcupadosAct = this.numAsientosOcupados + asientos;
		String codigoReserva = this.codigoVuelo + "-" + asientosOcupadosAct.toString();
		return codigoReserva;
	}

	public boolean hacerReserva(String nombre, int numAsientosReservados) {
		String codigoReserva = this.generarCodigoReserva(numAsientosReservados);
		
    	Integer validez = this.actualizarAsientosOcupados(numAsientosReservados);
		if (validez == 1) {
			Reserva reserva = new Reserva(codigoReserva, nombre, numAsientosReservados, this.codigoVuelo);
			listaReservas.add(reserva);
			return true;

		}
        
		return false;
    }

	//getter para obtener reservas
	public List<Reserva> getListaReservas() {
		return listaReservas;
	}

	public String asientosDisponibles() {
		Integer asientosDisponibles = this.numAsientos - this.numAsientosOcupados;
		return asientosDisponibles.toString();
	}


	public Vuelo(String codigoVuelo, Integer numAsientos, String fechaYHoraSalida, String fechaYHoraLlegada, String origen, String destino) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		setCodigoVuelo(codigoVuelo);
		setNumAsientos(numAsientos);
		setNumAsientosOcupados(0);
		this.fechaYHoraSalida = LocalDateTime.parse(fechaYHoraSalida, formatter);
		this.fechaYHoraLlegada = LocalDateTime.parse(fechaYHoraLlegada, formatter);
		setOrigen(origen);
		setDestino(destino);
		this.listaReservas = new ArrayList<>();
	}
}


