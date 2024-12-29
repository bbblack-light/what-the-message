package core.domain.service.game.whatTheMessage

import core.domain.model.game.whatTheMessage.SmsCard
import core.domain.model.game.whatTheMessage.SmsCardType
import core.domain.storageAdapter.game.whatTheMessage.SmsCardStorageAdapter

internal class CardService(
    private val smsCardStorageAdapter: SmsCardStorageAdapter
): ICardService {
    override fun getAllInCards(): List<SmsCard> {
        return smsCardStorageAdapter.getAllCardsByType(SmsCardType.IN)
    }

    override fun getAllOutCards(): List<SmsCard> {
        return smsCardStorageAdapter.getAllCardsByType(SmsCardType.OUT)
    }
}