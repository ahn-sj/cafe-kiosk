package com.tally.kiosk.shop.entity

import com.tally.kiosk.common.base.BaseTimeEntity
import com.tally.kiosk.common.base.jpa.MoneyConverter
import com.tally.kiosk.common.domain.Money
import com.tally.kiosk.shop.constant.MenuCategoryType
import jakarta.persistence.*

@Entity
@Table(name = "menus")
class Menu protected constructor(
    name: String,
    menuCategory: MenuCategory,
) : BaseTimeEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id", nullable = false)
    val id: Long? = null

    @Column(name = "menu_name", nullable = false)
    var name: String = name
        protected set

    @Column(name = "price", nullable = false)
    @Convert(converter = MoneyConverter::class)
    var price: Money = Money.ZERO
        protected set

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_category_id", nullable = false)
    var category: MenuCategory = menuCategory
        protected set
}
