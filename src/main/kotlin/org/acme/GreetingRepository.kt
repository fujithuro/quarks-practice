package org.acme

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class GreetingRepository: PanacheRepository<Greeting> {
}