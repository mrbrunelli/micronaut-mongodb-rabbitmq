package micronaut.mongo.rabbitmq.product

import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.client.annotation.Client
import javax.validation.Valid

@Client("/products")
interface ProductClient {
    @Post
    fun save(@Valid product: Product): HttpStatus

    @Get
    fun findAll(): List<Product>
}