package micronaut.mongo.rabbitmq.product

import com.mongodb.client.MongoClient
import com.mongodb.client.MongoCollection
import jakarta.inject.Singleton
import micronaut.mongo.rabbitmq.config.MongoDBConfig

@Singleton
class MongoDBProductRepository(
    private val mongoConf: MongoDBConfig,
    private val mongoClient: MongoClient
) : ProductRepository {
    private val collection: MongoCollection<Product>
        get() = mongoClient.getDatabase(mongoConf.name)
            .getCollection(mongoConf.collection, Product::class.java)

    override fun save(product: Product) {
        collection.insertOne(product)
    }

    override fun list(): List<Product> = collection.find().into(ArrayList())
}