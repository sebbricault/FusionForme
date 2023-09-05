
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId


data class Profil(
    @BsonId
    val id: ObjectId = ObjectId.get(),
    val name: String,
    val age: String,
    val poid: String,
    val taille: String,
    val niveau: String
)