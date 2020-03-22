package com.l30.labproj;

import java.util.*;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

/**
 * KafkaTopicConfig
 */
@Configuration
public class KafkaTopicConfig {

    @Value(value = "192.168.1.13:9092")
    private String bootstrapAddress;

    @Bean
    public KafkaAdmin kafkaAdmin(){
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configs);
    }
    
    @Bean
    public NewTopic opensky(){
        return new NewTopic("baeldung", 1, (short)1);
    }
}