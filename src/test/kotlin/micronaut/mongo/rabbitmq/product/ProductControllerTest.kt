package micronaut.mongo.rabbitmq.product

import io.micronaut.http.HttpStatus
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test


@MicronautTest
class ProductControllerTest {
    @Test
    fun productsEndpointInteractsWithMongo(productClient: ProductClient) {
        var products = productClient.findAll()
        println(products)
        Assertions.assertTrue(products.isEmpty())

        var status = productClient.save(Product(name = "Cadeira de praia", category = "cadeiras"))
        Assertions.assertEquals(HttpStatus.CREATED, status)

        products = productClient.findAll()
        Assertions.assertFalse(products.isEmpty())
        Assertions.assertEquals("Cadeira de praia", products[0].name)
        Assertions.assertEquals("cadeiras", products[0].category)

        status = productClient.save(Product(name = "Garrafa térmica", category = "garrafas"))
        Assertions.assertEquals(HttpStatus.CREATED, status)

        products = productClient.findAll()
        Assertions.assertTrue(products.any { (_, category): Product -> "garrafas" == category })
    }
}