package storage.inmemory.adapter.game.whatTheMessage.jsonReader

import com.fasterxml.jackson.annotation.JsonProperty
import storage.inmemory.entity.game.whatTheMessage.EntitySmsCardType

internal class JsonCards {
    @JsonProperty("cards")
    lateinit var cards: List<JsonCard>
}

internal class JsonCard {
    @JsonProperty("type")
    lateinit var type: EntitySmsCardType

    @JsonProperty("text")
    lateinit var text: String
}