import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MultipleChatServerSocket {
	public static void main(String[] args) throws IOException {
		try(ServerSocket server=new ServerSocket(9876)){
			Socket socket=server.accept();
			BufferedReader inStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedReader systemIn = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter outStream = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			String txt;
			boolean check=true;
			do {
				if (inStream.ready()) {
						System.out.println("received :" + inStream.readLine());
				}
				if (systemIn.ready()) {
						txt=systemIn.readLine();
						outStream.write(txt+"\n");
						outStream.flush();
				}
			} while (check);
		}
	}
}
