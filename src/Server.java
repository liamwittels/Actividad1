import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Server {

	public static void main(String[] args) throws IOException {
		
		ServerSocket listener = new ServerSocket(9999);
		
		System.out.println("Servidor Iniciado");
		
		try {
			while(true) {
			
			Socket socket = listener.accept();
			
			//Leer la opcion del cliente
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			int clientOption = 0;
			
			String inputOption = input.readLine();

			
			//Verificamos que es un numero
			if(isNumeric(inputOption)) {
				
				clientOption = Integer.parseInt(inputOption);
				
			}
			
			//--------------OPCION1---------------
			
			//Creamos el stream de salida y Imprimimos por pantalla el resultado
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			
			//Numero aleatorio 1 - 10
			Random randomGenerator1 = new Random();
			int random_1 = randomGenerator1.nextInt(10) + 1;
			
			//Numero aleatorio (cliente) 1 - 10
			Random randomClient1 = new Random();
			int random_client1 = randomClient1.nextInt(10) + 1;
			
			//--------------OPCION2---------------
			
			//Numero aleatorio 1 - 100
			Random randomGenerator2 = new Random();
			int random_2 = randomGenerator2.nextInt(100) + 1;
			
			//Numero aleatorio (cliente) 1 - 100
			Random randomClient2 = new Random();
			int random_client2 = randomClient2.nextInt(100) + 1;
			
			//--------------OPCION3---------------
			
			//Numero aleatorio 1 - 1000
			Random randomGenerator3 = new Random();
			int random_3 = randomGenerator3.nextInt(1000) + 1;
			
			//Numero aleatorio (cliente) 1 - 1000
			Random randomClient3 = new Random();
			int random_client3 = randomClient3.nextInt(1000) + 1;
			
			//--------------OPCION4---------------
			
			//Numero aleatorio 1 - 10.000
			Random randomGenerator4 = new Random();
			int random_4 = randomGenerator4.nextInt(10000) + 1;
			
			//Numero aleatorio (cliente) 1 - 10.000
			Random randomClient4 = new Random();
			int random_client4 = randomClient4.nextInt(10000) + 1;
			
			//--------------OPCION5---------------
			
			//Numero aleatorio 1 - 100.000
			Random randomGenerator5 = new Random();
			int random_5 = randomGenerator5.nextInt(100000) + 1;
			
			//Numero aleatorio (cliente) 1 - 100.000
			Random randomClient5 = new Random();
			int random_client5 = randomClient5.nextInt(100000) + 1;
			
			
			//Utilizamos la funcion switch para que dependiendo de la opcion que se escoja imprima lo solicitado
			
			switch(clientOption) {
			
			case 1:	
					//Opcion 1 1-10
					if(random_1 == random_client1) {
					
					out.println("Tu numero es: " + random_client1 + " || " + " El numero ganador es: " + random_1 + " || " + " HAS GANADO 10 EUROS!");

					
					}
				
					else {
					
					out.println("Tu numero es: " + random_client1 + " || " + " El numero ganador es: " + random_1 + " || " + " Lo siento, intentalo de nuevo");

					
					}
				
				break;
				
			case 2:	
					//Opcion 2 1-100
					if(random_2 == random_client2) {
					
					out.println("Tu numero es: " + random_client2 + " || " + " El numero ganador es: " + random_2 + " || " + " HAS GANADO 100 EUROS!");

					
					}
				
					else {
					
					out.println("Tu numero es: " + random_client2 + " || " + " El numero ganador es: " + random_2 + " || " + " Lo siento, intentalo de nuevo");

					
					}
					
				break;
				
			case 3:	
					//Opcion 3 1-1.000
					if(random_3 == random_client3) {
					
					out.println("Tu numero es: " + random_client3 + " || " + " El numero ganador es: " + random_3 + " || " + " HAS GANADO 1.000 EUROS!");

					
					}
				
					else {
					
					out.println("Tu numero es: " + random_client3 + " || " + " El numero ganador es: " + random_3 + " || " + " Lo siento, intentalo de nuevo");

					
					}
					
				break;
				
			case 4: 
					//Opcion 4 1-10.000
					if(random_4 == random_client4) {
					
					out.println("Tu numero es: " + random_client4 + " || " + " El numero ganador es: " + random_4 + " || " + " HAS GANADO 10.000 EUROS!");

					
					}
				
					else {
					
					out.println("Tu numero es: " + random_client4 + " || " + " El numero ganador es: " + random_4 + " || " + " Lo siento, intentalo de nuevo");

					
					}
					
				break;
				
			case 5: 
					//Opcion 5 1-100.000
					if(random_5 == random_client5) {
					
					out.println("Tu numero es: " + random_client5 + " || " + " El numero ganador es: " + random_5 + " || " + " HAS GANADO 100.000 EUROS!");

					
					}
				
					else {
					
					out.println("Tu numero es: " + random_client5 + " || " + " El numero ganador es: " + random_5 + " || " + " Lo siento, intentalo de nuevo");

					
					}
					
				break;
				
			default: out.println("Opcion Invalida");
				break;
			
			
			}
			
			
			
			
			socket.close();
			
			}
		}finally {
			listener.close();
		}
	}
	
	//Para verificar si es un numero lo introducido por el cliente
	public static boolean isNumeric(String str) {
		
		try {
			Integer.parseInt(str);
		}catch(NumberFormatException e) {
			return false;
		}
		return true;
	}

}