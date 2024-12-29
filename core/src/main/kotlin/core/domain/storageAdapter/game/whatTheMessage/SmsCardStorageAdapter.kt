package core.domain.storageAdapter.game.whatTheMessage

import core.domain.model.game.whatTheMessage.SmsCard
import core.domain.model.game.whatTheMessage.SmsCardType

interface SmsCardStorageAdapter {
    fun getAllCardsByType(type: SmsCardType): List<SmsCard>
}