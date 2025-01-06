package com.wtm

import core.domain.model.ModelGameType
import core.domain.model.player.CreatePlayerRequestModel
import core.domain.model.session.AddPlayerToSessionRequestModel
import core.domain.model.session.CreateSessionRequestModel
import core.domain.model.session.StartSessionRequestModel
import core.factory.DomainServiceFactory
import storage.inmemory.InMemoryStorageAdapterFactory

fun baseStart() {
    val storageFactory = InMemoryStorageAdapterFactory()
    val domainServiceFactory = DomainServiceFactory(storageFactory)

    val createPlayerModel = CreatePlayerRequestModel("Lena")
    val createPlayerModel2 = CreatePlayerRequestModel("Max")
    val createPlayerModel3 = CreatePlayerRequestModel("Vika")

    val player1 = domainServiceFactory.playerService().createPlayer(createPlayerModel)
    val player2 = domainServiceFactory.playerService().createPlayer(createPlayerModel2)
    val player3 = domainServiceFactory.playerService().createPlayer(createPlayerModel3)

    val session = domainServiceFactory.sessionService().createSession(
        CreateSessionRequestModel(
            player1.id,
            ModelGameType.WTM
        )
    )

    domainServiceFactory.sessionService().addPlayerToSession(
        AddPlayerToSessionRequestModel(
            player2.id,
            session.id
        )
    )

    domainServiceFactory.sessionService().startGame(StartSessionRequestModel(sessionId = session.id))

    val sessionState = domainServiceFactory.wtmGameSessionManager().getSessionState(session.id)

    println(
        sessionState.players.get(0).cards.map {it.text + "\n\n" }
    )

    println()

    println(
        sessionState.players.get(1).cards.map {it.text + "\n\n" }
    )
}