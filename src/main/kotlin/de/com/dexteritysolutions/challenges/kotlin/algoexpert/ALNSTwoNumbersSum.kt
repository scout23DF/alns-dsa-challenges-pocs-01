package de.com.dexteritysolutions.challenges.kotlin.algoexpert

object ALNSTwoNumbersSum {
    @JvmStatic
    fun main(args: Array<String>) {
        val inputTestCasesList: MutableList<InputTestParamsDTO> = mutableListOf<InputTestParamsDTO>(
            InputTestParamsDTO(intArrayOf(3, 5, -4, 8, 11, 1, -1, 6), 10),
            InputTestParamsDTO(intArrayOf(8, -13, 25, -12, 9, 5, 1, 7), 12),
            InputTestParamsDTO(intArrayOf(-12, -5, 8, 6, -3, 10, -2, 4), -2)
        )

        for (inputTestCasesArray in inputTestCasesList) {
            println(
                "==> Given the Array of Numbers '" + inputTestCasesArray.array.contentToString() +
                        "', the 2 numbers sum for " + inputTestCasesArray.targetSum +
                        " are : " + twoNumberSum(
                    inputTestCasesArray.array!!,
                    inputTestCasesArray.targetSum
                ).contentToString()
            )
        }
    }

    fun twoNumberSum(array: IntArray, targetSum: Int): IntArray? {
        var resultArray: IntArray?
        val foundNumbersList: MutableList<Int?> = ArrayList<Int?>()
        val complimentsOfSumMap: MutableMap<Int?, Int?> = HashMap<Int?, Int?>()

        for (i in array.indices) {
            val compliment = targetSum - array[i]
            if (complimentsOfSumMap.containsKey(compliment)) {
                foundNumbersList.add(compliment)
                foundNumbersList.add(array[i])
                break
            } else {
                complimentsOfSumMap.put(array[i], i)
            }
        }

        resultArray = foundNumbersList.stream().mapToInt { obj: Int? -> obj!!.toInt() }.toArray()

        return resultArray
    }

    @JvmRecord
    private data class InputTestParamsDTO(val array: IntArray?, val targetSum: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as InputTestParamsDTO

            if (targetSum != other.targetSum) return false
            if (!array.contentEquals(other.array)) return false

            return true
        }

        override fun hashCode(): Int {
            var result = targetSum
            result = 31 * result + (array?.contentHashCode() ?: 0)
            return result
        }
    }
}