package kafkaplayground;


import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import java.util.Properties;
import org.apache.kafka.clients.producer.Producer;

public class KafkaLogWriter {

    public static void addToLog(String memo)throws Exception {
        // private static Scanner in;
        String topicName = "MemosLog";

            /*
            First, we set the properties of the Kafka Log
             */
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        // We create the producer
        Producer<String, String> producer = new KafkaProducer<>(props);
        // We send the line into the producer
        producer.send(new ProducerRecord<String, String>(topicName, memo));

        // We close the producer
        producer.close();

    }
}

