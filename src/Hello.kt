fun main(args: Array<String>) {
    var template =
            """"<p> Hello {{name}}, your friends are: </p>
 <ul>
 {{#friends}}
    <li>{{first-name}} {{last-name}} </li>
 {{/friends}}
 </ul>"""
    println(Pair(template, 5).second)
}