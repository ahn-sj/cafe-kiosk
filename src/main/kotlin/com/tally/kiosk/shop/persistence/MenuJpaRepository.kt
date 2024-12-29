package com.tally.kiosk.shop.persistence

import com.tally.kiosk.shop.entity.Menu
import org.springframework.data.jpa.repository.JpaRepository

interface MenuJpaRepository : JpaRepository<Menu, Long> {
}
