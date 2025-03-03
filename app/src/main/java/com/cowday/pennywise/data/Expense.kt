package com.cowday.pennywise.data

import com.cowday.pennywise.R
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

    override fun getIcon(): Int {
        return when (this) {
            FOOD -> R.drawable.icon_food
            TRANSPORT -> R.drawable.icon_transport
            MEDICINE -> R.drawable.icon_medicine
            GROCERIES -> R.drawable.icon_groceries
            RENT -> R.drawable.icon_rent
            GIFTS -> R.drawable.icon_gift
            ENTERTAINMENT -> R.drawable.ic_entertainment
        }
    }
}