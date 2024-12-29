package core.factory

import core.domain.storageAdapter.PlayerStorageAdapter
import core.domain.storageAdapter.SessionStorageAdapter

interface StorageAdapterFactory {
    fun playerStorageAdapterFactory(): PlayerStorageAdapter
    fun sessionStorageAdapterFactory(): SessionStorageAdapter
}