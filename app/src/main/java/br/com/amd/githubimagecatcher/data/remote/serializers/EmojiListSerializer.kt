package br.com.amd.githubimagecatcher.data.remote.serializers

import br.com.amd.githubimagecatcher.data.remote.model.EmojiListResponse
import br.com.amd.githubimagecatcher.data.remote.model.EmojiResponse
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

object EmojiListSerializer : KSerializer<EmojiListResponse> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("kotlinx.serialization.json.JsonLiteral", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): EmojiListResponse {
        val jsonInput = decoder as? JsonDecoder ?: error("Can be deserialized only by JSON")

        val json = jsonInput.decodeJsonElement().jsonObject
        val propertiesMap = json.toMutableMap()

        val emojis = mutableListOf<EmojiResponse>()
        propertiesMap.entries.forEach { entry ->
            emojis.add(
                EmojiResponse(
                    name = entry.key,
                    url = entry.value.jsonPrimitive.content
                )
            )
        }

        return EmojiListResponse(emojis)
    }

    override fun serialize(encoder: Encoder, value: EmojiListResponse) {
        error("Serialization is not supported")
    }
}