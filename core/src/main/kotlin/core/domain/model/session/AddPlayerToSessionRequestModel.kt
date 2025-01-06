package core.domain.model.session

data class AddPlayerToSessionRequestModel(
    val playerId: String,
    val sessionId: String
)