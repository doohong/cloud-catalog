package com.cloud.order.messageque


import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory

@Configuration
class KafkaConsumerConfig {
  @Bean
  fun consumerFactory(): ConsumerFactory<String, String> {
    val properties = mapOf(
        ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG to "127.0.0.1:9092",
        ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG to StringDeserializer::class,
        ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG to StringDeserializer::class
    )
    return DefaultKafkaConsumerFactory(properties)
  }

  @Bean
  fun kafkaListenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, String> {
    val concurrentKafkaListenerContainerFactory = ConcurrentKafkaListenerContainerFactory<String, String>()
    concurrentKafkaListenerContainerFactory.consumerFactory = consumerFactory()
    return concurrentKafkaListenerContainerFactory
  }
}