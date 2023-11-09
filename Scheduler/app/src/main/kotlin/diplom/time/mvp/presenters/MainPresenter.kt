package diplom.time.mvp.presenters
//Импорт библиотек и нжектирование View элемента
import android.app.Activity
import android.content.Intent
import com.activeandroid.query.Select
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import diplom.time.TimeApplication
import diplom.time.bus.NoteDeleteAction
import diplom.time.bus.NoteEditAction
import diplom.time.bus.PasEditAction
import diplom.time.mvp.models.Note
import diplom.time.mvp.models.NoteDao
import diplom.time.mvp.models.Pas
import diplom.time.mvp.views.MainView
import diplom.time.ui.activities.NoteActivity
import diplom.time.utils.getNotesSortMethodName
import diplom.time.utils.setNotesSortMethod
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import java.util.*
import javax.inject.Inject
@InjectViewState
class MainPresenter : MvpPresenter<MainView>() {
    @Inject
    lateinit  var mNoteDao: NoteDao
    lateinit var mPas: Pas
    var mPasPosition: Int = -1
    lateinit var mNotesList: MutableList<Note>
    //Субкласс для сортировки записей
    enum class SortNotesBy : Comparator<Note> {
        DATE {
            override fun compare(lhs: Note, rhs: Note) = lhs.changeDate!!.compareTo(rhs.changeDate)
        },
        NAME {
            override fun compare(lhs: Note, rhs: Note) = lhs.title!!.compareTo(rhs.title!!)
        },
    }
    init {
        TimeApplication.graph.inject(this)
        EventBus.getDefault().register(this)
    }
    //Метод для загрузки записей при первом открытии раздела
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadAllNotes()
    }
    //Метод отображения раздела
    fun showPas(pasId: Long, pasPosition: Int) {
       mPasPosition = pasPosition
       mPas =  Select().from(Pas::class.java).where("id = ?", pasId).executeSingle<Pas>()
       viewState.showPas(mPas)
    }
    //Метод загркзки записей из БД
    fun loadAllNotes() {
        mNotesList = mNoteDao.loadAllNotes(mPasPosition)
        Collections.sort(mNotesList, getCurrentSortMethod())
        viewState.onNotesLoaded(mNotesList)
    }
    //Метод каскадного удаления по IF раздела
    fun deleteAllNotesP() {
        mNoteDao.deleteAllNotesP(mPasPosition)
        mNotesList.removeAll(mNotesList)
        viewState.onAllNotesDeleted()
    }
    fun deleteNoteByPosition(position: Int) {
        val note = mNotesList[position];
        mNoteDao.deleteNote(note)
        mNotesList.remove(note)
        viewState.onNoteDeleted()
    }
    fun openNewNote(activity: Activity) {
        val newNote = mNoteDao.createNote(mPasPosition)
        mNotesList.add(newNote)
        sortNotesBy(getCurrentSortMethod())
        openNote(activity, mNotesList.indexOf(newNote))
    }

    /**
     * Открывает активити с заметкой по позиции
     */
    fun openNote(activity: Activity, position: Int) {
        val intent = Intent(activity, NoteActivity::class.java)
        intent.putExtra("note_position", position)
        intent.putExtra("note_id", mNotesList[position].id)
        activity.startActivity(intent)
    }
    fun search(query: String) {
        if (query.equals("")) {
            viewState.onSearchResult(mNotesList)
        } else {
            val searchResults = mNotesList.filter { it.title!!.startsWith(query, ignoreCase = true) }
            viewState.onSearchResult(searchResults)
        }
    }
    fun sortNotesBy(sortMethod: SortNotesBy) {
        mNotesList.sortWith(sortMethod)
        setNotesSortMethod(sortMethod.toString())
        viewState.updateView()
    }
    fun getCurrentSortMethod(): SortNotesBy {
        val defaultSortMethodName = SortNotesBy.DATE.toString()
        val currentSortMethodName = getNotesSortMethodName("NAME")
        return SortNotesBy.valueOf(currentSortMethodName)
    }
    @Subscribe
    fun onNoteEdit(action: NoteEditAction) {
        val notePosition = action.position
        mNotesList[notePosition] = mNoteDao.getNoteById(mNotesList[notePosition].id) //обновляем заметку по позиции
        sortNotesBy(getCurrentSortMethod())
    }
    @Subscribe
    fun onNoteDelete(action: NoteDeleteAction) {
        mNotesList.removeAt(action.position)
        viewState.updateView()
    }
    fun showNoteContextDialog(position: Int) {
        viewState.showNoteContextDialog(position)
    }
    fun hideNoteContextDialog() {
        viewState.hideNoteContextDialog()
    }
    fun savePas(title: String) {
        mPas.title = title
        mPas.save()
       EventBus.getDefault().post(PasEditAction(mPasPosition))
       viewState.onPasSaved()
    }
    fun showNoteDeleteDialog(position: Int) {
        viewState.showNoteDeleteDialog(position)
    }
    fun hideNoteDeleteDialog() {
        viewState.hideNoteDeleteDialog()
    }
    fun showNoteInfo(position: Int) {
        viewState.showNoteInfoDialog(mNotesList[position].getInfo())
    }
    fun hideNoteInfoDialog() {
        viewState.hideNoteInfoDialog()
    }
}
