sealed class Token
data class Symbol(val value: String) : Token()
data class IterInit(val value: String) : Token()
data class IterEnd(val value: String) : Token()
data class Literal(val value: String) : Token()
data class Unknown(val value: String) : Token()