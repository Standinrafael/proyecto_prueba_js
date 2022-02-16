package ec.edu.uce.service;

import ec.edu.uce.modelo.Paciente;

public interface IPacienteService {

	void insertar(Paciente paciente);
	void actualiza(Paciente paciente);
	Paciente buscarPorId(Integer id);
	void eliminar(Integer id);
	
	Paciente buscarPorCedula(String cedula);
}
