package com.tally.kiosk.shop.entity

import com.tally.kiosk.common.base.BaseTimeEntity
import com.tally.kiosk.shop.entity.time.TimePeriod
import jakarta.persistence.*
import java.time.DayOfWeek
import java.time.LocalDateTime

@Entity
@Table(name = "shops")
class Shop protected constructor(
    name: String,
) : BaseTimeEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_id", nullable = false)
    val id: Long? = null

    @Column(name = "shop_name", nullable = false)
    var name: String = ""
        protected set

    @OneToMany(mappedBy = "shop", fetch = FetchType.LAZY)
    var menuCategories: MutableList<MenuCategory> = arrayListOf()
        protected set

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
        name = "operation_hours",
        joinColumns = [JoinColumn(name = "shop_id")]
    )
    @MapKeyColumn(name = "day_of_week")
    @MapKeyEnumerated(EnumType.STRING)
    val operatingHours: MutableMap<DayOfWeek, TimePeriod> = mutableMapOf()

    fun isOpen(): Boolean {
        return isOpen(LocalDateTime.now())
    }

    fun isOpen(time: LocalDateTime): Boolean {
        val hours = operatingHours[time.dayOfWeek] ?: return false
        return hours.contains(time.toLocalTime())
    }
}
