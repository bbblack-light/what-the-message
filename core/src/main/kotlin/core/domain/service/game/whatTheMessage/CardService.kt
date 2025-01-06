package core.domain.service.game.whatTheMessage

import core.domain.model.game.whatTheMessage.GetStartsCardForGameRequestModel
import core.domain.model.game.whatTheMessage.GetStartsCardForGameResponseModel
import core.domain.model.game.whatTheMessage.PlayerCards
import core.domain.model.game.whatTheMessage.SmsCard
import core.domain.model.game.whatTheMessage.SmsCardType
import core.domain.storageAdapter.game.whatTheMessage.SmsCardStorageAdapter

internal class CardService(
    private val smsCardStorageAdapter: SmsCardStorageAdapter
) : ICardService {
    override fun getAllInCards(): List<SmsCard> {
        return smsCardStorageAdapter.getAllCardsByType(SmsCardType.IN)
    }

    override fun getAllOutCards(): List<SmsCard> {
        return smsCardStorageAdapter.getAllCardsByType(SmsCardType.OUT)
    }

    override fun getStartsCardsForGame(request: GetStartsCardForGameRequestModel): GetStartsCardForGameResponseModel {
        val cardsOut = getAllOutCards().toMutableList()
        val cardsIn = getAllInCards()

        val playersCards = mutableListOf<PlayerCards>()
        for (player in request.players) {
            val cards = getRandomSixCardsAndRemoveItFromInputCards(cardsOut)
            playersCards.add(
                PlayerCards(
                    player = player,
                    cards = cards
                )
            )
        }

        return GetStartsCardForGameResponseModel(
            playersCards = playersCards,
            cardsOut = cardsOut,
            cardsIn = cardsIn
        )
    }

    private fun getRandomSixCardsAndRemoveItFromInputCards(cards: MutableList<SmsCard>): List<SmsCard> {
        val randomCards = mutableListOf<SmsCard>()
        for (i in 0..5) {
            val card = cards.random()
            cards.remove(card)
            randomCards.add(card)
        }
        return randomCards
    }
}