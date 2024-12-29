package storage.inmemory

import core.domain.storageAdapter.PlayerStorageAdapter
import core.domain.storageAdapter.SessionStorageAdapter
import core.domain.storageAdapter.game.whatTheMessage.SmsCardStorageAdapter
import core.factory.StorageAdapterFactory
import storage.inmemory.adapter.InMemoryPlayerStorageAdapter
import storage.inmemory.adapter.InMemorySessionStorageAdapter
import storage.inmemory.adapter.game.whatTheMessage.InMemorySmsCardStorageAdapter


class InMemoryStorageAdapterFactory: StorageAdapterFactory {
    private var playerStorageAdapter: PlayerStorageAdapter? = null;
    private var sessionStorageAdapter: SessionStorageAdapter? = null;
    private var smsCardStorageAdapter: SmsCardStorageAdapter? = null;

    override fun playerStorageAdapter(): PlayerStorageAdapter {
        if (playerStorageAdapter == null) {
            playerStorageAdapter = InMemoryPlayerStorageAdapter()
        }
        return playerStorageAdapter as PlayerStorageAdapter
    }

    override fun sessionStorageAdapter(): SessionStorageAdapter {
        if (sessionStorageAdapter == null) {
            sessionStorageAdapter = InMemorySessionStorageAdapter(
                playerStorageAdapter()
            )
        }
        return sessionStorageAdapter as InMemorySessionStorageAdapter
    }

    override fun wtmSmsCardStorageAdapter(): SmsCardStorageAdapter {
        if (smsCardStorageAdapter == null) {
            smsCardStorageAdapter = InMemorySmsCardStorageAdapter()
        }
        return smsCardStorageAdapter as SmsCardStorageAdapter
    }
}