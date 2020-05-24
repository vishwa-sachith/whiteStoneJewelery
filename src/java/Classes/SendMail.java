/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author ASUS
 */
public class SendMail {

    public void sendEmail(String subject, String reciever, String htmlcontent) {
        try {
            final String sender_mail = "assassinassassine616@gmail.com";
            final String sender_password = "henagahapan";

            
            
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

            Session session = Session.getInstance(props, new javax.mail.Authenticator() {

                protected PasswordAuthentication getPasswordAuthentication() {

                    return new PasswordAuthentication(sender_mail, sender_password);

                }

            });
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sender_mail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(reciever));

            message.setSubject(subject);
            // message.setText(msg_content);
            message.setContent(htmlcontent, "text/html;charset=utf-8");

            Transport.send(message);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}

