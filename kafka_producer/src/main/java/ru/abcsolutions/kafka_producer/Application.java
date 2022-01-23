package ru.abcsolutions.kafka_producer;

import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class Application {
    public static void main(String[] args) {
        System.out.println("hello");
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("acks", "all");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        
        try (Producer<String, String> producer = new KafkaProducer<>(properties)) {
            producer.send(new ProducerRecord<>("test", "key", "value"));
        }
    }
}
