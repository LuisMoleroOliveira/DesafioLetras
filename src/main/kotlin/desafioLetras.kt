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
        if (countRepeatWords == listInput.size) { //if validação palavras repetidas
            for (x in 0..listInput.lastIndex) { // for para imprimir valores da lista formatado
                print("${listInput[x]} ")
            }
            print(".")
        } else {
            print("$input.") // se a contagem ficar fora é impressa o input
        }
    } else { // else para textos que contenham uma palavra
        val wordResult = compareWord(input)
        input = wordResult
        print("$input.")
    }
}

fun compareWord(word: String):String {
   var countWordIndex = 1
   var result =""
   for(x in word.length downTo 0 ){
       val result1 = word.substring(word.length-countWordIndex,word.length)
       val result2 = word.substring(word.length-(countWordIndex+result1.length),word.length-countWordIndex)
       if (result1 == result2) {
           result = word.substring(0, x - 1)
           countRepeatWords++ // contador de itens que contenha palavras repetidas
           break
       } else {
           countWordIndex++
       }

   }
 return result
}
fun wordsCheck(word:String):Boolean{ // checar tamanho da palavra
    if (word.length < 2){
        return false
    } else {
        return true
    }
}
fun listCheck(list: MutableList<String>): Boolean{ // checar tamanho da lista
    if(list.size < 2){
        return false
    } else {
        return true
    }
}
