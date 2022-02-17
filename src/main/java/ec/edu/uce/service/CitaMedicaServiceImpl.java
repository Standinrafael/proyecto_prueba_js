package ec.edu.uce.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.CitaMedica;
import ec.edu.uce.modelo.CitaSencilla;
import ec.edu.uce.repository.ICitaMedicaRepo;

@Service
public class CitaMedicaServiceImpl implements ICitaMedicaService {

	@Autowired
	private ICitaMedicaRepo citaRepo;
	
	@Override
	public void insertar(CitaMedica cita) {
		// TODO Auto-generated method stub
		this.citaRepo.insertar(cita);
	}

	@Override
	public CitaMedica buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.citaRepo.buscarPorNumero(numero);
	}

	@Override
	public void actualizar(CitaMedica cita) {
		// TODO Auto-generated method stub
		this.citaRepo.actualizar(cita);
	}

	@Override
	public List<CitaSencilla> busquedaEficiente(LocalDateTime fecha, BigDecimal valor) {
		// TODO Auto-generated method stub
		return this.citaRepo.busquedaEficiente(fecha, valor);
	}



}
