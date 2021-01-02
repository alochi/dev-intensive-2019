package ru.skillbranch.devintensive.extensions

import java.text.SimpleDateFormat
import java.util.*

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.format(pattern: String = "HH:mm:ss dd:MM:yyyy"): String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.humanizeDiff(date: Date = Date()): String {
    val diff = date.time.minus(this.time)

    return if (diff / SECOND == 0L) "только что" else
        when (diff) {
            in 0..MINUTE -> when (diff / SECOND % 10) {
                1L -> "${if (diff / SECOND == 11L) "${diff / SECOND} секунд" else "${diff / SECOND} секунду"} назад"
                in 2..4 -> "${if (diff / SECOND in 10..19) "${diff / SECOND} секунд" else "${diff / SECOND} секунды"} назад"
                in 5..9, 0L -> "${diff / SECOND} секунд назад"
                else -> "несколько секунд назад"
            }
            in MINUTE..HOUR -> when (diff / MINUTE % 10) {
                1L -> "${if (diff / MINUTE == 11L) "${diff / MINUTE} минут" else "${diff / MINUTE} минуту"} назад"
                in 2..4 -> "${if (diff / MINUTE in 10..14) "${diff / MINUTE} минут" else "${diff / MINUTE} минуты"} назад"
                in 5..9, 0L -> "${diff / MINUTE} минут назад"
                else -> "несколько минут назад"
            }
            in HOUR..DAY -> when (diff / HOUR % 10) {
                1L -> "${if (diff / HOUR == 11L) "${diff / HOUR} часов" else "${diff / HOUR} час"} назад"
                in 2..4 -> "${if (diff / HOUR in 10..14) "${diff / HOUR} часов" else "${diff / HOUR} часа"} назад"
                in 5..9, 0L -> "${diff / HOUR} часов назад"
                else -> "несколько часов назад"
            }
            in DAY..DAY * 365 -> when (diff / DAY % 10) {
                1L -> "${if (diff / DAY == 11L || diff / DAY == 111L || diff / DAY == 211L || diff / DAY == 311L)  "${diff / DAY} дней" else "${diff / DAY} день"} назад"
                in 2..4 -> "${if (diff / DAY in 10..14 || diff / DAY in 110..114 || diff / DAY in 210..214 || diff / DAY in 310..314) "${diff / DAY} дней" else "${diff / DAY} дня"} назад"
                in 5..9, 0L -> "${diff / DAY} дней назад"
                else -> "несколько дней назад"
            }
            in DAY * 366..DAY * 365 * 2 -> "больше года назад"
            else -> "больше нескольких лет назад"
        }
}

fun Date.add(value: Int, units: TimeUnits = TimeUnits.SECOND): Date {
    var time = this.time

    time += when (units) {
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }

    this.time = time

    return this
}

enum class TimeUnits {
    SECOND,
    MINUTE,
    HOUR,
    DAY
}