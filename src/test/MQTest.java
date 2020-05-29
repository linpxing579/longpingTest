package test;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

import javax.jms.*;

public class MQTest {



    @Test
    public static void testMQProducerQueue() throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");

        Connection connection = connectionFactory.createConnection();

        connection.start();

        // 创建Session，此方法第一个参数表示会话是否在事务中执行，第二个参数设定会话的应答模式
//        1、Session.AUTO_ACKNOWLEDGE：为自动确认，客户端发送和接收消息不需要做额外的工作。
//        2、Session.CLIENT_ACKNOWLEDGE：为客户端确认。客户端接收到消息后，必须调用javax.jms.Message的acknowledge方法。jms服务器才会删除消息。
//        3、DUPS_OK_ACKNOWLEDGE：允许副本的确认模式。一旦接收方应用程序的方法调用从处理消息处返回，会话对象就会确认消息的接收；而且允许重复确认。在需要考虑资源使用时，这种模式非常有效。
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);

        Queue queue = session.createQueue("test_MQ");

        MessageProducer producer = session.createProducer(queue);

        String s = "{transactionReceiptId:12,transactionReceiptNo:\"SG1\",userId:18930468}";
        TextMessage message = session.createTextMessage(s);

        producer.send(message);

        producer.close();
        session.close();
        connection.start();
    }


    @Test
    public static void testMQConsumer() throws Exception {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");

        Connection connection = connectionFactory.createConnection();

        connection.start();

        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);

        Destination destination = session.createQueue("test_MQ");

        MessageConsumer consumer = session.createConsumer(destination);

        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                if(message instanceof TextMessage){
                    TextMessage textMessage = (TextMessage)message;

                    try {
                        //session为Session.CLIENT_ACKNOWLEDGE时，需调用此方法通知jms服务器删除消息
//                        textMessage.acknowledge();
                        System.out.println(textMessage.getText());
                    } catch (JMSException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        });

        System.in.read();
        consumer.close();

        session.close();
        connection.close();

    }
}
