package ec.edu.uce.repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.Paciente;
import org.apache.log4j.Logger;

@Repository
@Transactional
public class PacienteRepoImpl implements IPacienteRepo {

	final static Logger LOGGER= Logger.getLogger(PacienteRepoImpl.class);
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertarPaciente(Paciente paciente) {
		// TODO Auto-generated method stub
		this.entityManager.persist(paciente);
		LOGGER.info(paciente);
	}

	@Override
	public void actualizarPaciente(Paciente paciente) {
		// TODO Auto-generated method stub
		this.entityManager.merge(paciente);
		LOGGER.info(paciente);
	}

	@Override
	public Paciente buscarPacientePorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Paciente.class, id);
	}

	@Override
	public void borrarPacientePorId(Integer id) {
		// TODO Auto-generated method stub
		Paciente paciente=this.buscarPacientePorId(id);
		this.entityManager.remove(paciente);
	}

	@Override
	public Paciente buscarPacientePorCodigoSeguro(String codigo) {
		// TODO Auto-generated method stub
		Paciente miPaciente=null;
		try{
			Query miQuery= this.entityManager.createQuery("select p from Paciente p where p.codigoSeguro=:codigo");
			miQuery.setParameter("codigo", codigo);
			miPaciente=(Paciente) miQuery.getSingleResult();
			
		}catch(NoResultException e){
			LOGGER.error("No existe resultado para:"+codigo,e);
		}
		
		return miPaciente;
	}

}
