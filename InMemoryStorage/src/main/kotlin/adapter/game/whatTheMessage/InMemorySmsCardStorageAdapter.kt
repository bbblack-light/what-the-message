package storage.inmemory.adapter.game.whatTheMessage

import core.domain.model.game.whatTheMessage.SmsCard
import core.domain.model.game.whatTheMessage.SmsCardType
import core.domain.storageAdapter.game.whatTheMessage.SmsCardStorageAdapter
import storage.inmemory.adapter.game.whatTheMessage.jsonReader.InitialCardsJsonReader
import storage.inmemory.entity.game.whatTheMessage.SmsCardEntity
import storage.inmemory.mapper.toEntity
import storage.inmemory.mapper.toModel
import java.util.UUID

internal class InMemorySmsCardStorageAdapter() : SmsCardStorageAdapter {
    private val smsCardEntities: MutableCollection<SmsCardEntity> = mutableListOf()
    private val initialCardsJsonReader: InitialCardsJsonReader = InitialCardsJsonReader()

    override fun getAllCardsByType(type: SmsCardType): List<SmsCard> {
        val entityType = type.toEntity()
        return smsCardEntities.filter { it.type == entityType }
            .map { it.toModel() }
    }

    init {
        smsCardEntities.addAll(initialCards())
    }

    private fun initialCards(): List<SmsCardEntity> {
        return initialCardsJsonReader.getCardsFromJson().map {
            SmsCardEntity(
                uuid = UUID.randomUUID(),
                type = it.type,
                text = it.text
            )
        }
    }
}