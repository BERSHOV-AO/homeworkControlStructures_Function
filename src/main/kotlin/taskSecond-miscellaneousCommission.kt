const val MasterCard = "MasterCard"
const val Maestro = "Maestro"
const val MaxLimitMonthCard = 600_000
const val MaxLimitOneOperationCard = 150_000

//-------------------------------------------
const val VKPay = "VK Pay"
const val MaxLimitMonthVkPay = 40_000
const val MaxLimitOneOperationVkPay = 15_000

fun main() {

    println(VKPay)
    println(calculatorTransfer(amountPreviousTransfers = 30_000, amountTransfer = 11_000))
    println(calculatorTransfer(amountPreviousTransfers = 10_000, amountTransfer = 16_000))
    println(calculatorTransfer(amountPreviousTransfers = 30_000, amountTransfer = 10_000))
    println()
    println("Card")
    println(calculatorTransfer(MasterCard, 450_000, 150_000))
    println(calculatorTransfer(Maestro, 20_200, 30_000))
    println(calculatorTransfer(Maestro, 450_000, 151_000))
}

fun calculatorTransfer(cardType: String = VKPay, amountPreviousTransfers: Int = 0, amountTransfer: Int): String {

    if (cardType == MasterCard || cardType == Maestro) {
        if (amountTransfer <= MaxLimitOneOperationCard && (amountTransfer + amountPreviousTransfers) <= MaxLimitMonthCard) {
            if ((amountTransfer + amountPreviousTransfers) <= 75000) {
                return "Сумма перевода по катре $cardType: $amountTransfer"

            } else {
                return "Сумма перевода по катре $cardType: ${(amountTransfer - ((amountTransfer * 0.6) / 100 + 20))}"
            }
        } else {
            return "Лимит по катре $cardType превышен"
        }
    } else {
        if (amountTransfer <= MaxLimitOneOperationVkPay && (amountTransfer + amountPreviousTransfers) <= MaxLimitMonthVkPay) {
            return "Сумма перевода по $cardType: $amountTransfer"
        } else {
            return "Лимит по $cardType превышен"
        }
    }
}