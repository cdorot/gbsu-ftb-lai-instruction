package com.kata.gbsuftblai.services

import org.springframework.stereotype.Component

private const val FTB = "Ftb"
private const val GBSU = "Gbsu"
private const val LAI = "Lai"

@Component
class GbsuFtbLaiService {

    fun convertNumber(inputNumber: Int): String {
        var conversion = ""

        if (isDivisibleBy(inputNumber, 3)) {
            conversion += GBSU
        }

        if (isDivisibleBy(inputNumber, 5)) {
            conversion += FTB
        }

        for (c in inputNumber.toString()) {
            when (c) {
                '3' -> conversion += GBSU
                '5' -> conversion += FTB
                '7' -> conversion += LAI
            }
        }

        return conversion.ifEmpty { inputNumber.toString() }
    }

    private fun isDivisibleBy(dividend: Int, divisor: Int) = dividend % divisor == 0

}
