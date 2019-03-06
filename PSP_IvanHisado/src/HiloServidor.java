import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class HiloServidor extends Thread {

	Socket cliente = null;
	ObjectInputStream inputStream;
	DataOutputStream outputStream;
	Coche coche;

	public HiloServidor(Socket cliente) {
		super();
		this.cliente = cliente;
		try {
			outputStream = new DataOutputStream(cliente.getOutputStream());
			outputStream.flush();
			inputStream = new ObjectInputStream(cliente.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			// mostramos el cliente
			System.out.println(cliente.toString());
			// leemos el flujo
			coche = (Coche) inputStream.readObject();
			System.out.println("Consultar coche: " + coche.toString());
			// mostramos el mensaje
			String mensaje = coche.devolverVehiculo();

			outputStream.writeUTF(mensaje);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
