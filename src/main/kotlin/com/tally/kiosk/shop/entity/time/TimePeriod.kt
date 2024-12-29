package com.tally.kiosk.shop.entity.time

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import java.time.LocalTime

@Embeddable
data class TimePeriod(
    @Column(name = "start_time", nullable = false)
    val startTime: LocalTime = LocalTime.MIN,

    @Column(name = "end_time", nullable = false)
    val endTime: LocalTime = LocalTime.MAX
) {
    fun contains(time: LocalTime): Boolean {
        return (time.isAfter(startTime) || time == startTime) &&
                (time.isBefore(endTime) || time == endTime)
    }
}
