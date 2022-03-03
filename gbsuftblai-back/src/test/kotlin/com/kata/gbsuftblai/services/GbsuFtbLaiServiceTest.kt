package com.kata.gbsuftblai.services

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource


internal class GbsuFtbLaiServiceTest {

    private val gbsuFtbLaiService: GbsuFtbLaiService = GbsuFtbLaiService()

    @Nested
    @DisplayName("Number contains 3 or is divisible by 3")
    inner class ContainsThreeOrDivisibleByThreeTest {

        @ParameterizedTest(name = "{index} ==> Number [{0}] should be converted to [Gbsu] because it doesn't contains 3 and is divisible by 3")
        @ValueSource(ints = [ 6, 9, 12, 18 ])
        @DisplayName("Numbers without 3 and divisibles by 3 should be converted to [Gbsu]")
        fun should_result_be_equals_to_Gbsu_When_number_to_convert_doesnot_contain_3_and_is_divisible_by_3(inputNumber: Int) {
            // Given

            // When
            val result = gbsuFtbLaiService.convertNumber(inputNumber)

            // Then
            assertEquals("Gbsu", result)
        }

        @Test
        @DisplayName("Number [3] should be converted to [GbsuGbsu] because it contains exactly one 3 and is divisible by 3")
        fun should_result_be_equals_to_GbsuGbsu_When_number_to_convert_is_3() {
            // Given
            val inputNumber = 3

            // When
            val result = gbsuFtbLaiService.convertNumber(inputNumber)

            // Then
            assertEquals("GbsuGbsu", result)
        }

        @Test
        @DisplayName("Number [33] should be converted to [GbsuGbsuGbsu] because it contains exactly two 3 and is divisible by 3")
        fun should_result_be_equals_to_GbsuGbsuGbsu_When_number_to_convert_is_33() {
            // Given
            //   - 33 is divisible by 3 and contains exactly two 3
            val inputNumber = 33

            // When
            val result = gbsuFtbLaiService.convertNumber(inputNumber)

            // Then
            assertEquals("GbsuGbsuGbsu", result)
        }
    }
}
