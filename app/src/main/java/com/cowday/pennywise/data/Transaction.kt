package com.cowday.pennywise.data

import java.math.BigDecimal
import java.text.SimpleDateFormat
import java.time.YearMonth
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale
import java.util.TimeZone

open class Transaction(
    open val name: String? = null,
    open val date: String,
    open val amount: BigDecimal,
    open val title: String,
    open val categoryType: CategoryType,
    open val message: String? = null,
    open val transactionType: TransactionType,
)

interface CategoryType {
    fun getStrValue(): String
    fun getIcon(): Int
}

enum class TransactionType(val strValue: String) {
    INCOME("Income"), EXPENSE("Expense");
}

private const val DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ"

fun Long.toUtcDate(): String {
    val date = Date(this)
    val sdf = SimpleDateFormat(DATE_TIME_FORMAT, Locale.US)
    sdf.timeZone = TimeZone.getTimeZone("UTC")
    return sdf.format(date)
}

data class ExtractedDateAndTime(
    val year: Int? = null,
    val month: Int? = null,
    val day: Int? = null,
    val hour: Int? = null,
    val minute: Int? = null,
    val second: Int? = null,
)

fun String.extractDateAndTime(): ExtractedDateAndTime {
    println(this)
    val formatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT)
    val zonedDateTime = ZonedDateTime.parse(this, formatter)

    return ExtractedDateAndTime(
        year = zonedDateTime.year,
        month = zonedDateTime.monthValue,
        day = zonedDateTime.dayOfMonth,
        hour = zonedDateTime.hour,
        minute = zonedDateTime.minute,
        second = zonedDateTime.second
    )
}

fun groupTransactionByDate(transactions: List<Transaction>): Map<String, List<Transaction>> {
    val formatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT)

    return transactions.groupBy {
        val date = ZonedDateTime.parse(it.date, formatter)

        YearMonth.from(date).format(DateTimeFormatter.ofPattern("MMMM yyyy"))
    }
}