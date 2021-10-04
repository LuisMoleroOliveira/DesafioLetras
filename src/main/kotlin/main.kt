var count = 0

fun main() {

    val input = "oo ratoato roeuoeu aa roupaoupa dodo reiei dee romaoma"

    val listInput: MutableList<String> = input.split(" ") as MutableList<String>

    for (x in 0..listInput.lastIndex) {
        val word = listInput[x]
        val wordSize = listInput.size
        val isOdd = wordSize % 2

        if (isOdd == 1) { // impar
            val wordResult = firstStringOff(word)
            listInput[x] = wordResult
        } else { //par
            val wordResult = divideAndCompareString(word, null)
            listInput[x] = wordResult
        }
    }

    isAllWordsRepeated(listInput, input)
}

private fun isAllWordsRepeated(listInput: MutableList<String>, input: String) {
    if (listInput.size == count) {
        println(listInput.joinToString(" "))
    } else {
        input
    }
}

private fun firstStringOff(originalWord: String): String{
    val editedWord = originalWord.drop(1)
    return divideAndCompareString(editedWord, originalWord)
}

private fun divideAndCompareString(word: String, originalWord: String?): String {
    val result1 = word.substring(0, word.length/2)
    val result2 = word.substring(word.length/2, word.length)

    return if (result1 == result2) {
        count++
        fixCaseOne(result1, originalWord)
    } else {
        firstAndSecondStringOff(word)
    }
}

private fun fixCaseOne(result1: String, originalWord: String?): String {
    return if (originalWord == null) {
        result1
    } else {
        originalWord.removeSuffix(result1)
    }
}

private fun firstAndSecondStringOff(originalWord: String): String{
    val result = originalWord.drop(2)
    return divideAndCompareString(result, originalWord)
}