package ru.abcsolutions.kafka_consumer;

import java.util.Arrays;
import java.util.Properties;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.clients.consumer.ConsumerRecord;

public class Application {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("group.id", "consumer");
        properties.put("key.deserializer", StringDeserializer.class.getName());
        properties.put("value.deserializer", StringDeserializer.class.getName());
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>( properties);
        consumer.subscribe(Arrays.asList("test"));

        try {
             while (true) {
                ConsumerRecords<String, String> records = consumer.poll(10);
                    for (ConsumerRecord<String, String> record : records)
                        System.out.println(record.key()+" "+ record.value());
             }
        } finally {
             consumer.close();
        }

    }
}
