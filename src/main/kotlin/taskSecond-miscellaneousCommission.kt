const val MasterCard = "MasterCard"
const val Maestro = "Maestro"
const val MaxLimitMonthCard = 600_000
const val MaxLimitOneOperationCard = 150_000
const val percentMasterCardMaestro = 0.6
const val additionalCommissionMasterCardMaestro = 20

//-------------------------------------------
const val Visa = "Visa"
const val Mir = "Mir"
const val percentVisaMir = 0.75
const val minCommissionVisaMir = 35

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
    println(calculatorTransfer(Mir, 450_000, 150_000))
    println(calculatorTransfer(Visa, 75_000, 3_000))
    println(calculatorTransfer(Mir, 457_000, 150_000))
    println(calculatorTransfer(MasterCard, 300_000, 155_000))
}

fun calculatorTransfer(typeCardAccount: String = VKPay, amountPreviousTransfers: Int = 0, amountTransfer: Int): String {

    var userTransfer = when (typeCardAccount) {

        MasterCard, Maestro -> {
            if (amountTransfer <= MaxLimitOneOperationCard && (amountTransfer + amountPreviousTransfers) <= MaxLimitMonthCard) {
                if ((amountTransfer + amountPreviousTransfers) <= 75000) {
                    "Сумма перевода по катре $typeCardAccount: $amountTransfer"
                } else {
                    "Сумма перевода по катре $typeCardAccount с учетом комиссии $percentMasterCardMaestro % " +
                            "+ $additionalCommissionMasterCardMaestro руб. составляет: " +
                            "${(amountTransfer - ((amountTransfer * percentMasterCardMaestro) / 100 + additionalCommissionMasterCardMaestro))}"
                }
            } else {
                "Лимит по катре $typeCardAccount превышен"
            }
        }

        Visa, Mir -> {
            if (amountTransfer <= MaxLimitOneOperationCard && (amountTransfer + amountPreviousTransfers) <= MaxLimitMonthCard) {
                if (((amountTransfer * percentVisaMir) / 100) < minCommissionVisaMir) {

                    "Сумма перевода по катре $typeCardAccount с учетом комиссии $minCommissionVisaMir руб. " +
                            "составляет: ${amountTransfer - minCommissionVisaMir}"

                } else {
                    "Сумма перевода по катре $typeCardAccount с учетом комиссии $percentVisaMir % " +
                            "составляет: ${(amountTransfer - ((amountTransfer * percentVisaMir) / 100))}"
                }
            } else {
                "Лимит по катре $typeCardAccount превышен"
            }
        }

        //Vk pay
        else -> {
            if (amountTransfer <= MaxLimitOneOperationVkPay && (amountTransfer + amountPreviousTransfers) <= MaxLimitMonthVkPay) {
                "Сумма перевода по $typeCardAccount: $amountTransfer"
            } else {
                "Лимит по $typeCardAccount превышен"
            }
        }
    }
    return userTransfer
}