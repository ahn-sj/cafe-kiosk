package com.example.kiosk.machine

import jakarta.persistence.*

@Entity
@Table(name = "menus")
class Menu protected constructor(
    name: String,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id", nullable = false)
    val id: Long = 0L

    @Column(name = "menu_name", nullable = false)
    var name: String = name
        protected set


}