package dev.ohhoonim.jdbc_query_dsl.orderlines;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderLinesMessagingConfguration {

    private static final String ORDERS_DESTINATION = "orders";

    @Bean
    Binding binding(Queue queue, Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ORDERS_DESTINATION).noargs();
    }

    @Bean
    Queue queue() {
        return QueueBuilder.durable().build();
    }

    @Bean 
    Exchange exchange() {
        return ExchangeBuilder.directExchange(ORDERS_DESTINATION).durable(true).build();
    }
    
}
