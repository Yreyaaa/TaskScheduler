package diplom.time.mvp.models
//Импорт необходтмых библиотек
import android.content.ContentUris
import android.provider.CalendarContract
import com.activeandroid.query.Delete
import com.activeandroid.query.Select
import diplom.time.TimeApplication
import java.util.*
class NoteDao {
    //Метод создания заметки, с парметром ID раздела
    fun createNote(pascade: Int): Note {
        var note = Note(pascade,"Новая заметка", Date(),0)
        note.save()
        return note
    }
    //Метод создания сохранения записи в БД
    fun saveNote(note: Note) = note.save()
    //Метод загркжки записей из БД
    fun loadAllNotes(pascade: Int) = Select()
            .from(Note::class.java)
            .where("pascade = ?", pascade)
            .execute<Note>()
    //Метод возвращает заметку по параметру ID
    fun getNoteById(noteId: Long) = Select()
            .from(Note::class.java)
            .where("id = ?", noteId)
            .executeSingle<Note>()
    //Метод удаления всех записей в разделе
    fun deleteAllNotesP(pasId : Int) {
        Delete().from(Note::class.java)
                .where("pascade = ?", pasId)
                .execute<Note>();
    }
    //Метод создания отдельной заметки
    fun deleteNote(note: Note) {
        TimeApplication.context.contentResolver
                .delete(ContentUris.withAppendedId(CalendarContract
                        .Events.CONTENT_URI, note.event),null,null)
        note.delete()
    }
}
