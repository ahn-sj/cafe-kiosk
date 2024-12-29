package com.tally.kiosk.shop.entity

import com.tally.kiosk.common.base.BaseTimeEntity
import jakarta.persistence.*

@Entity
@Table(name = "menu_categories")
class MenuCategory protected constructor(
    name: String,
    description: String,
    shop: Shop,
) : BaseTimeEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_category_id", nullable = false)
    val id: Long? = null

    @Column(name = "menu_category_name", nullable = false)
    var name: String = name
        protected set

    @Column(name = "menu_category_description", nullable = false)
    var description: String = description
        protected set

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id", nullable = false)
    var shop: Shop = shop
        protected set

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    var menus: MutableList<Menu> = arrayListOf()
        protected set
}
