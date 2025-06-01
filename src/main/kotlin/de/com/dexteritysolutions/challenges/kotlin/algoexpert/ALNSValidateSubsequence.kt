package de.com.dexteritysolutions.challenges.kotlin.algoexpert

object ALNSValidateSubsequence {
    @JvmStatic
    fun main(args: Array<String>) {
        val inputTestCasesList = listOf<InputTestParamsDTO?>(
            (InputTestParamsDTO(mutableListOf<Int?>(5, 1, 22, 25, 6, -1, 8, 10), mutableListOf<Int?>(1, 6, -1, 10))),
            (InputTestParamsDTO(mutableListOf<Int?>(5, 1, 22, 25, 6, -1, 8, 10), mutableListOf<Int?>(6, 1, -1, 10))),
            (InputTestParamsDTO(mutableListOf<Int?>(22, 25, 6, -8, 25, -75, 15, 102, -148, 3, 7), mutableListOf<Int?>(-8, 6, -148)))
        )

        for (inputTestCasesArray in inputTestCasesList) {
            if (inputTestCasesArray != null) {
                println(
                    "==> Given the Main Array of Numbers '" + inputTestCasesArray.mainList +
                            "', and subsequence '" + inputTestCasesArray.subSequence +
                            " - Result = " + ALNSValidateSubsequence.isValidSubsequence(
                        inputTestCasesArray.mainList!!,
                        inputTestCasesArray.subSequence!!
                    )
                )
            }
        }
    }

    fun isValidSubsequence(array: MutableList<Int?>, sequence: MutableList<Int?>): Boolean {
        var bolResult = false
        var idxPointerInSubsequence = 0

        for (oneMainNumber in array) {
            if (idxPointerInSubsequence < sequence.size && sequence[idxPointerInSubsequence] == oneMainNumber) {
                idxPointerInSubsequence++
            }

            if (idxPointerInSubsequence == sequence.size) {
                bolResult = true
                break
            }
        }

        return bolResult
    }

    @JvmRecord
    private data class InputTestParamsDTO(
        val mainList: MutableList<Int?>?,
        val subSequence: MutableList<Int?>?
    )
}

