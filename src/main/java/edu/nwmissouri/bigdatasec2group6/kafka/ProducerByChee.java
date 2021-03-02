package edu.nwmissouri.bigdatasec2group6.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.Scanner;

/**
 * Code from Dr. Denise Case on 10/29/2019. Modified by Guan Ming Chee (line 42-52) on March 1st 2021.
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

    // input string into list char, sum their ascii values

    String line = in.nextLine();
    int sum = 0;
    char [] newchr = line.toCharArray();
    while (!line.equals("exit")) {
      for (int i=0;i<newchr.length;i++){
        char singlechr = newchr[i];
        int a = singlechr;
        sum+=a;
      }
      String sum_str=  "Sum of Ascii value of " + line + " is " + String.valueOf(sum);
      ProducerRecord<String, String> rec = new ProducerRecord<String, String>(topicName, sum_str);

      producer.send(rec);
      line = in.nextLine();
    }

    in.close();
    producer.close();
  }
}