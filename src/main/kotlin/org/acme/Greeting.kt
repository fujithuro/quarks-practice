package org.acme

import io.quarkus.hibernate.orm.panache.PanacheEntity
import jakarta.persistence.Entity

@Entity
class Greeting: PanacheEntity() {
    var name: String = ""
}