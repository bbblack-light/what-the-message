package core.domain.service.game.whatTheMessage.notification

import core.domain.service.game.whatTheMessage.gameCore.models.WtmSubscribeInfo

interface IWtmNotifier {
    fun notifyPlayers(data: WtmSubscribeInfo)
}