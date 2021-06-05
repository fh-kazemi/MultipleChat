
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;

public class MultipleChatClientServer {

	public static void main(String[] args)throws IOException {
		try (Socket socket = new Socket("localhost",9876)) {
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