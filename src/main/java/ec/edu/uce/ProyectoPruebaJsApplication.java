package ec.edu.uce;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ec.edu.uce.modelo.CitaMedica;
import ec.edu.uce.modelo.Doctor;
import ec.edu.uce.modelo.Paciente;
import ec.edu.uce.repository.DoctorRepoImpl;
import ec.edu.uce.service.ICitaMedicaService;
import ec.edu.uce.service.IDoctorService;
import ec.edu.uce.service.IGestorCitaService;
import ec.edu.uce.service.IPacienteService;

@SpringBootApplication
public class ProyectoPruebaJsApplication implements CommandLineRunner {

	final static Logger LOGGER = Logger.getLogger(ProyectoPruebaJsApplication.class);

	@Autowired
	private IPacienteService pacienteService;

	@Autowired
	private IDoctorService doctorService;

	@Autowired
	private ICitaMedicaService citaMedicaService;

	@Autowired
	private IGestorCitaService gestor;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoPruebaJsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		List<CitaMedica> listaCita = new ArrayList<>();

		// Insertar Cita
		CitaMedica cita = new CitaMedica();
		cita.setNumero("1");
		cita.setFechaProximaCita(LocalDateTime.of(2022, Month.JUNE, 18, 12, 45));
		cita.setValorCita(new BigDecimal("10.00"));
		cita.setLugarCita("Sangolqui");

		listaCita.add(cita);

		// Insertar Paciente
		Paciente p1 = new Paciente();
		p1.setApellido("Perez");
		p1.setCedula("10002256");
		p1.setCodigoSeguro("abcd");
		p1.setEstatura(1.60);
		p1.setFechaNacimiento(LocalDateTime.of(1989, Month.AUGUST, 8, 12, 45));
		p1.setGenero("Masculino");
		p1.setNombre("Juan");
		p1.setPeso(45.3);

		Paciente p2 = new Paciente();
		p2.setApellido("Lopez");
		p2.setCedula("012365");
		p2.setCodigoSeguro("kgjg");
		p2.setEstatura(1.59);
		p2.setFechaNacimiento(LocalDateTime.of(1999, Month.AUGUST, 15, 12, 45));
		p2.setGenero("Femenino");
		p2.setNombre("Maria");
		p2.setPeso(35.3);
		p2.setCitas(listaCita);

		LOGGER.info(" Pacientes Insertados");

		this.pacienteService.insertarPaciente(p1);
		this.pacienteService.insertarPaciente(p2);

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
		d2.setCitas(listaCita);

		LOGGER.info("Doctores Insertados");
		this.doctorService.insertarDoctor(d1);
		this.doctorService.insertarDoctor(d2);

		// Agregar valores lista
		LOGGER.info("Cita agendada");
		cita.setDoctor(d2);
		cita.setPaciente(p2);
		this.gestor.agendarCita(cita.getNumero(), cita.getFechaProximaCita(), cita.getValorCita(), cita.getLugarCita(),
				"Cabrera", "kgjg", cita);

		// Actualizar paciente

		LOGGER.info("Paciente actualizado");

		p1.setId(24);
		p1.setApellido("Andrade");
		p1.setCedula("10002256");
		p1.setCodigoSeguro("abcd");
		p1.setEstatura(1.65);
		p1.setFechaNacimiento(LocalDateTime.of(1989, Month.AUGUST, 8, 12, 45));
		p1.setGenero("Masculino");
		p1.setNombre("Juan");
		p1.setPeso(46.3);
		this.pacienteService.actualizarPaciente(p1);

		// Actualizar doctor
		LOGGER.info("Doctor actualizado");

		d1.setId(24);
		d1.setApellido("Suing");
		d1.setNombre("Eugenia");
		d1.setCedula("2563965");
		d1.setFechaNacimiento(LocalDateTime.of(1972, Month.JULY, 15, 12, 45));
		d1.setGenero("Masculino");
		d1.setNumeroConsultorio("C5");
		this.doctorService.actualizarDoctor(d1);
	}

}
