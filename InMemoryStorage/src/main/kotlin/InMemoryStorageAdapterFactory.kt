package storage.inmemory

import core.domain.storageAdapter.PlayerStorageAdapter
import core.domain.storageAdapter.SessionStorageAdapter
import core.factory.StorageAdapterFactory
import storage.inmemory.adapter.InMemoryPlayerStorageAdapter
import storage.inmemory.adapter.InMemorySessionStorageAdapter


class InMemoryStorageAdapterFactory: StorageAdapterFactory {
    private var playerStorageAdapter: PlayerStorageAdapter? = null;
    override fun playerStorageAdapterFactory(): PlayerStorageAdapter {
        if (playerStorageAdapter == null) {
            playerStorageAdapter = InMemoryPlayerStorageAdapter()
        }
        return playerStorageAdapter as PlayerStorageAdapter
    }

    override fun sessionStorageAdapterFactory(): SessionStorageAdapter {
        return InMemorySessionStorageAdapter(
            playerStorageAdapterFactory()
        )
    }
}