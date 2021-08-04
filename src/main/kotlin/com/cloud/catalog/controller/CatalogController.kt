package com.cloud.catalog.controller

import com.cloud.catalog.service.CatalogService
import com.cloud.catalog.vo.ResponseCatalog
import org.modelmapper.ModelMapper
import org.modelmapper.convention.MatchingStrategies
import org.springframework.core.env.Environment
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/catalog-service")
class CatalogController(
    private val env: Environment,
    private val catalogService: CatalogService,
) {
    @GetMapping("/health_check")
    fun status(): String {
        return "It's Working in Catalog Service on PORT ${env.getProperty("local.server.port")}"
    }

    @GetMapping("/catalogs")
    fun getCatalogs(): ResponseEntity<List<ResponseCatalog>> {
        val catalogList = catalogService.getAllCatalogs()
        val mapper = ModelMapper()
        mapper.configuration.matchingStrategy = MatchingStrategies.STRICT
        val responseCatalogList = catalogList.map { mapper.map(it, ResponseCatalog::class.java) }
        return ResponseEntity.status(HttpStatus.CREATED).body(responseCatalogList)
    }
}