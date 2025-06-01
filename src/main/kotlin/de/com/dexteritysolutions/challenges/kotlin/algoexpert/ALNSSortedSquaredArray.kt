package de.com.dexteritysolutions.challenges.kotlin.algoexpert

import java.util.*
import java.util.List
import kotlin.math.abs

object ALNSSortedSquaredArray {
    @JvmStatic
    fun main(args: Array<String>) {
        val inputTestCasesList = listOf<InputTestParamsDTO?>(
            (InputTestParamsDTO(intArrayOf(1, 2, 3, 5, 6, 8, 9))),
            (InputTestParamsDTO(intArrayOf(1))),
            (InputTestParamsDTO(intArrayOf(1, 2))),
            (InputTestParamsDTO(intArrayOf(1, 2, 3, 4, 5))),
            (InputTestParamsDTO(intArrayOf(0))),
            (InputTestParamsDTO(intArrayOf(10))),
            (InputTestParamsDTO(intArrayOf(-1))),
            (InputTestParamsDTO(intArrayOf(-2, -1))),
            (InputTestParamsDTO(intArrayOf(-5, -4, -3, -2, -1))),
            (InputTestParamsDTO(intArrayOf(-10))),
            (InputTestParamsDTO(intArrayOf(-10, -5, 0, 5, 10))),
            (InputTestParamsDTO(intArrayOf(-7, -3, 1, 9, 22, 30))),
            (InputTestParamsDTO(intArrayOf(-50, -13, -2, -1, 0, 0, 1, 1, 2, 3, 19, 20))),
            (InputTestParamsDTO(intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0))),
            (InputTestParamsDTO(intArrayOf(-1, -1, 2, 3, 3, 3, 4))),
            (InputTestParamsDTO(intArrayOf(-3, -2, -1)))
        )

        for (inputTestCasesArray in inputTestCasesList) {
            println(
                "==> Given the Main Array of Numbers '" + inputTestCasesArray.array.contentToString() +
                        "', the sorted Squared Array i: " + ALNSSortedSquaredArray.sortedSquaredArray(
                    inputTestCasesArray.array!!
                ).contentToString()
            )
        }
    }

    fun sortedSquaredArray(array: IntArray): IntArray {
        val resultArray = IntArray(array.size)
        var idxStart = 0
        var idxEnd = array.size - 1
        var idxResult = resultArray.size - 1

        while (idxStart <= idxEnd) {
            if (abs(array[idxStart]) > abs(array[idxEnd])) {
                resultArray[idxResult] = array[idxStart] * array[idxStart]
                idxStart++
            } else {
                resultArray[idxResult] = array[idxEnd] * array[idxEnd]
                idxEnd--
            }
            idxResult--
        }

        return resultArray
    }

    fun sortedSquaredArrayFirstAttempt(array: IntArray): IntArray? {
        var resultArray: IntArray? = IntArray(array.size)
        val sortedSquaredList: MutableList<Int?> = LinkedList<Int?>()

        for (oneNumber in array) {
            sortedSquaredList.add(oneNumber * oneNumber)
        }

        resultArray = sortedSquaredList.stream().sorted().mapToInt { obj: Int? -> obj!!.toInt() }.toArray()

        return resultArray
    }

    @JvmRecord
    private data class InputTestParamsDTO(
        val array: IntArray?
    )
}

