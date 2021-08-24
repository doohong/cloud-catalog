package com.cloud.order.messageque

import com.cloud.catalog.entity.CatalogRepository
import com.fasterxml.jackson.core.JsonParseException
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class KafkaConsumer(
    private val catalogRepository: CatalogRepository
) {
  @KafkaListener(topics = ["example-catalog-topic"])
  fun updateQty(kafkaMessage: String) {
    var map = mapOf<Any, Any>()
    val mapper = ObjectMapper()
    try {
      map = mapper.readValue(kafkaMessage, object: TypeReference<Map<Any, Any>>(){})
    } catch (e: JsonParseException) {
      e.printStackTrace()
    }
    val entity = catalogRepository.findByProductId(map["productId"] as String)
    if (entity != null) {
      entity.stock = entity.stock - map["qty"] as Int
      catalogRepository.save(entity)
    }
  }
}