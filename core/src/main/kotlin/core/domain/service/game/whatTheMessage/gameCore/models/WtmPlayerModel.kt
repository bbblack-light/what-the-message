package core.domain.service.game.whatTheMessage.gameCore.models

import core.domain.model.game.whatTheMessage.SmsCard

data class WtmPlayerModel(
    val playerId: String,
    private val cards: MutableCollection<SmsCard>,
) {
    var status: WtmPlayerStatus = WtmPlayerStatus.READY
    private var winningCount: Int = 0

    fun getCardFromHand(cardId: String): WtmRoundPlayerCardModel {
        val card = cards.find { it.id == cardId }
            ?: throw NullPointerException("Card not found with id=${cardId} in on playerId=$playerId")

        cards.remove(card)
        return WtmRoundPlayerCardModel(
            playerId = playerId,
            card = card
        )
    }

    fun addCard(card: SmsCard) {
        cards.add(card)
    }

    fun incrementWinningCount() {
        winningCount++
    }
}
