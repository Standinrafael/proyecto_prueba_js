package ec.edu.uce.repository;

import ec.edu.uce.modelo.Paciente;

public interface IPacienteRepo {

	void insertar(Paciente paciente);
	void actualiza(Paciente paciente);
	Paciente buscarPorId(Integer id);
	void eliminar(Integer id);
	
	Paciente buscarPorCedula(String cedula);
}
