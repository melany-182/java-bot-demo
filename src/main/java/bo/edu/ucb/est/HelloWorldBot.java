/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.edu.ucb.est;

import java.util.List;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
/**
 *
 * @author ecampohermoso
 */
public class HelloWorldBot extends TelegramLongPollingBot {

    @Override
    public String getBotToken() {
        return "1909892127:AAEZYi2QpWtVsGqs5TJ_4lUb-rC2Y-zebXE";
    }

    @Override
    public void onUpdateReceived(Update update) {
    	int flag=0;
        System.out.println("Llego mensaje: " + update.toString());
        if (update.hasMessage()) { // Verificamos que tenga mensaje
            // Creo el objeto para enviar un mensaje
            SendMessage message=new SendMessage();
            message.setChatId(update.getMessage().getChatId().toString()); //Define a quien le vamos a enviar el mensaje
            message.setText("Hello "+update.getMessage().getFrom().getFirstName()+". Envíame dos números separados por una coma (,).");
            try {
                execute(message); // Envia el mensaje
                flag=1;
            }
            catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
        if (flag==1) {
        	
        }
    }

    @Override
    public String getBotUsername() {
        return "Suma_182Bot";
    }
}
