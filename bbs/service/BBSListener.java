package nl.hanze.bbs.service;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class BBSListener implements MessageListener {
	
    public BBSListener() {
        try {
            ActiveMQConnectionFactory connectionFactory = 
            		new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
            Connection connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue("BBSQueue");
            MessageConsumer consumer = session.createConsumer(destination);
            consumer.setMessageListener(this);
            System.out.println("Now Listening");
        } catch (Exception e) {
            System.out.println("Caught: " + e);
            e.printStackTrace();
        }
    }

	public void onMessage(Message message) {
		try {
			if (message instanceof TextMessage) {
	            TextMessage textMessage = (TextMessage) message;
	            String text = textMessage.getText();
	            BBSService service = new BBSService();
	            service.handleMessage(text);
	        } else {
	            System.out.println(" Received: " + message);
	        }
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		new BBSListener();
	}
}

