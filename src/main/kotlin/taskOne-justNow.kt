fun main() {
    println(agoToText(39600))
}

fun agoToText(time: Int) = when (time) {

    in 0..60 -> "был(а) только что"
    in 61..3600 -> "${strTimeMin(time / 60)}"
    in 3601..86400 -> "${strTimeHour(time / 3600)}"
    in 86401..172800 -> "был(а) вчера"
    in 172801..259200 -> "был(а) позавчера"
    else -> "был(а) давно"
}

fun strTimeMin(time: Int): String {

    if (time % 10 == 1 && time % 100 != 11) {
        return "был(а) в сети $time минуту назад"
    } else if (time % 10 == 2 || time % 10 == 3 || time % 10 == 4) {
        return "был(а) в сети $time минуты назад"
    } else {
        return "был(а) в сети $time минут назад"
    }
}

fun strTimeHour(time: Int): String {

    if (time % 10 == 1 && time % 100 != 11) {
        return "был(а) в сети $time час назад"
    } else if (time % 10 == 2 || time % 10 == 3 || time % 10 == 4) {
        return "был(а) в сети $time часа назад"
    } else {
        return "был(а) в сети $time часов назад"
    }
}
