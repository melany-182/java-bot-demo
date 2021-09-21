package bo.edu.ucb.est;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Calculadora extends TelegramLongPollingBot {
	public int flag=0; // variable de instancia
	public int num1=0,num2,suma;
	
    @Override
    public String getBotToken() {
        return "2040883961:AAGDxLPpOuROPjHlyX-JWCOaTU2UHHXhCXE";
    }
    
    @Override
    public void onUpdateReceived(Update update) { // se ejecuta cada vez que llega un mensaje
    	System.out.println(flag+"\n");
    	System.out.println("Mensaje: "+update.toString()+"\n");
        if (update.hasMessage()) {
        	if (flag==0) {
                enviarMensaje(update,"Bienvenido al Bot Calculadora.\nSeleccione una de las siguientes opciones:\n1. Sumar dos números.\n2. Calcular serie de Fibonacci.");
                flag=1;
                return; // importante ********************
        	}
        	if (flag==1) { // se le envió el mensaje inicial
        		try {
        			int opcion=Integer.parseInt(update.getMessage().getText());
                	if (opcion==1) {
                		enviarMensaje(update,"Ingrese el primer número:");
                        flag=2;
                        return;
                	}
                	else if (opcion==2) {
                		enviarMensaje(update,"Funcionalidad no implementada. Intente otro día.");
                        flag=0;
                        enviarMensaje(update,"Bienvenido al Bot Calculadora.\nSeleccione una de las siguientes opciones:\n1. Sumar dos números.\n2. Calcular serie de Fibonacci.");
                        flag=1;
                        return;
                	}
                	else {
                		enviarMensaje(update,"Bienvenido al Bot Calculadora.\nSeleccione una de las siguientes opciones:\n1. Sumar dos números.\n2. Calcular serie de Fibonacci.");
                        flag=1;
                        return;
                	}
        		}
        		catch (NumberFormatException e) {
        			e.printStackTrace();
        			enviarMensaje(update,"Bienvenido al Bot Calculadora.\nSeleccione una de las siguientes opciones:\n1. Sumar dos números.\n2. Calcular serie de Fibonacci.");
                    flag=1;
        			return;
        		}
        	}
        	if (flag==2) {
        		try {
        			num1=Integer.parseInt(update.getMessage().getText());
        			enviarMensaje(update,"Ingrese el segundo número:");
                    flag=3;
                    return;
        		}
        		catch (NumberFormatException e) {
        			e.printStackTrace();
        			enviarMensaje(update,"Bienvenido al Bot Calculadora.\nSeleccione una de las siguientes opciones:\n1. Sumar dos números.\n2. Calcular serie de Fibonacci.");
                    flag=1;
                    return;
        		}
        	}
        	if (flag==3) {
        		try {
        			num2=Integer.parseInt(update.getMessage().getText());
            		suma=num1+num2;
            		enviarMensaje(update,"La suma de los números es: "+suma+".");
                    flag=0;
                    enviarMensaje(update,"Bienvenido al Bot Calculadora.\nSeleccione una de las siguientes opciones:\n1. Sumar dos números.\n2. Calcular serie de Fibonacci.");
                    flag=1;
                    return;
        		}
        		catch (NumberFormatException e) {
        			e.printStackTrace();
        			enviarMensaje(update,"Bienvenido al Bot Calculadora.\nSeleccione una de las siguientes opciones:\n1. Sumar dos números.\n2. Calcular serie de Fibonacci.");
                    flag=1;
                    return;
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
