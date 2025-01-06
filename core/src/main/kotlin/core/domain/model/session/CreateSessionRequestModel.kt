package core.domain.model.session

import core.domain.model.ModelGameType

data class CreateSessionRequestModel (
    val ownerUuid: String,
    val gameType: ModelGameType
)