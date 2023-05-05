package micronaut.mongo.rabbitmq.config

import io.micronaut.context.annotation.ConfigurationProperties
import io.micronaut.core.naming.Named

@ConfigurationProperties("db")
interface MongoDBConfig : Named {
    val collection: String
}