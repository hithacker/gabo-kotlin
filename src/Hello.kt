fun main(args: Array<String>) {
    val template = "{{/bar}} foo"
    val (match, token) = tokenize_chunk(template)
    println("Exact string: $match Token: $token")
}

fun tokenize_chunk(template: String) : Pair<String, Token> {
    Regex("""\A\{\{\s*([\w-.]+)\s*}}""").find(template)?.let { matchResult ->
        return Pair(matchResult.value, Symbol(matchResult.groupValues[1]))
    }

    Regex("""\A\{\{/\s*(\w+)\s*}}""").find(template)?.let { matchResult ->
        return Pair(matchResult.value, IterInit(matchResult.groupValues[1]))
    }

    return Pair("", Unknown(""))
}