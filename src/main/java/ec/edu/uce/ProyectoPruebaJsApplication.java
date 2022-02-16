package ec.edu.uce;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ec.edu.uce.modelo.Doctor;
import ec.edu.uce.modelo.Paciente;
import ec.edu.uce.service.ICitaMedicaService;
import ec.edu.uce.service.IDoctorService;
import ec.edu.uce.service.IGestorCitaService;
import ec.edu.uce.service.IPacienteService;

@SpringBootApplication
public class ProyectoPruebaJsApplication implements CommandLineRunner {

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

		this.pacienteService.insertar(p1);
		this.pacienteService.insertar(p2);

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

		this.doctorService.insertar(d1);
		this.doctorService.insertar(d2);

//		this.gestorService.agendarCita("1", LocalDateTime.now(), new BigDecimal("10.00"), "Cotopaxi", "11055166290",
//				"1122");
//		
//		this.gestorService.resultadoCita("1", "gripe", "paracetamol", LocalDateTime.of(2022,Month.APRIL, 12, 12, 12));
	}

}
