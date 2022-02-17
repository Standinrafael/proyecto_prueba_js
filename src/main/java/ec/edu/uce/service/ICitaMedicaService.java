package ec.edu.uce.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import ec.edu.uce.modelo.CitaMedica;
import ec.edu.uce.modelo.CitaSencilla;


public interface ICitaMedicaService {

	void insertar(CitaMedica cita);
	
	CitaMedica buscarPorNumero(String numero);

	void actualizar(CitaMedica cita);
	
	List<CitaSencilla> busquedaEficiente(LocalDateTime fecha, BigDecimal valor);
}
