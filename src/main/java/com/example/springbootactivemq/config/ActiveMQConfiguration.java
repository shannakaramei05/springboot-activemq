//package com.example.springbootactivemq.config;
//
//import jakarta.jms.ConnectionFactory;
//import jakarta.jms.Destination;
//import jakarta.jms.MessageConsumer;
//import org.apache.activemq.ActiveMQConnectionFactory;
//import org.apache.activemq.broker.BrokerService;
//import org.apache.activemq.command.ActiveMQQueue;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jms.connection.CachingConnectionFactory;
//import org.springframework.jms.core.JmsTemplate;
//import org.springframework.jms.listener.DefaultMessageListenerContainer;
//import org.springframework.jms.listener.MessageListenerContainer;
//
//@Configuration
//public class ActiveMQConfiguration {
//    @Value("${jms.broker.url}")
//    private String brokerUrl;
//
//    @Value("${jms.queue.name}")
//    private String queueName;
//
//    private final MessageConsumer messageConsumer;
//
//        public ActiveMQConfiguration(MessageConsumer messageConsumer) {
//        this.messageConsumer = messageConsumer;
//    }
//
//
//    /**Setup Embedded Broker*/
//    @Bean
//    public BrokerService broker() throws Exception{
//        BrokerService broker = new BrokerService();
//        broker.addConnector(brokerUrl);
//        broker.setPersistent(false);
//        return broker;
//    }
//
//    @Bean
//    public ConnectionFactory connectionFactory() {
//        return new CachingConnectionFactory(new ActiveMQConnectionFactory(brokerUrl));
//    }
//
//    @Bean
//    public Destination destination() {
//        return new ActiveMQQueue(queueName);
//    }
//
//    @Bean
//    public JmsTemplate jmsTemplate(ConnectionFactory connectionFactory, Destination destination) {
//        JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory);
//        jmsTemplate.setDefaultDestination(destination);
//
//        return jmsTemplate;
//    }
//
//    @Bean
//    public MessageListenerContainer defaultMessageListenerContainer(ConnectionFactory connectionFactory,
//                                                                    Destination destination) {
//        DefaultMessageListenerContainer defaultMessageListenerContainer = new DefaultMessageListenerContainer();
//        defaultMessageListenerContainer.setConnectionFactory(connectionFactory);
//        defaultMessageListenerContainer.setDestination(destination);
//        defaultMessageListenerContainer.setMessageListener(messageConsumer);
//
//        return defaultMessageListenerContainer;
//    }
//}
