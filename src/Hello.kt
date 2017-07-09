fun main(args: Array<String>) {
    val template = "{{/bar}} foo"
    val (match, token) = tokenize_chunk(template)
    println("Exact string: $match Token: $token")
}

fun tokenize_chunk(template: String) : Pair<String, Token> {
    Regex("""\A\{\{\s*([\w-.]+)\s*}}""").find(template)?.let { matchResult ->
        val value = matchResult.value
        val token: String = matchResult.groupValues[1]
        return Pair(value, Symbol(token))
    }

    Regex("""\A\{\{/\s*(\w+)\s*}}""").find(template)?.let { matchResult ->
        val value = matchResult.value
        val token: String = matchResult.groupValues[1]
        return Pair(value, IterInit(token))
    }

    return Pair("", Unknown(""))
}