//package com.service.wtm.service.impl
//
//import com.service.wtm.model.GameSessionModel
//import com.service.wtm.model.PlayerModel
//import com.service.wtm.service.ISessionService
//import com.service.wtm.storageMock.GameSessionStorage
//import org.springframework.stereotype.Service
//
//@Service
//class SessionService(
//    private val gameSessionStorage: GameSessionStorage
//): ISessionService {
//    override fun createSession(playerModel: PlayerModel): GameSessionModel {
//        gameSessionStorage.createSession(GameSessionModel())
//    }
//
//}