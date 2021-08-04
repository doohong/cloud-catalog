package com.cloud.catalog.dto

import java.io.Serializable
import java.time.LocalDate
import java.util.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

class CatalogDto : Serializable{
    var productId: String = ""
    var qty: Int = 0
    var unitPrice: Int = 0
    var totalPrice: Int = 0

    var orderID: String = ""
    var userId: String = ""
}
