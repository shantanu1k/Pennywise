package com.cowday.pennywise.data

import java.math.BigDecimal

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
}

enum class TransactionType(val strValue: String) {
    INCOME("Income"), EXPENSE("Expense");
}

