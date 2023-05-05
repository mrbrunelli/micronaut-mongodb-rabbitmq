package micronaut.mongo.rabbitmq.product

import io.micronaut.serde.annotation.Serdeable
import org.bson.codecs.pojo.annotations.BsonProperty
import javax.validation.constraints.NotBlank

@Serdeable
data class Product(
    @field:BsonProperty("name")
    @param:BsonProperty("name")
    @field:NotBlank
    val name: String,
    @field:BsonProperty("category")
    @param:BsonProperty("category")
    @field:NotBlank
    val category: String
)