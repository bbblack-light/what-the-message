package core.domain.service.game.whatTheMessage.notification

import core.domain.service.game.whatTheMessage.gameCore.models.WtmSubscribeInfo

class WtmNotifier(
    private val notifyChannel: IWtmNotifyChannel
) : IWtmNotifier {
    override fun notifyPlayers(data: WtmSubscribeInfo) {
        //todo: make notifications
        notifyChannel.notify()
    }
}