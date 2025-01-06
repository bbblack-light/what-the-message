package core.domain.service.game.whatTheMessage

import core.domain.model.ModelGameType
import core.domain.model.game.StartGameRequestModel
import core.domain.model.game.whatTheMessage.GetStartsCardForGameRequestModel
import core.domain.service.game.IGameService

internal class WtmGameService(
    private val cardService: ICardService,
    private val wtmGameSessionManager: IWtmGameSessionManager
): IGameService {
    override fun startGame(request: StartGameRequestModel) {
        val cardsInfo = cardService.getStartsCardsForGame(
            GetStartsCardForGameRequestModel(
                players = request.players
            )
        )

        wtmGameSessionManager.addSession(
            players = cardsInfo.playersCards,
            cardsOut = cardsInfo.cardsOut,
            cardsIn = cardsInfo.cardsIn,
            sessionId = request.sessionId
        )
    }

    override fun game(): ModelGameType = ModelGameType.WTM
}