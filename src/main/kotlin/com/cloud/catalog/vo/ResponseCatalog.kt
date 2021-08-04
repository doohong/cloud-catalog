package com.cloud.catalog.vo

import com.fasterxml.jackson.annotation.JsonInclude
import java.time.LocalDate
import javax.validation.constraints.Email
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@JsonInclude(JsonInclude.Include.NON_NULL)
data class ResponseCatalog(
    var productId: String = "",
    var productName: String = "",
    var unitPrice: Int = 0,
    var stock: Int = 0,
    var createdAt: LocalDate = LocalDate.now()
)