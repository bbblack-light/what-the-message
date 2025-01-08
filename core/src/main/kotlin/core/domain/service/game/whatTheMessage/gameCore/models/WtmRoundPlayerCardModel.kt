package core.domain.service.game.whatTheMessage.gameCore.models

import core.domain.model.game.whatTheMessage.SmsCard

data class WtmRoundPlayerCardModel(
    val playerId: String,
    val card: SmsCard
) {

    var points: Int = 0
        get() {
            return field.toInt()
        }

    fun addPoints() {
        points.inc()
    }
}