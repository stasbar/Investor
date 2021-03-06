package com.stasbar.investor

import java.math.BigDecimal


/**
 * Created by stasbar on 13.07.2017
 */
class InvestorMath {
    companion object {
        //TODO Convert onto bigdecimal
        fun calc(P: Double, r: Double, n: Int, t: Int) = P * Math.pow(1 + r / n, (n * t).toDouble())

        fun compoundEffectHistogram(initialValue: Double, annualInterest: Double, capitalizationPerYear: Int, years: Int): Array<BigDecimal> {
            val numberOfCapitalization = years * capitalizationPerYear
            val values = Array<BigDecimal>(numberOfCapitalization, { i ->
                val interest = BigDecimal(1 + annualInterest / capitalizationPerYear).pow(i)
                (BigDecimal(initialValue).multiply(interest))

            })
            return values
        }

        fun compoundEffectHistogram(initialValue: Float, annualInterest: Float, capitalizationPerYear: Int, years: Int): FloatArray {
            val numberOfCapitalization = years * capitalizationPerYear
            val values = FloatArray(numberOfCapitalization)
            values[0] = initialValue
            for (i in 1..numberOfCapitalization - 1) {
                val profit = values[i - 1] * annualInterest / capitalizationPerYear
                values[i] = values[i - 1] + profit
            }
            return values
        }

        fun investmentGain(investmentAmount: Double, returnAmount: Double) = returnAmount - investmentAmount

        fun returnOfInvestment(investmentAmount: Double, returnAmount: Double): Double {
            return (investmentGain(investmentAmount, returnAmount)) / investmentAmount
        }

        fun annualizedReturnOfInvestment(investmentAmount: Double, returnAmount: Double, timeOfInvestment: Int)
                = returnOfInvestment(investmentAmount, returnAmount) / timeOfInvestment

    }


}