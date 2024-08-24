package dev.ohhoonim.jdbc_query_dsl.orderlines.messaging;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class OrderLinesPayment {

    private static final String ORDERLINES_PAYMENT_DESTINATION = "orderLines-payment";

    @Bean
    Binding binding(Queue queue, Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ORDERLINES_PAYMENT_DESTINATION).noargs();
    }

    @Bean
    Queue queue() {
        return QueueBuilder.durable(ORDERLINES_PAYMENT_DESTINATION).build();
    }

    @Bean 
    Exchange exchange() {
        return ExchangeBuilder.directExchange(ORDERLINES_PAYMENT_DESTINATION).durable(true).build();
    }
    
}
