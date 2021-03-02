package edu.nwmissouri.bigdatasec2group6.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.Scanner;
import java.util.Random;

/**
 * Created by sunilpatil on 12/28/15. Modified by Denise Case on 10/29/2019.
 */
public class ProducerByChee {
  private static Scanner in;

  public static void main(String[] argv) throws Exception {
    if (argv.length != 1) {
      System.err.println("Please specify 1 parameter (the name of the topic)");
      System.exit(-1);
    }
    String topicName = argv[0];
    in = new Scanner(System.in);
    System.out.println("Thank you for providing the topic " + topicName + "\n");
    System.out.println("Enter message (type exit to quit).\n");

    // Configure the Producer
    Properties configProperties = new Properties();
    configProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    configProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
        "org.apache.kafka.common.serialization.ByteArraySerializer");
    configProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
        "org.apache.kafka.common.serialization.StringSerializer");
    System.out.println("The configuration properties are: " + configProperties.toString());
    System.out.println("\nWill use this configuration to create a producer.\n");

    org.apache.kafka.clients.producer.Producer producer = new KafkaProducer(configProperties);

    // Make our own messages - create your custom logic here

    for (int i = 10; i <= 1; i--) {
      String message = "hello" + i;
      ProducerRecord<String, String> rec = new ProducerRecord<String, String>(topicName, message);
      producer.send(rec);
    }

    // still allow input from keyboard

    String line = in.nextLine();
    while (!line.equals("exit")) {
        Random rand = new Random();
        String [] color = {"red","orange","yellow","green","blue","indigo","purple"};
        int index = rand.nextInt(color.length);
        String chosencolor = message + color[index];
      ProducerRecord<String, String> rec = new ProducerRecord<String, String>(topicName, chosencolor);

      producer.send(rec);
      line = in.nextLine();
    }

    in.close();
    producer.close();
  }
}