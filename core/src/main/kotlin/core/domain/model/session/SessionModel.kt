package core.domain.model.session

import core.domain.model.ModelGameType

data class SessionModel (
    val id: String,
    val ownerId: String,
    val game: ModelGameType,
    val playersId: List<String>
)