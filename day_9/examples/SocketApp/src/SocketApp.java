import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketApp {

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(9000);
		Socket clientSocket = serverSocket.accept();
		InputStream inputStream = clientSocket.getInputStream();
		OutputStream outputStream = clientSocket.getOutputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
		String line;
		while ((line = reader.readLine()) != null) {
			System.out.println("'" + line + "'");
			if (line.equals("")) {
				writer.write("HTTP/1.1 200 OK\n");
				writer.write("\n");
				writer.write("Hello, browser");
				break;
			}
		}
		writer.close();
		reader.close();
		serverSocket.close();
	}

}
