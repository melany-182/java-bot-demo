package bo.edu.ucb.est;
import java.util.ArrayList;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Calculadora extends TelegramLongPollingBot {
	public ArrayList<Usuario> usuarios=new ArrayList<Usuario>();
	
    @Override
    public String getBotToken() {
        return "2040883961:AAGDxLPpOuROPjHlyX-JWCOaTU2UHHXhCXE";
    }
    
    @Override
    public void onUpdateReceived(Update update) { // se ejecuta cada vez que llega un mensaje
    	for (int i=0; i<usuarios.size(); i++) {
    		System.out.println(usuarios.get(i).toString());
    	}
    	int aux=0;
    	Long idusuario=update.getMessage().getFrom().getId();
    	for (int i=0; i<usuarios.size(); i++) { // verificación de existencia
    		if ((usuarios.get(i).getUserId()).equals(idusuario)) { // si ya existe
    			aux=1;
    			break;
    		}
    	}
    	if (aux==0) { // si no existe todavía
    		Usuario usuario=new Usuario(idusuario,0);
        	usuarios.add(usuario);
    	}
    	System.out.println("Mensaje: "+update.toString()+"\n");
    	
        if (update.hasMessage()) {
        	for (int i=0; i<usuarios.size(); i++) {
        		if ((usuarios.get(i).getUserId()).equals(update.getMessage().getFrom().getId())) {
        			if ((usuarios.get(i).getFlag())==0) {
        				enviarMensaje(update,"Bienvenido al Bot Calculadora.\nSeleccione una de las siguientes opciones:\n1. Sumar dos números.\n2. Calcular serie de Fibonacci.");
                        usuarios.get(i).setFlag(1);
                        return; // importante ********************
        			}
        			if ((usuarios.get(i).getFlag())==1) { // se le envió el mensaje inicial
        				try {
                			int opcion=Integer.parseInt(update.getMessage().getText());
                			usuarios.get(i).setOpcion(opcion);
                        	if ((usuarios.get(i).getOpcion())==1) {
                        		enviarMensaje(update,"Ingrese el primer número:");
                                usuarios.get(i).setFlag(2);
                                return;
                        	}
                        	else if ((usuarios.get(i).getOpcion())==2) {
                        		enviarMensaje(update,"Funcionalidad no implementada. Intente otro día.");
                                usuarios.get(i).setFlag(0);
                                enviarMensaje(update,"Bienvenido al Bot Calculadora.\nSeleccione una de las siguientes opciones:\n1. Sumar dos números.\n2. Calcular serie de Fibonacci.");
                                usuarios.get(i).setFlag(1);
                                return;
                        	}
                        	else {
                        		enviarMensaje(update,"Bienvenido al Bot Calculadora.\nSeleccione una de las siguientes opciones:\n1. Sumar dos números.\n2. Calcular serie de Fibonacci.");
                                usuarios.get(i).setFlag(1);
                                return;
                        	}
                		}
                		catch (NumberFormatException e) {
                			e.printStackTrace();
                			enviarMensaje(update,"Bienvenido al Bot Calculadora.\nSeleccione una de las siguientes opciones:\n1. Sumar dos números.\n2. Calcular serie de Fibonacci.");
                			usuarios.get(i).setFlag(1);
                			return;
                		}
        			}
        			if ((usuarios.get(i).getFlag())==2) {
        				try {
                			int num1=Integer.parseInt(update.getMessage().getText());
                			usuarios.get(i).setNum1(num1);
                			enviarMensaje(update,"Ingrese el segundo número:");
                			usuarios.get(i).setFlag(3);
                            return;
                		}
                		catch (NumberFormatException e) {
                			e.printStackTrace();
                			enviarMensaje(update,"Bienvenido al Bot Calculadora.\nSeleccione una de las siguientes opciones:\n1. Sumar dos números.\n2. Calcular serie de Fibonacci.");
                			usuarios.get(i).setFlag(1);
                            return;
                		}
        			}
        			if ((usuarios.get(i).getFlag())==3) {
        				try {
                			int num2=Integer.parseInt(update.getMessage().getText());
                			usuarios.get(i).setNum2(num2);
                    		enviarMensaje(update,"La suma de los números es: "+((usuarios.get(i).getNum1())+(usuarios.get(i).getNum2()))+".");
                    		usuarios.get(i).setFlag(0);
                            enviarMensaje(update,"Bienvenido al Bot Calculadora.\nSeleccione una de las siguientes opciones:\n1. Sumar dos números.\n2. Calcular serie de Fibonacci.");
                            usuarios.get(i).setFlag(1);
                            return;
                		}
                		catch (NumberFormatException e) {
                			e.printStackTrace();
                			enviarMensaje(update,"Bienvenido al Bot Calculadora.\nSeleccione una de las siguientes opciones:\n1. Sumar dos números.\n2. Calcular serie de Fibonacci.");
                			usuarios.get(i).setFlag(1);
                            return;
                		}
        			}
        		}
        	}
        }
    }
    
    public void enviarMensaje(Update update,String mensaje) {
    	SendMessage message=new SendMessage(); // crea el objeto para enviar el mensaje
        message.setChatId(update.getMessage().getChatId().toString()); // define a quién se le enviará el mensaje
        message.setText(mensaje);
        try {
            execute(message); // envía el mensaje
        }
        catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "Calculadora_182Bot";
    }
}
