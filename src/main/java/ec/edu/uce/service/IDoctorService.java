package ec.edu.uce.service;

import ec.edu.uce.modelo.Doctor;

public interface IDoctorService {

	void insertar(Doctor doctor);
	void actualizar(Doctor doctor);
	Doctor buscarPorId(Integer id);
	void eliminar(Integer id);
	Doctor buscarPorCedula(String cedula);
}
