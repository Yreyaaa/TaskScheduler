package diplom.time.mvp.models
import com.activeandroid.query.Delete
import com.activeandroid.query.Select
class PasDao {
    fun createPas(): Pas {
        var pas = Pas("Новый раздел")
        pas.save()
        return pas
    }
    fun savePas(pas: Pas) = pas.save()
    fun loadAllPas() = Select().from(Pas::class.java).execute<Pas>()
    fun getPasById(pasId: Long) = Select()
            .from(Pas::class.java).where("id = ?", pasId)
            .executeSingle<Pas>()
    fun deleteAllPas() {
        Delete().from(Note::class.java).execute<Note>();
        Delete().from(Pas::class.java).execute<Pas>();
    }
    fun deletePas(pas: Pas,PasID : Int) {
        Delete().from(Note::class.java).where("pascade = ?", PasID).execute<Note>();
        pas.delete()
    }
}
