package micronaut.mongo.rabbitmq.hello

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/hello")
class Hello {
    @Get(uri = "/", produces = ["text/plain"])
    fun index() = "Hello World"
}