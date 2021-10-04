var countRepeatWords = 0
fun main() {
    print("Entre com o texto: ")
    var input = readLine()

    val listInput: MutableList<String> = input?.split(" ") as MutableList<String>
    if (listCheck(listInput)) { // if para textos que contenham mais de uma palavra
        for (x in 0..listInput.lastIndex) {
            val word = listInput[x] // val para facilitar leitura do código
            if (wordsCheck(word)) { // checar numero de caracteres das palavras
                val wordResult = compareWord(word)
                listInput[x] = wordResult
            } else {
                break
            }
        }
        listInput[listInput.lastIndex] = "${listInput[listInput.lastIndex]}."// substitui ultima palavra da lista
                                                                             // e coloca junto o ponto ao final da frase
        checkRepeatedWord(listInput, input)
    } else { // else para textos que contenham uma palavra
        containsAWord(input)
    }
}

private fun checkRepeatedWord(listInput: MutableList<String>, input: String) { //função para verificar se todas palavras da frase são repetidas
    if (countRepeatWords == listInput.size) { //if validação palavras repetidas
        for (x in 0..listInput.lastIndex) { // for para imprimir valores da lista
            print("${listInput[x]} ")
        }
    } else {
        print("$input.") // se a contagem ficar fora é impressa o input
    }
}

private fun containsAWord(input: String) {
    val wordResult = compareWord(input)
    print("$wordResult.")
}

fun compareWord(word: String):String {
    var countWordIndex = 1
    var result: String? = null

    for(x in word.length downTo 0 ) {
        val result1 = word.substring(word.length - countWordIndex, word.length)
        val result2 = word.substring(word.length - (countWordIndex + result1.length), word.length - countWordIndex)
        if (result1 == result2) {
            result = word.substring(0, x - 1)
            countRepeatWords++ // contador de itens que contenha palavras repetidas
            break
        } else if(word.length - (countWordIndex + result1.length) == 0) {
            result = word
        } else {
            countWordIndex++
        }
    }
    return result ?: word
}
fun wordsCheck(word:String): Boolean{ // checar tamanho da palavra
    return word.length >= 2
}
fun listCheck(list: MutableList<String>): Boolean{ // checar tamanho da lista
    return list.size >= 2
}