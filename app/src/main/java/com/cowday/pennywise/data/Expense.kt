package com.cowday.pennywise.data

import java.math.BigDecimal

data class Expense(
    override val name: String? = null,
    override val date: String,
    override val amount: BigDecimal,
    override val title: String,
    override val categoryType: ExpenseCategoryType,
    override val message: String? = null,
    override val transactionType: TransactionType = TransactionType.EXPENSE,
): Transaction(name, date, amount, title, categoryType, message, transactionType)

enum class ExpenseCategoryType(private val strValue: String): CategoryType {
    FOOD("Food"),
    TRANSPORT("Transport"),
    MEDICINE("Medicine"),
    GROCERIES("Groceries"),
    RENT("Rent"),
    GIFTS("Gifts"),
    ENTERTAINMENT("Entertainment");

    override fun getStrValue(): String {
        return this.strValue
    }
}