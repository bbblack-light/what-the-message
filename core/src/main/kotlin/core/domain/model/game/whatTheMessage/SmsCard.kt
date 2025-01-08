package core.domain.model.game.whatTheMessage

data class SmsCard (
    val id: String,
    val type: SmsCardType,
    val text: String
)