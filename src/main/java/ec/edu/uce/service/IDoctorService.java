package ec.edu.uce.service;

import ec.edu.uce.modelo.Doctor;

public interface IDoctorService {

	void insertarDoctor(Doctor doctor);

	void actualizarDoctor(Doctor doctor);

	Doctor buscarDoctorPorId(Integer id);

	void borrarDoctorPorId(Integer id);

	// buscar doctor por apellido
	Doctor buscarDoctorPorApellido(String apellido);
}
