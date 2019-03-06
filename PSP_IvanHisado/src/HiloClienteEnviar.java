import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HiloClienteEnviar extends Thread {

	ObjectOutputStream outputStream;
	Coche coche;

	public HiloClienteEnviar(ObjectOutputStream outputStream) {
		super();
		this.outputStream = outputStream;
	}

	/**
	 * Metodo que pide una cadena
	 * 
	 * @param string
	 * @return
	 */
	public static String setString(String string) {
		System.out.println(string);
		return new Scanner(System.in).nextLine();
	}

	/**
	 * Metodo que pide un entero
	 * 
	 * @param string
	 * @return
	 */
	public static int setInteger(String string) {
		int numn = 0;
		boolean corecto = false;
		do {
			try {
				System.out.println(string);
				numn = new Scanner(System.in).nextInt();
				corecto = true;
			} catch (InputMismatchException e) {
				corecto = false;
			}
		} while (corecto == false);

		return numn;
	}

	/**
	 * metodo que pide una feccha
	 * 
	 * @param string
	 * @return
	 */
	public static LocalDate fechaMatricula(String string) {
		System.out.println(string);
		LocalDate date = LocalDate.of(setInteger("Year:"), setInteger("Month:"), setInteger("Day:"));
		return date;
	}

	/**
	 * metodo que pide un vehiculo y ademas comprueba que haya pasdo la itv
	 * 
	 * @return
	 */
	public static Coche setAuto() {
		Coche coche = new Coche();
		if (setString("¿Deseas aniadir la ultima fecha de la ITV (SI/NO)").equalsIgnoreCase("SI")) {
			coche = new Coche(setString("Introduce la matricula de vehiculo:"),
					setString("Introduce la marca del vehiculo:"), setString("Introduce el modelo del vehiculo:"),
					fechaMatricula("Introduce la fecha de matriculacion:"),
					fechaMatricula("Introduce la fecha de la utima ITV del coche:"));
		} else {
			coche = new Coche(setString("Introduce la matricula de vehiculo:"),
					setString("Introduce la marca del vehiculo:"), setString("Introduce el modelo del vehiculo:"),
					fechaMatricula("Introduce la fecha de matriculacion:"));
		}

		return coche;
	}

	@Override
	public void run() {

		System.out.println("****----***** SISTEMA DE COMPROBACION DE ITV DE VEHICULO ****----****");

		try {
			// mandamos el objeto coche
			coche = setAuto();
			outputStream.writeObject(coche);
			outputStream.flush();
			outputStream.reset();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
