const val MINUTE = 60
const val HOUR = 3600
const val DAY = 86400
const val TWO_DAYS = 172800
const val THREE_DAYS = 259200

fun main() {
    val wasOnline = 3601
    println(agoToText(wasOnline))
}

fun agoToText(time: Int) = when {
    time > THREE_DAYS -> "был(а) в сети давно"
    time > TWO_DAYS -> "был(а) в сети вчера"
    time > DAY -> "был(а) в сети сегодня"
    time > HOUR -> "был(а) в сети ${time / HOUR} ${endingWord(time)} назад"
    time > MINUTE -> "был(а) в сети ${time / MINUTE} ${endingWord(time)} назад"
    else -> "был(а) только что"
}

fun endingWord(time: Int): String {
    return if (time > HOUR) {
        when (time / HOUR % 10) {
            1 -> "час"
            in 2..4 -> "часа"
            else -> "часов"
        }
    } else {
        when (time / MINUTE % 10) {
            1 -> "минуту"
            in 2..4 -> "минуты"
            else -> "минут"
        }
    }
}
