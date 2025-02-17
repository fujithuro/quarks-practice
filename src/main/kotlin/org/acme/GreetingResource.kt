package org.acme

import jakarta.transaction.Transactional
import jakarta.ws.rs.DefaultValue
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import org.jboss.resteasy.reactive.RestQuery

@Path("/hello")
class GreetingResource (
    private val service: GreetingService,
    private val repository: GreetingRepository,
) {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/greeting/{name}")
    fun greeting(name: String?): String {
        return service.greeting(name!!)
    }

    @GET
    @Transactional
    @Produces(MediaType.TEXT_PLAIN)
    fun hello(@RestQuery @DefaultValue("Guest") name: String): String {
        val greeting = Greeting().also { it.name = name }
        repository.persist(greeting)
        return "Hello ${greeting.name}!!"
    }

    @GET
    @Path("names")
    @Produces(MediaType.TEXT_PLAIN)
    fun names(): String {
        return repository.listAll()
                        .joinToString(",") { it.name }
                        .let { "I've said hello to $it" }
    }
}
