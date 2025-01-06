package core.domain.model.session

data class SessionModel (
    val id: String,
    val ownerId: String,
    val playersId: List<String>
)