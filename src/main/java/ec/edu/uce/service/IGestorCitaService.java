package ec.edu.uce.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import ec.edu.uce.modelo.CitaMedica;

public interface IGestorCitaService {

	void agendarCita(String numero, LocalDateTime fecha, BigDecimal valor, String lugar, String apellidoDoctor, String codigoPaciente, CitaMedica cita);
	
}
