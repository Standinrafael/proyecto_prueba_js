package ec.edu.uce.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.CitaMedica;
import ec.edu.uce.modelo.Doctor;
import ec.edu.uce.modelo.Paciente;

@Service
public class GestorCitaServiceImpl implements IGestorCitaService {

	@Autowired
	private IDoctorService doctorService;
	
	@Autowired
	private IPacienteService pacienteService;
	
	@Autowired
	private ICitaMedicaService citaService;
	
	@Override
	public void agendarCita(String numero, LocalDateTime fecha, BigDecimal valor, String lugar, String cedulaDoctor,
			String cedulaPaciente) {
		// TODO Auto-generated method stub
		Paciente p1=this.pacienteService.buscarPorCedula(cedulaPaciente);
		Doctor d1=this.doctorService.buscarPorCedula(cedulaDoctor);
		CitaMedica c1=new CitaMedica();
		c1.setNumero(numero);
		c1.setFechaCita(fecha);
		c1.setValorCita(valor);
		c1.setLugarCita(lugar);
		c1.setPaciente(p1);
		c1.setDoctor(d1);
		
		this.citaService.insertar(c1);
		
	}

	@Override
	public void resultadoCita(String numero, String diagnostico, String receta, LocalDateTime fechaProxima) {
		// TODO Auto-generated method stub
		CitaMedica c1= this.citaService.buscarPorNumero(numero);
		c1.setDiagnostico(diagnostico);
		c1.setReceta(receta);
		c1.setFechaProximaCita(fechaProxima);
		this.citaService.actualizar(c1);
	}

}
