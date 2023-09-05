package com.example.fusionforme.data.repository

import Profil
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import com.mongodb.client.model.Filters
import org.bson.types.ObjectId

class ProfilRepository(private val database: MongoDatabase) {

    private val collection: MongoCollection<Profil> by lazy {
        database.getCollection("Profil", Profil::class.java)
    }

    suspend fun getProfil(id: String): Profil? {
        val objectId = try {
            ObjectId(id)
        } catch (ex: IllegalArgumentException) {
            return null
        }
        return collection.find(Filters.eq("_id", objectId)).first()
    }

    suspend fun getAllProfils(): List<Profil> {
        return collection.find().toList()
    }

    suspend fun insertProfil(profil: Profil) {
        collection.insertOne(profil)
    }

    suspend fun updateProfil(profil: Profil) {
        collection.replaceOne(Filters.eq("_id", profil.id), profil)
    }

    suspend fun deleteProfil(id: String) {
        val objectId = try {
            ObjectId(id)
        } catch (ex: IllegalArgumentException) {
            return
        }
        collection.deleteOne(Filters.eq("_id", objectId))
    }
}
