package ec.edu.uce.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.CitaMedica;
import ec.edu.uce.modelo.Doctor;
import ec.edu.uce.modelo.Paciente;

@Service
public class GestorCitaServiceImpl implements IGestorCitaService {

	private CitaMedica cita1;

	@Autowired
	private IDoctorService doctorSercice;

	@Autowired
	private IPacienteService pacienteService;

	@Autowired
	private ICitaMedicaService citaMedicaService;

	final static Logger LOGGER = Logger.getLogger(GestorCitaServiceImpl.class);

	@Override
	public void agendarCita(String numero, LocalDateTime fecha, BigDecimal valor, String lugar, String apellidoDoctor,
			String codigoPaciente, CitaMedica cita) {
		// TODO Auto-generated method stub

		if (fecha.isBefore(LocalDateTime.now()) || fecha.isEqual(LocalDateTime.now())) {
			LOGGER.warn(" No se puee agendar cita medica");

		} else {
			Doctor doctor = this.doctorSercice.buscarDoctorPorApellido(apellidoDoctor);
			Paciente paciente = this.pacienteService.buscarPacientePorCodigoSeguro(codigoPaciente);

			

			// un objeto este vacio
			if (doctor == null || paciente == null) {
				LOGGER.warn("No existe el doctor/paciente en registro");

			} else {
				valorAumentado(cita);
				this.citaMedicaService.insertarCitaMedica(cita);

			}
		}
	}

	public void valorAumentado(CitaMedica cita) {

		BigDecimal valorCalculado = cita.getValorCita().multiply(new BigDecimal(1.12));

		cita.setValorCita(valorCalculado);
	}

}
