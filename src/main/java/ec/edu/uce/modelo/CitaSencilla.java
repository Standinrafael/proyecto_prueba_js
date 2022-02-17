package ec.edu.uce.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CitaSencilla {
	
	private String numero;
	
	private LocalDateTime fechaCita;
	
	private BigDecimal valorCita;
	
	private LocalDateTime fechaProximaCita;
	
	
	public CitaSencilla() {
		
	}
	
	public CitaSencilla(String numero, LocalDateTime fechaCita, BigDecimal valorCita, LocalDateTime fechaProximaCita) {
		super();
		this.numero = numero;
		this.fechaCita = fechaCita;
		this.valorCita = valorCita;
		this.fechaProximaCita = fechaProximaCita;
	}

	//Metodos GET y SET
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDateTime getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(LocalDateTime fechaCita) {
		this.fechaCita = fechaCita;
	}

	public BigDecimal getValorCita() {
		return valorCita;
	}

	public void setValorCita(BigDecimal valorCita) {
		this.valorCita = valorCita;
	}

	public LocalDateTime getFechaProximaCita() {
		return fechaProximaCita;
	}

	public void setFechaProximaCita(LocalDateTime fechaProximaCita) {
		this.fechaProximaCita = fechaProximaCita;
	}

	@Override
	public String toString() {
		return "CitaSencilla [numero=" + numero + ", fechaCita=" + fechaCita + ", valorCita=" + valorCita
				+ ", fechaProximaCita=" + fechaProximaCita + "]";
	}
	
	

}
