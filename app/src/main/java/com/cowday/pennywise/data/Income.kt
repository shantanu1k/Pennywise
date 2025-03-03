package com.cowday.pennywise.data

import com.cowday.pennywise.R
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

enum class IncomeCategoryType(private val strValue: String): CategoryType {
    SALARY("Salary"),
    BONUS("Bonus"),
    GIFT("Gift");

    override fun getStrValue(): String {
        return this.strValue
    }

    override fun getIcon(): Int {
        return when (this) {
            SALARY -> R.drawable.ic_salary
            BONUS -> R.drawable.ic_bonus
            GIFT -> R.drawable.icon_gift
        }
    }
}
