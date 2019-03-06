import java.io.Serializable;
import java.time.LocalDate;

public class Coche implements Serializable {

	String matricula;
	String marca;
	String modelo;
	LocalDate fechaMatriculacion;
	LocalDate fechaItv;

	public Coche() {
		super();
	}

	public Coche(String matricula, String marca, String modelo, LocalDate fechaMatriculacion) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.fechaMatriculacion = fechaMatriculacion;
	}

	public Coche(String matricula, String marca, String modelo, LocalDate fechaMatriculacion, LocalDate fechaItv) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.fechaMatriculacion = fechaMatriculacion;
		this.fechaItv = fechaItv;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public LocalDate getFechaMatriculacion() {
		return fechaMatriculacion;
	}

	public void setFechaMatriculacion(LocalDate fechaMatriculacion) {
		this.fechaMatriculacion = fechaMatriculacion;
	}

	public LocalDate getFechaItv() {
		return fechaItv;
	}

	public void setFechaItv(LocalDate fechaItv) {
		this.fechaItv = fechaItv;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return "Coche [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", fechaMatriculacion="
				+ fechaMatriculacion + ", fechaItv=" + fechaItv + "]";
	}

	/**
	 * Metodo que hace la compraciones de la fecha y de la ITV devolveindo la decha
	 * en la que tiene que pasar la ITV
	 * 
	 * @return mensaje
	 */
	public String devolverVehiculo() {
		LocalDate actual = LocalDate.now();
		String mensaje = "";
		int fecha = 0;

		try {
			fecha = actual.getYear() - fechaMatriculacion.getYear();

			if (fecha < 4 && fechaItv != null) {
				mensaje = "El coche " + matricula + " esta exento de pasar la ITV.";
			}
			if ((fecha >= 4) && (fecha <= 10) && fechaItv != null) {
				LocalDate itv = LocalDate.of(fechaItv.getYear() + 1, fechaItv.getMonth(), fechaItv.getDayOfMonth());
				mensaje = "El coche " + matricula + " tiene que pasar la ITV el " + itv;

			}
			if (fecha > 10 && fechaItv != null) {
				LocalDate itv = LocalDate.of(fechaItv.getYear() + 2, fechaItv.getMonth(), fechaItv.getDayOfMonth());

				mensaje = "El coche " + matricula + " tiene que pasar la ITV el " + itv;

			}

			if ((fecha < 4) && (fechaItv == null)) {
				mensaje = "El coche " + matricula + " esta exento de pasar la ITV.";
			} else if ((fecha > 4) && (fechaItv == null)) {
				mensaje = " El che tiene mas de 4 anios y no ha puesto fecha de la ITV";
			}

		} catch (Exception e) {

		}
		return mensaje;

	}
}
