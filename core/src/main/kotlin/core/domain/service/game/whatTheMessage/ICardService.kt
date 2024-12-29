package core.domain.service.game.whatTheMessage

import core.domain.model.game.whatTheMessage.SmsCard

interface ICardService {
    fun getAllInCards(): List<SmsCard>
    fun getAllOutCards(): List<SmsCard>
}