package core.domain.service.game.whatTheMessage

import core.domain.model.ModelGameType
import core.domain.model.game.StartGameRequestModel
import core.domain.model.game.whatTheMessage.SmsCard
import core.domain.service.game.IGameService

internal class WtmGameService(
    private val cardService: ICardService,
    private val wtmGameSessionManager: IWtmGameSessionManager
): IGameService {
    override fun startGame(request: StartGameRequestModel) {
        val cardsIn: List<SmsCard> = cardService.getAllInCards()
        val cardsOut: List<SmsCard> = cardService.getAllOutCards()

        wtmGameSessionManager.addSession(
            players = request.players,
            cardsOut = cardsOut,
            cardsIn = cardsIn,
            sessionId = request.sessionId
        )
    }

    override fun game(): ModelGameType = ModelGameType.WTM
}