package ec.edu.uce.service;

import ec.edu.uce.modelo.CitaMedica;

public interface ICitaMedicaService {

	void insertar(CitaMedica cita);
	
	CitaMedica buscarPorNumero(String numero);

	void actualizar(CitaMedica cita);
}
