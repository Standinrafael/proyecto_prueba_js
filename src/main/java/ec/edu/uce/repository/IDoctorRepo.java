package ec.edu.uce.repository;

import ec.edu.uce.modelo.Doctor;

public interface IDoctorRepo {

	void insertar(Doctor doctor);
	void actualizar(Doctor doctor);
	Doctor buscarPorId(Integer id);
	void eliminar(Integer id);
	Doctor buscarPorCedula(String cedula);
}
