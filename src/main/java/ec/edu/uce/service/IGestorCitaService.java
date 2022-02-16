package ec.edu.uce.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface IGestorCitaService {

	void agendarCita(String numero, LocalDateTime fecha, BigDecimal valor, String lugar, String cedulaDoctor,
			String cedulaPaciente);
	
	void resultadoCita(String numero, String diagnostico, String receta, LocalDateTime fechaProxima);
}
