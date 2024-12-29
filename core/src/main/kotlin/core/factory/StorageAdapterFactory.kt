package core.factory

import core.domain.storageAdapter.PlayerStorageAdapter
import core.domain.storageAdapter.SessionStorageAdapter
import core.domain.storageAdapter.game.whatTheMessage.SmsCardStorageAdapter

interface StorageAdapterFactory {
    fun playerStorageAdapter(): PlayerStorageAdapter
    fun sessionStorageAdapter(): SessionStorageAdapter
    fun wtmSmsCardStorageAdapter(): SmsCardStorageAdapter
}