package core.domain.service.game.whatTheMessage.gameCore.models

import core.domain.model.game.whatTheMessage.SmsCard

data class WtmRoundModel(
    val inCard: SmsCard
) {
    private val outCards: MutableList<WtmRoundPlayerCardModel> = mutableListOf()

    fun addCard(card: WtmRoundPlayerCardModel) {
        outCards.add(card)
    }

    fun voteCard(cardId: String) {
        outCards.find { it.card.id == cardId }?.addPoints()
    }

    fun getMaxVotedCountCardWithPlayer(): WtmRoundPlayerCardModel {
        return outCards.maxBy { it.points }
    }

    fun getCardsForVoting(): List<SmsCard> {
        return outCards.map { it.card }.toList()
    }
}