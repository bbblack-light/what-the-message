package core.domain.model.game.whatTheMessage

import core.domain.model.player.PlayerModel

data class GetStartsCardForGameResponseModel (
    val playersCards: List<PlayerCards>,
    val cardsOut: List<SmsCard>,
    val cardsIn: List<SmsCard>
)

data class PlayerCards(
    val player: PlayerModel,
    val cards: List<SmsCard>
)