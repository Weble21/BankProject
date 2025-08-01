package org.example.types.entity

import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.persistence.*;
import org.example.types.entity.Account
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(name = "account")
data class User (
    @Id
    @Column(name = "ulid", length = 12, nullable = false)
    val ulid : String,

    @Column(name = "username", nullable = false, unique = true, length = 50)
    val username: String,

    @Column(name = "access_token", length = 255)
    val accessToken: String?= null,

    @Column(name = "created_at", nullable = false, updatable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @OneToMany(mappedBy = "user")
    val accounts: List<Account> = mutableListOf()

)