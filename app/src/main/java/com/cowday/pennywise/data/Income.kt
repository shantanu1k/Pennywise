package com.cowday.pennywise.data

import java.math.BigDecimal

data class Income(
    override val name: String? = null,
    override val date: String,
    override val amount: BigDecimal,
    override val title: String,
    override val categoryType: IncomeCategoryType,
    override val message: String? = null,
    override val transactionType: TransactionType = TransactionType.INCOME,
): Transaction(name, date, amount, title, categoryType, message, transactionType)

enum class IncomeCategoryType(val strValue: String): CategoryType {
    SALARY("Salary"),
    BONUS("Bonus"),
    FREELANCE("Freelance"),
    GIFT("Gift")
}
