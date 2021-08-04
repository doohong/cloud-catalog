package com.cloud.catalog.entity

import com.cloud.catalog.dto.CatalogDto
import org.hibernate.annotations.ColumnDefault
import java.io.Serializable
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name="catalog")
class CatalogEntity : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    @Column(nullable = false, length = 120, unique = true)
    var productId: String = ""

    @Column(nullable = false)
    var productName: String = ""

    @Column(nullable = false)
    var stock: Int = 0

    @Column(nullable = false)
    var unitPrice: Int = 0

    @Column(nullable = false, updatable = false)
    @ColumnDefault(value = "CURRENT_TIMESTAMP")
    var createdAt: LocalDate = LocalDate.now()
}