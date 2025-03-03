package com.cowday.pennywise

import com.cowday.pennywise.data.ExpenseCategoryType
import com.cowday.pennywise.data.ExtractedDateAndTime
import com.cowday.pennywise.data.Transaction
import com.cowday.pennywise.data.TransactionType
import com.cowday.pennywise.data.extractDateAndTime
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class DateExtractUnitTest {
    @Test
    fun date_isExtractedCorrectly() {
        val transaction = Transaction(
            name = "expense",
            date = "2024-12-03T12:40:44.527+0000",
            amount = "23111".toBigDecimal(),
            title = "Grocery",
            categoryType = ExpenseCategoryType.GROCERIES,
            transactionType = TransactionType.EXPENSE
        )

        val expected = ExtractedDateAndTime(
            year = 2024,
            month = 12,
            day = 3,
            hour = 12,
            minute = 40,
            second = 44
        )

        val actual = transaction.date.extractDateAndTime()
        assertEquals(expected, actual)
    }
}