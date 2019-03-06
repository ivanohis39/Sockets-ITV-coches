import java.io.DataInputStream;
import java.io.IOException;

public class HiloClienteRecibir extends Thread {

	DataInputStream inputStream;

	public HiloClienteRecibir(DataInputStream inputStream) {
		super();
		this.inputStream = inputStream;
	}

	@Override
	public void run() {

		try {
			while (true) {
				// leemos
				System.out.println(inputStream.readUTF());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
