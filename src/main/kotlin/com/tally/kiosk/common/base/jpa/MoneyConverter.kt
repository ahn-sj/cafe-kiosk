package com.tally.kiosk.common.base.jpa

import com.tally.kiosk.common.domain.Money
import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter
import java.math.BigDecimal

@Converter(autoApply = true)
class MoneyConverter : AttributeConverter<Money, BigDecimal> {
    override fun convertToDatabaseColumn(attribute: Money): BigDecimal {
        return attribute.amount
    }

    override fun convertToEntityAttribute(amount: BigDecimal): Money {
        return Money(amount)
    }
}