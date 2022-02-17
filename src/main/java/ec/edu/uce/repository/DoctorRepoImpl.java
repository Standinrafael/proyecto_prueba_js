package ec.edu.uce.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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
	public void insertar(Doctor doctor) {
		// TODO Auto-generated method stub
		this.entityManager.persist(doctor);
		LOGGER.info(doctor);
	}

	@Override
	public void actualizar(Doctor doctor) {
		// TODO Auto-generated method stub
		this.entityManager.merge(doctor);
	}

	@Override
	public Doctor buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Doctor.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Doctor doc= this.buscarPorId(id);
		this.entityManager.remove(doc);
	}

	@Override
	public Doctor buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		
		TypedQuery<Doctor> miQuery= this.entityManager.createQuery("select d from Doctor d where d.cedula=:cedula",Doctor.class);
		miQuery.setParameter("cedula", cedula);
		return miQuery.getSingleResult();
	}

}
