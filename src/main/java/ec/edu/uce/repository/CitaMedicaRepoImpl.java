package ec.edu.uce.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.CitaMedica;
import ec.edu.uce.modelo.CitaSencilla;
import ec.edu.uce.modelo.Doctor;
import org.apache.log4j.Logger;

@Repository
@Transactional
public class CitaMedicaRepoImpl implements ICitaMedicaRepo {

	final static Logger LOGGER = Logger.getLogger(CitaMedicaRepoImpl.class);
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(CitaMedica cita) {
		// TODO Auto-generated method stub
		this.entityManager.persist(cita);
		LOGGER.info("Agendada nueva cita medica");
	}

	@Override
	public CitaMedica buscarPorNumero(String numero) {
		// TODO Auto-generated method stub

		TypedQuery<CitaMedica> miQuery = this.entityManager
				.createQuery("select c from CitaMedica c where c.numero=:numero", CitaMedica.class);
		miQuery.setParameter("numero", numero);
		return miQuery.getSingleResult();

	}

	@Override
	public void actualizar(CitaMedica cita) {
		// TODO Auto-generated method stub
		this.entityManager.merge(cita);
	}

	@Override
	public List<CitaSencilla> busquedaEficiente(LocalDateTime fecha, BigDecimal valor) {
		// TODO Auto-generated method stub

		//CitaSencilla(String numero, LocalDateTime fechaCita, BigDecimal valorCita, LocalDateTime fechaProximaCita)
		
		TypedQuery<CitaSencilla> miQuery = this.entityManager.createQuery(
				"select NEW ec.edu.uce.modelo.CitaSencilla(c.numero,c.fechaCita,c.valorCita,c.fechaProximaCita)  from CitaMedica c where c.fechaCita >=: fecha AND c.valorCita>=:valor", CitaSencilla.class);
		miQuery.setParameter("fecha", fecha);
		miQuery.setParameter("valor", valor);
		return miQuery.getResultList();
	}

}
