package PSW_JUnit;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Reserva {
    private String codigoReserva;
    private String nombre;
    private int numAsientosReservados;
    private String codigoVuelo;

    public Reserva(String codigoReserva, String nombre, int numAsientosReservados, String codigoVuelo) {
        this.codigoReserva = codigoReserva;
        this.nombre = nombre;
        this.numAsientosReservados = numAsientosReservados;
        this.codigoVuelo = codigoVuelo;
    }

    // Getters codigoReserva
    public String getCodigoReserva() {
        return codigoReserva;
    }