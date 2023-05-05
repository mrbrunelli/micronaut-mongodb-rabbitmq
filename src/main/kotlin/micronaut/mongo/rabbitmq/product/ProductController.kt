package micronaut.mongo.rabbitmq.product

import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Status
import io.micronaut.scheduling.TaskExecutors
import io.micronaut.scheduling.annotation.ExecuteOn
import javax.validation.Valid

@Controller("/products")
@ExecuteOn(TaskExecutors.IO)
open class ProductController(
    private val productRepository: ProductRepository
) {
    @Get
    fun list(): List<Product> = productRepository.list()

    @Post
    @Status(HttpStatus.CREATED)
    open fun save(@Valid product: Product) = productRepository.save(product)
}