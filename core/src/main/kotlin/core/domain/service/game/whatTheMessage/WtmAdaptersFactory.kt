package core.domain.service.game.whatTheMessage

import core.domain.service.game.whatTheMessage.notification.IWtmNotifyChannel

interface WtmAdaptersFactory {
    fun WtmNotifyChannel(): IWtmNotifyChannel
}