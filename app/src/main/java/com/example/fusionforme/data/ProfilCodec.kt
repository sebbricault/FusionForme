package com.example.fusionforme.data

// ProfilCodec.kt
import Profil
import org.bson.BsonReader
import org.bson.BsonWriter
import org.bson.codecs.Codec
import org.bson.codecs.DecoderContext
import org.bson.codecs.EncoderContext
import org.bson.codecs.configuration.CodecRegistry
import org.bson.types.ObjectId

class ProfilCodec(private val codecRegistry: CodecRegistry) : Codec<Profil> {
    override fun getEncoderClass(): Class<Profil> {
        return Profil::class.java
    }

    override fun encode(writer: BsonWriter, value: Profil, encoderContext: EncoderContext) {
        writer.writeStartDocument()
        writer.writeObjectId("_id", value.id ?: ObjectId())
        writer.writeString("name", value.name)
        writer.writeString("age", value.age)
        writer.writeString("poid", value.poid)
        writer.writeString("taille", value.taille)
        writer.writeString("niveau", value.niveau)
        writer.writeEndDocument()
    }

    override fun decode(reader: BsonReader, decoderContext: DecoderContext): Profil {
        reader.readStartDocument()
        val id = reader.readObjectId("_id")
        val name = reader.readString("name")
        val age = reader.readString("age")
        val poid = reader.readString("poid")
        val taille = reader.readString("taille")
        val niveau = reader.readString("niveau")
        reader.readEndDocument()

        return Profil(id, name, age, poid, taille, niveau )
    }

    fun getCodecRegistry(): CodecRegistry {
        return codecRegistry
    }
}
