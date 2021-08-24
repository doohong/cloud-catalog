package com.cloud.catalog.entity

import org.springframework.data.repository.CrudRepository

interface CatalogRepository : CrudRepository<CatalogEntity, Long> {
  fun findByProductId(productId: String): CatalogEntity?
}