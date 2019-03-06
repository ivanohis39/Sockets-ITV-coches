import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Cliente {

	final static int port = 8000;
	static DataInputStream inputStream;
	static ObjectOutputStream outputStream;

	public static void main(String[] args) {
		try {
			//inciamos el cliente
			Socket cliente = new Socket("localhost", port);

			//inicializamos los flujos
			inputStream = new DataInputStream(cliente.getInputStream());
			outputStream = new ObjectOutputStream(cliente.getOutputStream());

			//mandamos los flujos a los hilos
			HiloClienteEnviar enviar = new HiloClienteEnviar(outputStream);
			HiloClienteRecibir recibir = new HiloClienteRecibir(inputStream);

			//iniciamos los hulos
			enviar.start();
			recibir.start();
	
		

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
