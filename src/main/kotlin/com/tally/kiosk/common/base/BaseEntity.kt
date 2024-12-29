package com.tally.kiosk.common.base

import jakarta.persistence.Column
import jakarta.persistence.EntityListeners
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.jpa.domain.support.AuditingEntityListener

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseEntity protected constructor() : BaseTimeEntity() {
    @CreatedBy
    @Column(updatable = false)
    lateinit var createdBy: String
        protected set

    @LastModifiedBy
    var updatedBy: String? = null
        protected set
}