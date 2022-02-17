package ec.edu.uce;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ec.edu.uce.modelo.CitaSencilla;
import ec.edu.uce.modelo.Doctor;
import ec.edu.uce.modelo.Paciente;
import ec.edu.uce.service.ICitaMedicaService;
import ec.edu.uce.service.IDoctorService;
import ec.edu.uce.service.IGestorCitaService;
import ec.edu.uce.service.IPacienteService;

@SpringBootApplication
public class ProyectoPruebaJsApplication implements CommandLineRunner {

	final static Logger LOGGER = Logger.getLogger(ProyectoPruebaJsApplication.class);

	@Autowired
	private IDoctorService doctorService;

	@Autowired
	private IPacienteService pacienteService;

	@Autowired
	private ICitaMedicaService citaService;

	@Autowired
	private IGestorCitaService gestorService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoPruebaJsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		// Insertar Doctor

		Doctor d1 = new Doctor();
		d1.setApellido("Hernandez");
		d1.setCedula("2563965");
		d1.setFechaNacimiento(LocalDateTime.of(1972, Month.JULY, 15, 12, 45));
		d1.setGenero("Masculino");
		d1.setNombre("Federico");
		d1.setNumeroConsultorio("A3");

		Doctor d2 = new Doctor();
		d2.setApellido("Cabrera");
		d2.setCedula("1102566");
		d2.setFechaNacimiento(LocalDateTime.of(1982, Month.JUNE, 18, 12, 45));
		d2.setGenero("Lucia");
		d2.setNombre("Andrade");
		d2.setNumeroConsultorio("B4");

		LOGGER.info("");
		this.doctorService.insertar(d1);
		this.doctorService.insertar(d2);

		// Insertar Paciente
		Paciente p1 = new Paciente();
		p1.setApellido("Perez");
		p1.setCedula("10002256");
		p1.setCodigoSeguro("ab11");
		p1.setEstatura(1.60);
		p1.setFechaNacimiento(LocalDateTime.of(1989, Month.AUGUST, 8, 12, 45));
		p1.setGenero("Masculino");
		p1.setNombre("Juan");
		p1.setPeso(45.3);

		Paciente p2 = new Paciente();
		p2.setApellido("Lopez");
		p2.setCedula("012365");
		p2.setCodigoSeguro("aa11");
		p2.setEstatura(1.59);
		p2.setFechaNacimiento(LocalDateTime.of(1999, Month.AUGUST, 15, 12, 45));
		p2.setGenero("Femenino");
		p2.setNombre("Maria");
		p2.setPeso(35.3);

		LOGGER.info("INSERTAR PACIENTES");
		this.pacienteService.insertar(p1);
		this.pacienteService.insertar(p2);

		// Agendar la cita
		LOGGER.info("AGENDAMIENTO DE LA CITA");
		this.gestorService.agendarCita("67", LocalDateTime.of(2022, 2, 2, 10, 15), new BigDecimal("10.00"), "Cotopaxi",
				"1102566", "012365");

		// Actualizacion de los datos
		LOGGER.info("ACTUALIZACION DE LA CITA");
		this.gestorService.resultadoCita("67", "Gripe", "paracetamol", LocalDateTime.of(2022, 3, 5, 12, 12));

		// Consulta Sencilla
		
		LOGGER.info("CONSULTA EFICIENTE");
		List<CitaSencilla> lista = this.citaService.busquedaEficiente(LocalDateTime.of(2020, 2, 2, 10, 15),
				new BigDecimal("0.00"));
		LOGGER.info("Tamaño de la lista");
		LOGGER.info(lista.size());
		for (CitaSencilla c : lista) {

			LOGGER.info(c.toString());
		}

	}

}
