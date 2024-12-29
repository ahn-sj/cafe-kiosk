package com.tally.kiosk.shop.entity

import com.tally.kiosk.common.base.jpa.MoneyConverter
import com.tally.kiosk.common.domain.Money
import jakarta.persistence.*

@Entity
@Table(name = "menu_option_items")
class MenuOptionItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_option_item_id", nullable = false)
    val id: Long? = null

    @Column(name = "option_name", nullable = false)
    var name: String = ""
        protected set

    @Column(name = "extra_price", nullable = false)
    @Convert(converter = MoneyConverter::class)
    var extraPrice: Money = Money.ZERO
        protected set

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_option_id", nullable = false)
    var menuOption: MenuOption = MenuOption()
        protected set
}