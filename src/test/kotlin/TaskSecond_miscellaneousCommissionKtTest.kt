import org.junit.Test

import org.junit.Assert.*

class TaskSecond_miscellaneousCommissionKtTest {


    @Test
    fun calculatorTransfer_MasterCard_Success() {
        val typeCardAccount = MasterCard
        val amountPreviousTransfers = 450_000
        val amountTransfer = 150_000
        val result = calculatorTransfer(typeCardAccount, amountPreviousTransfers, amountTransfer)
        assertEquals(
            "Сумма перевода по катре MasterCard с учетом комиссии " +
                    "0.6 % + 20 руб. составляет: 149080.0", result
        )
    }

    @Test
    fun calculatorTransfer_MasterCard_NokLimit() {
        val typeCardAccount = MasterCard
        val amountPreviousTransfers = 300_000
        val amountTransfer = 155_000
        val result = calculatorTransfer(typeCardAccount, amountPreviousTransfers, amountTransfer)
        assertEquals("Лимит по катре MasterCard превышен", result)
    }

    @Test
    fun calculatorTransfer_Maestro_Success() {
        val typeCardAccount = Maestro
        val amountPreviousTransfers = 20_200
        val amountTransfer = 30_000
        val result = calculatorTransfer(typeCardAccount, amountPreviousTransfers, amountTransfer)
        assertEquals("Сумма перевода по катре Maestro: 30000", result)
    }

    @Test
    fun calculatorTransfer_Maestro_NokLimit() {
        val typeCardAccount = Maestro
        val amountPreviousTransfers = 500_000
        val amountTransfer = 140_000
        val result = calculatorTransfer(typeCardAccount, amountPreviousTransfers, amountTransfer)
        assertEquals("Лимит по катре Maestro превышен", result)
    }

    @Test
    fun calculatorTransfer_Mir_Success() {
        val typeCardAccount = Mir
        val amountPreviousTransfers = 450_000
        val amountTransfer = 150_000
        val result = calculatorTransfer(typeCardAccount, amountPreviousTransfers, amountTransfer)
        assertEquals("Сумма перевода по катре Mir с учетом комиссии 0.75 % составляет: 148875.0", result)
    }

    @Test
    fun calculatorTransfer_Mir_NokLimit() {
        val typeCardAccount = Mir
        val amountPreviousTransfers = 20_000
        val amountTransfer = 170_000
        val result = calculatorTransfer(typeCardAccount, amountPreviousTransfers, amountTransfer)
        assertEquals("Лимит по катре Mir превышен", result)
    }

    @Test
    fun calculatorTransfer_Visa_Success() {
        val typeCardAccount = Visa
        val amountPreviousTransfers = 75_000
        val amountTransfer = 3_000
        val result = calculatorTransfer(typeCardAccount, amountPreviousTransfers, amountTransfer)
        assertEquals("Сумма перевода по катре Visa с учетом комиссии 35 руб. составляет: 2965", result)
    }

    @Test
    fun calculatorTransfer_Visa_NokLimit() {
        val typeCardAccount = Visa
        val amountPreviousTransfers = 457_000
        val amountTransfer = 150_000
        val result = calculatorTransfer(typeCardAccount, amountPreviousTransfers, amountTransfer)
        assertEquals("Лимит по катре Visa превышен", result)
    }

    @Test
    fun calculatorTransfer_VKPay_1_Success() {
        val amountPreviousTransfers = 30_000
        val amountTransfer = 10_000
        val result =
            calculatorTransfer(amountPreviousTransfers = amountPreviousTransfers, amountTransfer = amountTransfer)
        assertEquals("Сумма перевода по VK Pay: 10000", result)
    }

    @Test
    fun calculatorTransfer_VKPay_1_NokLimit() {
        val amountPreviousTransfers = 30_000
        val amountTransfer = 11_000
        val result =
            calculatorTransfer(amountPreviousTransfers = amountPreviousTransfers, amountTransfer = amountTransfer)
        assertEquals("Лимит по VK Pay превышен", result)
    }

    @Test
    fun calculatorTransfer_VKPay_2_Success() {
        val typeCardAccount = VKPay
        val amountPreviousTransfers = 21_000
        val amountTransfer = 7_000
        val result = calculatorTransfer(typeCardAccount, amountPreviousTransfers, amountTransfer)
        assertEquals("Сумма перевода по VK Pay: 7000", result)
    }

    @Test
    fun calculatorTransfer_VKPay_2_NokLimit() {
        val typeCardAccount = VKPay
        val amountPreviousTransfers = 10_000
        val amountTransfer = 16_000
        val result = calculatorTransfer(typeCardAccount, amountPreviousTransfers, amountTransfer)
        assertEquals("Лимит по VK Pay превышен", result)
    }

}