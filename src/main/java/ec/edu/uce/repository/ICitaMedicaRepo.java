package ec.edu.uce.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import ec.edu.uce.modelo.CitaMedica;

public interface ICitaMedicaRepo {

	void insertarCitaMedica(CitaMedica cita);
	void actualizarCitaMedica(CitaMedica cita);
	CitaMedica buscarCitaPorId(Integer id);
	void borrarCitaPorId(Integer id);
	

}
