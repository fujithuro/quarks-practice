package org.acme

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
class Greeting {
    @Id
    @GeneratedValue
    var id: Long? = null
    lateinit var name: String
}
