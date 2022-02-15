package ec.edu.uce.repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.CitaMedica;

import org.apache.log4j.Logger;

@Repository
@Transactional
public class CitaMedicaRepoImpl implements ICitaMedicaRepo {

	final static Logger LOGGER= Logger.getLogger(CitaMedicaRepoImpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertarCitaMedica(CitaMedica cita) {
		// TODO Auto-generated method stub
		this.entityManager.persist(cita);
		LOGGER.info(cita);
	}

	@Override
	public void actualizarCitaMedica(CitaMedica cita) {
		// TODO Auto-generated method stub
		this.entityManager.merge(cita);
	}

	@Override
	public CitaMedica buscarCitaPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(CitaMedica.class, id);
	}

	@Override
	public void borrarCitaPorId(Integer id) {
		// TODO Auto-generated method stub
		CitaMedica cita= this.buscarCitaPorId(id);
		this.entityManager.remove(cita);
	}





}
