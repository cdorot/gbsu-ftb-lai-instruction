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

        @ParameterizedTest(name = "{index} ==> Number [{0}] should be converted to [Gbsu] because it doesn't contains 3 or 5 and is divisible by 3")
        @ValueSource(ints = [6, 9, 12, 18])
        @DisplayName("Numbers without 3 and divisibles by 3 should be converted to [Gbsu]")
        fun should_result_be_equals_to_Gbsu_When_number_to_convert_doesnot_contain_3_and_is_divisible_by_3(inputNumber: Int) {
            // Given
            //   - a number divisible by 3 + not divisible by 5 + does not contain 3 neither 5 neither 7

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

    @Nested
    @DisplayName("Number contains 5 or is divisible by 5")
    inner class ContainsFiveOrDivisibleByFiveTest {

        @ParameterizedTest(name = "{index} ==> Number [{0}] should be converted to [Ftb] because it doesn't contains 3 or 5 and is divisible by 5")
        @ValueSource(ints = [10, 20, 40, 80])
        @DisplayName("Numbers without 5 and divisibles by 5 should be converted to [Ftb]")
        fun should_result_be_equals_to_Gbsu_When_number_to_convert_doesnot_contain_5_and_is_divisible_by_5(inputNumber: Int) {
            // Given
            //   - a number divisible by 5 + not divisible by 3 + does not contain 3 neither 5 neither 7

            // When
            val result = gbsuFtbLaiService.convertNumber(inputNumber)

            // Then
            assertEquals("Ftb", result)
        }

        @Test
        @DisplayName("Number [5] should be converted to [FtbFtb] because it contains exactly one 5 and is divisible by 5")
        fun should_result_be_equals_to_FtbFtb_When_number_to_convert_is_5() {
            // Given
            val inputNumber = 5

            // When
            val result = gbsuFtbLaiService.convertNumber(inputNumber)

            // Then
            assertEquals("FtbFtb", result)
        }

        @Test
        @DisplayName("Number [55] should be converted to [FtbFtbFtb] because it contains exactly two 5 and is divisible by 5")
        fun should_result_be_equals_to_FtbFtbFtb_When_number_to_convert_is_55() {
            // Given
            //   - 55 is divisible by 5 and contains exactly two 5
            val inputNumber = 55

            // When
            val result = gbsuFtbLaiService.convertNumber(inputNumber)

            // Then
            assertEquals("FtbFtbFtb", result)
        }
    }

    @Nested
    @DisplayName("Number contains 7")
    inner class ContainsSevenTest {

        @Test
        @DisplayName("Number [7] should be converted to [Lai] because it contains exactly one 7")
        fun should_result_be_equals_to_Lai_When_number_to_convert_is_7() {
            // Given
            val inputNumber = 7

            // When
            val result = gbsuFtbLaiService.convertNumber(inputNumber)

            // Then
            assertEquals("Lai", result)
        }

        @Test
        @DisplayName("Number [77] should be converted to [LaiLai] because it contains exactly two 7")
        fun should_result_be_equals_to_LaiLai_When_number_to_convert_is_77() {
            // Given
            //   - 77 contains exactly two 7
            val inputNumber = 77

            // When
            val result = gbsuFtbLaiService.convertNumber(inputNumber)

            // Then
            assertEquals("LaiLai", result)
        }
    }

    @Nested
    @DisplayName("Number divisible by 3 and contains 5")
    inner class DivisibleByThreeAndContainsFiveTest {

        @Test
        @DisplayName("Number [51] should be converted to [GbsuFtb] because it starts with 5 and is divisible by 3")
        fun should_result_be_equals_to_GbsuFtb_When_number_to_convert_is_51() {
            // Given
            //   - 51 is divisible by 3 but not by 5 and contains 5
            val inputNumber = 51

            // When
            val result = gbsuFtbLaiService.convertNumber(inputNumber)

            // Then
            assertEquals("GbsuFtb", result)
        }
    }

    @Nested
    @DisplayName("Number contains 3 and contains 5")
    inner class ContainsThreeAndContainsFiveTest {

        @Test
        @DisplayName("Number [53] should be converted to [FtbGbsu] because it starts with 5 and it ends with 3")
        fun should_result_be_equals_to_FtbGbsu_When_number_to_convert_is_53() {
            // Given
            //   - 53 contains 3 and contains 5
            val inputNumber = 53

            // When
            val result = gbsuFtbLaiService.convertNumber(inputNumber)

            // Then
            assertEquals("FtbGbsu", result)
        }
    }

    @Nested
    @DisplayName("Number divisible by 3 and contains 7")
    inner class DivisibleByThreeAndContainsSevenTest {

        @Test
        @DisplayName("Number [27] should be converted to [GbsuLai] because it contains exactly one 7 and is divisible by 3")
        fun should_result_be_equals_to_GbsuLai_When_number_to_convert_is_27() {
            // Given
            //   - 27 contains 7 and divisible by 3
            val inputNumber = 27

            // When
            val result = gbsuFtbLaiService.convertNumber(inputNumber)

            // Then
            assertEquals("GbsuLai", result)
        }

        @Test
        @DisplayName("Number [72] should be converted to [GbsuLai] because it contains exactly one 7 and is divisible by 3")
        fun should_result_be_equals_to_GbsuLai_When_number_to_convert_is_72() {
            // Given
            //   - 27 contains 7 and divisible by 3
            val inputNumber = 72

            // When
            val result = gbsuFtbLaiService.convertNumber(inputNumber)

            // Then
            assertEquals("GbsuLai", result)
        }
    }
}
