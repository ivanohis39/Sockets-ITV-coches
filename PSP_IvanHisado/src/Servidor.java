import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	static final int port = 8000;
	static ServerSocket server;

	/**
	 * Establecemos la conexion con el servidor
	 */
	public void setConnection() {
		try {
			server = new ServerSocket(port);
			System.out.println("Starting server socket ...");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Servidor servidor = new Servidor();
		servidor.setConnection();

		while (true) {
			try {
				// acepatamos al socket cliente
				Socket cliente = new Socket();
				cliente = server.accept();

				// mandamos al hiloservidor el cliente
				HiloServidor hilo = new HiloServidor(cliente);

				hilo.start();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
