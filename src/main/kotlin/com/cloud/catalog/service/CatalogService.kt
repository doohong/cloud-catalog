package com.cloud.catalog.service

import com.cloud.catalog.entity.CatalogEntity
import com.cloud.catalog.entity.CatalogRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class CatalogService(
    private val catalogRepository: CatalogRepository
) {
    fun getAllCatalogs(): Iterable<CatalogEntity> {
        return catalogRepository.findAll();
    }
}