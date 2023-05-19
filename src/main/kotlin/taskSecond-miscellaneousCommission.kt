const val VKPay = "VK Pay"
const val MasterCard = "MasterCard"
const val Maestro = "Maestro"
fun main() {

    println(calculatorTransfer(amountPreviousTransfers = 7500, amountTransfer = 500))
    println(calculatorTransfer(amountPreviousTransfers = 69000, amountTransfer = 10000))
    println(calculatorTransfer(MasterCard, 70000, 6000))
    println(calculatorTransfer(Maestro, 70000, 5000))
}

fun calculatorTransfer(cardType: String = VKPay, amountPreviousTransfers: Int = 0, amountTransfer: Int): Double {

    if (cardType == MasterCard || cardType == Maestro) {
        if ((amountTransfer + amountPreviousTransfers) <= 75000) {
            return amountTransfer.toDouble()
        } else {
            return amountTransfer - ((amountTransfer * 0.6) / 100 + 20)
        }
    } else {
        return amountTransfer.toDouble()
    }
}