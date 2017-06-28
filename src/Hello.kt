fun main(args: Array<String>) {
    val template =
            """"<p> Hello {{name}}, your friends are: </p>
 <ul>
 {{#friends}}
    <li>{{first-name}} {{last-name}} </li>
 {{/friends}}
 </ul>"""
    val (match, token) = tokenize_chunk("{{bar}} foo")
    println(match)
    println(token)
}

fun tokenize_chunk(template: String) : Pair<String, String> {
    val matchResult = Regex("""\A\{\{\s*([\w-.]+)\s*}}""").find(template)
    val value = matchResult?.value ?: ""
    val token: String = matchResult?.groupValues?.get(1) ?: ""
    return Pair(value, token)
}