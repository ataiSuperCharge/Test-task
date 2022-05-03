package kg.gns.testtask.services;

public interface EmailService {

    void sendMessage(String sendTo, String subject, String text);

}
