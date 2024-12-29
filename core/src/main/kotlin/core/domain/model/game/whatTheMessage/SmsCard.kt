package core.domain.model.game.whatTheMessage

data class SmsCard (
    val uuid: String,
    val type: SmsCardType,
    val text: String
)