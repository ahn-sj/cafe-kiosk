package com.tally.kiosk.common.domain

import java.math.BigDecimal

data class Money(
    val amount: BigDecimal,
) {
    operator fun plus(other: Money) = Money(amount + other.amount)
    operator fun minus(other: Money) = Money(amount - other.amount)

    companion object {
        val ZERO = Money(BigDecimal.ZERO)
    }
}