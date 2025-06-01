package de.com.dexteritysolutions.challenges.kotlin.algoexpert

import java.util.*

object ALNSGroupAnagrams {
    @JvmStatic
    fun main(args: Array<String>) {
        val inputTestCasesList = listOf<InputTestParamsDTO?>(
            (InputTestParamsDTO(
                mutableListOf<String>("yo", "act", "flop", "tac", "foo", "cat", "oy", "olfp")
            ))
        )

        for (inputTestCasesArray in inputTestCasesList) {
            println(
                "==> Given the Main Array of Words '" + inputTestCasesArray?.words +
                "', the found Group of Anagrams are: " + ALNSGroupAnagrams.groupAnagrams(inputTestCasesArray?.words!!)
            )
        }
    }

    fun groupAnagrams(words: MutableList<String>): MutableList<MutableList<String>> {
        val resultList: MutableList<MutableList<String>> = ArrayList<MutableList<String>>()
        val anagramsMap: MutableMap<String, MutableList<String>> = LinkedHashMap<String, MutableList<String>>()

        for (oneOriginalWord in words) {
            val charArray = oneOriginalWord.toCharArray()
            Arrays.sort(charArray)
            val sortedWord = String(charArray)

            if (anagramsMap.containsKey(sortedWord)) {
                anagramsMap[sortedWord]!!.add(oneOriginalWord)
            } else {
                val newList: MutableList<String> = ArrayList<String>()
                newList.add(oneOriginalWord)
                anagramsMap.put(sortedWord, newList)
            }
        }

        if (!anagramsMap.isEmpty()) {
            resultList.addAll(anagramsMap.values)
        }

        return resultList
    }

    @JvmRecord
    private data class InputTestParamsDTO(
        val words: MutableList<String>
    )
}

