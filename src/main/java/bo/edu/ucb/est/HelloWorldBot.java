package bo.edu.ucb.est;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class HelloWorldBot extends TelegramLongPollingBot {
	public int flag=0; // variable de instancia

    @Override
    public String getBotToken() {
        return "2018949517:AAF_XTwx70Z7h9EwOBp6gYy4RqVX4yWEgPY";
    }

    @Override
    public void onUpdateReceived(Update update) {
    	int num1=0,num2,suma;
        System.out.println("Mensaje: "+update.toString()+"\n");
        if (update.hasMessage()) { // Verificamos que tenga mensaje
        	if (flag==0) {
        		// Creo el objeto para enviar un mensaje
                SendMessage message=new SendMessage();
                message.setChatId(update.getMessage().getChatId().toString()); //Define a quien le vamos a enviar el mensaje
                message.setText("Bienvenido al Bot Calculadora.\nSeleccione una de las siguientes opciones:\n1. Sumar dos números.\n2. Calcular serie de Fibonacci.");
                flag=1;
                try {
                    execute(message); // Envia el mensaje
                }
                catch (TelegramApiException e) {
                    e.printStackTrace();
                }
                return;
        	}
        	if (flag==1) {
        		try {
        			String opcion=update.getMessage().getText();
                	if (opcion.equals("1")) {
                		SendMessage message1=new SendMessage();
                        message1.setChatId(update.getMessage().getChatId().toString()); //Define a quien le vamos a enviar el mensaje
                        message1.setText("Ingrese el primer número:");
                        flag=2;
                        try {
                            execute(message1); // Envia el mensaje
                            //System.exit(0);
                        }
                        catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                        return;
                	}
                	if (opcion.equals("2")) {
                		SendMessage messageb=new SendMessage();
                        messageb.setChatId(update.getMessage().getChatId().toString()); //Define a quien le vamos a enviar el mensaje
                        messageb.setText("Funcionalidad no implementada. Intente otro día.");
                        flag=0;
                        try {
                            execute(messageb); // Envia el mensaje
                            //System.exit(0);
                        }
                        catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                        return;
                	}
        		}
        		catch (NumberFormatException e) {
        			e.printStackTrace();
        		}
        	}
        	if (flag==2) {
        		try {
        			num1=Integer.parseInt(update.getMessage().getText());
                	SendMessage message2=new SendMessage();
                    message2.setChatId(update.getMessage().getChatId().toString()); //Define a quien le vamos a enviar el mensaje
                    message2.setText("Ingrese el segundo número:");
                    flag=3;
                    try {
                    	execute(message2); // Envia el mensaje
                    	//System.exit(0);;
                    }
                    catch (TelegramApiException e) {
                         e.printStackTrace();
                    }
                    return;
        		}
        		catch (NumberFormatException e) {
        			e.printStackTrace();
        		}
        	}
        	if (flag==3) {
        		try {
        			num2=Integer.parseInt(update.getMessage().getText());
            		suma=num1+num2;
            		SendMessage message3=new SendMessage();
                    message3.setChatId(update.getMessage().getChatId().toString()); //Define a quien le vamos a enviar el mensaje
                    message3.setText("La suma de los números es "+suma);
                    flag=0;
                    try {
                    	execute(message3); // Envia el mensaje
                    	//System.exit(0);
                    }
                    catch (TelegramApiException e) {
                         e.printStackTrace();
                    }
                    return;
        		}
        		catch (NumberFormatException e) {
        			e.printStackTrace();
        		}
        	}
        }
    }

    @Override
    public String getBotUsername() {
        return "Suma_182Bot";
    }
}
