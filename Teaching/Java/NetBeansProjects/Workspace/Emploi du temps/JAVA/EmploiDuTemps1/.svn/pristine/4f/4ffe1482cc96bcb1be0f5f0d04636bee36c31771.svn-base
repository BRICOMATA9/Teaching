package Systeme;
import javax.mail.*;
import javax.mail.internet.*;

import java.util.*;

/**
 * Classe qui envoi un mail
 * @author Alexander Remen et Tonya vo Thanh
 * Elle doit etre utilise par le serveur sur l'INSA pour que le serveur SMTP soit reconnu.
 */

public class SimpleMailSender {
	/**
	 * Il faut changer le nom du serveur smtp en fonction de la machine ou tourne le serveur: 
	 *"smtp.free.fr" = serveur chez tonya et alex a toulouse
	 *"melinite.insa-toulouse.fr" = serveur a l'insa
	 *"smtp.online.no" = serveur chez alex en norvege
	 */
	private boolean envoiok = true; 
	//private static String smtpServer = "smtp.free.fr"; //serveur chez tonya et alex a toulouse
	//private String smtpServer = "melinite.insa-toulouse.fr" //serveur a l'insa
	private String smtpServer = "smtp.online.no"; //serveur chez alex en norvege
	/**
	 * Methode qui envoie un mail. Il faut changer le SMTP dans la source pour qu'il marche sur le serveur en compte! 
	 * @param to : destinataire
	 * @param from : mel du expediteur 
	 * @param subject : sujet du mail
	 * @param body : contenu du mail
	 * @return Mail_envoye : true si l'envoi est reussi, false si echoue
	 */
	public boolean envoimail(String to, String from, String subject, String body){
		try 
		{
			send(smtpServer,to,from,subject,body);
		}
		catch (Exception ex)
		{
			envoiok = false;
			System.out.println("envoiok = false");
		}
		return envoiok;
	}
	
	  /*
	    * "send" method to send the message.
	    * @throws Exception
	    */
	  private void send(String smtpServer, String to, String from
	   , String subject, String body) throws Exception
	  {

	      Properties props = System.getProperties();
	      // -- Attaching to default Session, or we could start a new one --
	      props.put("mail.smtp.host", smtpServer);
	      Session session = Session.getDefaultInstance(props, null);
	      // -- Create a new message --
	      Message msg = new MimeMessage(session);
	      // -- Set the FROM and TO fields --
	      msg.setFrom(new InternetAddress(from));
	      msg.setRecipients(Message.RecipientType.TO,
	        InternetAddress.parse(to, false));
	      // -- We could include CC recipients too --
	      // if (cc != null)
	      // msg.setRecipients(Message.RecipientType.CC
	      // ,InternetAddress.parse(cc, false));
	      // -- Set the subject and body text --
	      msg.setSubject(subject);
	      msg.setText(body);
	      // -- Set some other header information --
	      msg.setHeader("X-Mailer", "LOTONtechEmail");
	      msg.setSentDate(new Date());
	      // -- Send the message --
	      Transport.send(msg);
	      //System.out.println("Message sent OK.");
	    }

	
}	
