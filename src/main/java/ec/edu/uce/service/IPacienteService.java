package ec.edu.uce.service;

import ec.edu.uce.modelo.Paciente;

public interface IPacienteService {

	void insertarPaciente(Paciente paciente);

	void actualizarPaciente(Paciente paciente);

	Paciente buscarPacientePorId(Integer id);

	void borrarPacientePorId(Integer id);
	
	//buscar paciente por seguro
		Paciente buscarPacientePorCodigoSeguro(String codigo);
}
