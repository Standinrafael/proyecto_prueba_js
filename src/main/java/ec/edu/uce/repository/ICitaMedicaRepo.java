package ec.edu.uce.repository;

import ec.edu.uce.modelo.CitaMedica;

public interface ICitaMedicaRepo {

	void insertar(CitaMedica cita);

	CitaMedica buscarPorNumero(String numero);

	void actualizar(CitaMedica cita);
}
