package core.domain.service.game.whatTheMessage

import core.domain.model.game.whatTheMessage.GetStartsCardForGameResponseModel
import core.domain.model.game.whatTheMessage.GetStartsCardForGameRequestModel
import core.domain.model.game.whatTheMessage.SmsCard

interface ICardService {
    fun getAllInCards(): List<SmsCard>
    fun getAllOutCards(): List<SmsCard>
    fun getStartsCardsForGame(request: GetStartsCardForGameRequestModel): GetStartsCardForGameResponseModel
}