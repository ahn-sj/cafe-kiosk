package com.tally.kiosk.shop.entity

import com.tally.kiosk.common.base.BaseTimeEntity
import jakarta.persistence.*

@Entity
@Table(name = "menu_options")
class MenuOption : BaseTimeEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_option_id", nullable = false)
    val id: Long? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id", nullable = false)
    var menu: Menu? = null
        protected set

    @OneToMany(mappedBy = "menuOption", fetch = FetchType.LAZY)
    var optionDetails: MutableList<MenuOptionItem> = arrayListOf()
        protected set
}
