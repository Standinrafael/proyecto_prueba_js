package ec.edu.uce.repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.Doctor;


import org.apache.log4j.Logger;

@Repository
@Transactional
public class DoctorRepoImpl implements IDoctorRepo {

	final static Logger LOGGER= Logger.getLogger(DoctorRepoImpl.class);
	 
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertarDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		this.entityManager.persist(doctor);
		LOGGER.info(doctor);
	}

	@Override
	public void actualizarDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		this.entityManager.merge(doctor);
		LOGGER.info(doctor);
	}

	@Override
	public Doctor buscarDoctorPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Doctor.class, id);
	}

	@Override
	public void borrarDoctorPorId(Integer id) {
		// TODO Auto-generated method stub
		Doctor doctor=this.buscarDoctorPorId(id);
		this.entityManager.remove(doctor);
	}

	@Override
	public Doctor buscarDoctorPorApellido(String apellido) {
		// TODO Auto-generated method stub
		
		Doctor miDoctor=null;
		try {
			Query miQuery= this.entityManager.createQuery ("select d from Doctor d where d.apellido=:apellido");
			miQuery.setParameter("apellido", apellido);
			miDoctor=(Doctor)miQuery.getSingleResult();
		}catch(NoResultException e) {
			LOGGER.error("No existe resultado para:"+apellido,e);
		}
		
		return miDoctor;
	}

}
