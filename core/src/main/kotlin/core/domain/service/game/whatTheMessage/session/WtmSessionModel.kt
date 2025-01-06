package core.domain.service.game.whatTheMessage.session

import core.domain.model.game.whatTheMessage.SmsCard
import core.domain.model.game.whatTheMessage.WtmPlayerModel

data class WtmSessionModel(
    val sessionId: String,
    val players: MutableList<WtmPlayerModel>,
    val cardsIn: MutableList<SmsCard>,
    val cardsOut: MutableList<SmsCard>
)