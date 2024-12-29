package com.tally.kiosk.shop.persistence

import com.tally.kiosk.shop.entity.Shop
import org.springframework.data.jpa.repository.JpaRepository

interface ShopJpaRepository : JpaRepository<Shop, Long> {
}