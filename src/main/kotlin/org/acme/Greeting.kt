package org.acme

import jakarta.persistence.Entity

@Entity
class Greeting {
    lateinit var name: String
}
