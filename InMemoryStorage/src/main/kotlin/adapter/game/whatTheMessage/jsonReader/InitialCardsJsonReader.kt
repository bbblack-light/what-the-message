package storage.inmemory.adapter.game.whatTheMessage.jsonReader

import com.fasterxml.jackson.databind.ObjectMapper


internal class InitialCardsJsonReader {
    private val objectMapper: ObjectMapper = ObjectMapper()
    fun getCardsFromJson(): List<JsonCard> {
        try {
            Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream(initialCardsJsonFileName)
                .use { `in` ->
                    val cards = objectMapper.readValue(`in`, JsonCards::class.java)
                    return cards.cards
                }
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

    companion object {
        val initialCardsJsonFileName = "initialCards.json"
    }
}