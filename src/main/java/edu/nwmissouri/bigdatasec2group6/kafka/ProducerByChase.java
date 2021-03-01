package edu.nwmissouri.bigdatasec2group6.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Chase Staples on 02/27/2021
 */
public class ProducerByChase {
  private static Scanner in;

  public static void main(String[] argv) throws Exception {
    if (argv.length != 1) {
      System.err.println("Please specify 1 parameter (the name of the topic)");
      System.exit(-1);
    }
    String topicName = argv[0];
    in = new Scanner(System.in);
    System.out.println("Your topic is: " + topicName + "\n");
    System.out.println("Enter message (type exit to quit).\n");

    /* Configure the Producer here
    ______________________________________________________________
    */
    Properties configProperties = new Properties();
    configProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:2021");
    configProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.ByteArraySerializer");
    configProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
    System.out.println("The configuration properties are: " + configProperties.toString());


    org.apache.kafka.clients.producer.Producer producer = new KafkaProducer(configProperties);

    //Logic

    for (int i = 1; i <= 10; i++) {
        String game = favGame(i);
        ProducerRecord<String, String> record = new ProducerRecord<String, String>(topicName, game);
        producer.send(record);
      }
    // still allowing input from keyboard

    String line = in.nextLine();
    while (!line.equals("exit")) {
      ProducerRecord<String, String> record = new ProducerRecord<String, String>(topicName, line);
      producer.send(record);
      line = in.nextLine();
    }

    in.close();
    producer.close();

  }

  public static void favGame(int x) {
    Dictionary<Integer, String> people = new Hashtable<Integer, String>();
    people.put(1, "Chase"); people.put(2, "Chee"); people.put(3, "James");
    people.put(4, "Carl"); people.put(5, "William"); people.put(6, "Alex");
    people.put(7, "Brad"); people.put(8, "Steve"); people.put(9, "Earl"); 
    people.put(10, "Dale");
   
    String games = {
        "Minecraft", "COD", "Destiny",
        "Farcry", "League of Legends", "Last of Us",
        "Fortnite"
      };
    }

    int game = new Random().nextInt(games.length);

    System.out.println(people.get(x) + "favorite game is: " + games[game]);
        
}