package br.com.amd.githubimagecatcher.data.remote.serializers

import br.com.amd.githubimagecatcher.data.remote.model.EmojiResponse
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.jsonObject

object EmojiListSerializer : KSerializer<List<EmojiResponse>> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("kotlinx.serialization.json.JsonLiteral", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): List<EmojiResponse> {
        val jsonInput = decoder as? JsonDecoder ?: error("Can be deserialized only by JSON")

        val json = jsonInput.decodeJsonElement().jsonObject
        val propertiesMap = json.toMutableMap()

        val emojis = mutableListOf<EmojiResponse>()
        propertiesMap.entries.forEach { entry ->
            emojis.add(EmojiResponse(name = entry.key, url = entry.value.toString()))
        }

        return emojis
    }

    override fun serialize(encoder: Encoder, value: List<EmojiResponse>) {
        error("Serialization is not supported")
    }
}