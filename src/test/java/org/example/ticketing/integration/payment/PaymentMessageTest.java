package org.example.ticketing.integration.payment;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.ticketing.common.message.KafkaConsumer;
import org.example.ticketing.common.message.KafkaProducer;
import org.example.ticketing.domain.payment.service.OrderPaidEvent;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertNotEquals;

@SpringBootTest
@DirtiesContext
@RunWith(SpringRunner.class)
@EmbeddedKafka(partitions = 1, brokerProperties = { "listeners=PLAINTEXT://localhost:9092", "port=9092" })
public class PaymentMessageTest {

    @Autowired
    KafkaProducer producer;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    private KafkaConsumer consumer;

    @Test
    public void kafkaTest() throws Exception {
        // given
        producer.send("reservation", "a string containing \"embedded-test-topic\"");
        consumer.getLatch().await(10000, TimeUnit.MILLISECONDS);

        assertThat(consumer.getLatch().getCount(), equalTo(0L));
        assertThat(consumer.getMessage(), containsString("embedded-test-topic"));
    }
}