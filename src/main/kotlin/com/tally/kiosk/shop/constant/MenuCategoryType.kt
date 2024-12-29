package com.tally.kiosk.shop.constant

/**
 * 메뉴 카테고리 타입
 *
 * @property categoryName 카테고리 이름
 */
enum class MenuCategoryType(
    private val categoryName: String,
) {
    COFFEE("커피"),
    FOOD("음식"),
    DRINK("음료"),
}
