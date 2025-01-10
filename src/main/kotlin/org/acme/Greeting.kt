package org.acme

import io.quarkus.hibernate.orm.panache.kotlin.PanacheCompanion
import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntity
import jakarta.persistence.Entity

@Entity
class Greeting: PanacheEntity() {
    companion object: PanacheCompanion<Greeting>

    lateinit var name: String
}
