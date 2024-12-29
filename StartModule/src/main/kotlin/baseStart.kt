package com.wtm

import core.factory.DomainServiceFactory
import storage.inmemory.InMemoryStorageAdapterFactory

fun baseStart() {
    val storageFactory = InMemoryStorageAdapterFactory()
    val domainServiceFactory = DomainServiceFactory(storageFactory)

//    val createPlayerModel = CreatePlayerModel("Lena")
//    domainServiceFactory.playerService().createPlayer(createPlayerModel)
//
//    println(domainServiceFactory.playerService().getPlayers())

    println(domainServiceFactory.wtmCardService().getAllInCards())
}