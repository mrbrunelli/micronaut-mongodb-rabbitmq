package micronaut.mongo.rabbitmq.product

import javax.validation.Valid

interface ProductRepository {
    fun list(): List<Product>
    fun save(@Valid product: Product)
}