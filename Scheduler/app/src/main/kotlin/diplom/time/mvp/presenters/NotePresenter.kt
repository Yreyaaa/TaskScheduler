package diplom.time.mvp.presenters
//Импорт библиотек и нжектирование View элемента
import android.Manifest
import android.app.Activity
import android.content.ContentUris
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.provider.CalendarContract
import android.provider.CalendarContract.Events
import android.support.v4.content.ContextCompat
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import diplom.time.TimeApplication
import diplom.time.TimeApplication.Companion.context
import diplom.time.bus.NoteDeleteAction
import diplom.time.bus.NoteEditAction
import diplom.time.mvp.models.Note
import diplom.time.mvp.models.NoteDao
import diplom.time.mvp.views.NoteView
import org.greenrobot.eventbus.EventBus
import java.util.*
import javax.inject.Inject
@InjectViewState
class NotePresenter : MvpPresenter<NoteView>() {
    @Inject
    lateinit var mNoteDao: NoteDao
    lateinit var mNote: Note
    var mNotePosition: Int = -1
    init {
        TimeApplication.graph.inject(this)
    }
    //Метод отображения записи
    fun showNote(noteId: Long, notePosition: Int) {
        mNotePosition = notePosition
        mNote = mNoteDao.getNoteById(noteId)
        viewState.showNote(mNote)
    }
    //Функция проверки наличия слбытия у записи
    fun event() : Boolean= mNote.event != 0.toLong()
    //Функция создания нового события
    fun AddEvent(activity: Activity, title: String, text: String) {
        //Проверка наличи разрешения на редактирование календаря
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_CALENDAR)
                == PackageManager.PERMISSION_GRANTED) {
            if (mNote.event == 0.toLong()) {
                //Объявления события, заполнений параметров
                var startMillis: Long = 0
                var endMillis: Long = 0
                var beginTime = Calendar.getInstance()
                beginTime.set(2012, 9, 14, 7, 30);
                startMillis = beginTime.timeInMillis
                var endTime = Calendar.getInstance();
                endTime.set(2012, 9, 14, 8, 45)
                endMillis = endTime.timeInMillis
                var cr = context.contentResolver
                var values = ContentValues()
                values.put(Events.DTSTART, startMillis)
                values.put(Events.DTEND, endMillis)
                values.put(Events.TITLE, title)
                values.put(Events.DESCRIPTION, text)
                values.put(Events.CALENDAR_ID, 1)
                values.put(Events.EVENT_TIMEZONE, "America/Los_Angeles")
                val uri: Uri = cr.insert(Events.CONTENT_URI, values)
    val intent = Intent(Intent.ACTION_INSERT)
            .setData(uri)
            .putExtra(Events.TITLE, title)
            .putExtra(Events.DESCRIPTION, text)
    activity.startActivity(intent)
                mNote.event = uri.lastPathSegment.toLong()
                mNoteDao.saveNote(mNote)
            } else {
                var uri = ContentUris.withAppendedId(Events.CONTENT_URI, mNote.event)
                val intent = Intent(Intent.ACTION_EDIT)
                        .setData(uri)
                activity.startActivity(intent)
            }
        }
       viewState.updateView()
    }
        fun saveNote(title: String, text: String) {
            mNote.title = title
            mNote.text = text
            mNote.changeDate = Date()
            mNoteDao.saveNote(mNote)
            EventBus.getDefault().post(NoteEditAction(mNotePosition))
            viewState.onNoteSaved()
        }
fun DeletEvent(){
    TimeApplication.context.contentResolver.delete( ContentUris.withAppendedId(CalendarContract.Events.CONTENT_URI, mNote.event),null,null)
    mNote.event=0
    mNoteDao.saveNote(mNote)
    viewState.updateView()
}
        fun deleteNote() {
            mNoteDao.deleteNote(mNote)
            EventBus.getDefault().post(NoteDeleteAction(mNotePosition))
            viewState.onNoteDeleted()
        }
        fun showNoteDeleteDialog() {
            viewState.showNoteDeleteDialog()
        }
        fun hideNoteDeleteDialog() {
            viewState.hideNoteDeleteDialog()
        }
        fun showNoteInfoDialog() {
            viewState.showNoteInfoDialog(mNote.getInfo())
        }
        fun hideNoteInfoDialog() {
            viewState.hideNoteInfoDialog()
        }
}
