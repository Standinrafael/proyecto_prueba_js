package ec.edu.uce.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.CitaMedica;
import ec.edu.uce.repository.ICitaMedicaRepo;

@Service
public class CitaMedicaServiceImpl implements ICitaMedicaService {

	@Autowired
	private ICitaMedicaRepo citaMedicaRepo;
	
	@Override
	public void insertarCitaMedica(CitaMedica cita) {
		// TODO Auto-generated method stub
		this.citaMedicaRepo.insertarCitaMedica(cita);
	}

	@Override
	public void actualizarCitaMedica(CitaMedica cita) {
		// TODO Auto-generated method stub
		this.citaMedicaRepo.actualizarCitaMedica(cita);
	}

	@Override
	public CitaMedica buscarCitaPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.citaMedicaRepo.buscarCitaPorId(id);
	}

	@Override
	public void borrarCitaPorId(Integer id) {
		// TODO Auto-generated method stub
		this.citaMedicaRepo.buscarCitaPorId(id);
	}



}
