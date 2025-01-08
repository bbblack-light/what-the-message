package com.wtm

import core.domain.service.game.whatTheMessage.notification.IWtmNotifyChannel
import core.factory.GameAdaptersFactory

class BaseWtmNotifierChannel: IWtmNotifyChannel {
    override fun notify() {
        println("notify")
    }
}

class GameAdaptersFactoryImpl: GameAdaptersFactory {
    override fun WtmNotifyChannel(): IWtmNotifyChannel {
        return BaseWtmNotifierChannel()
    }

}