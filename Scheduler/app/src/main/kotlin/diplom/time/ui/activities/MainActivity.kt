package diplom.time.ui.activities
//Импорт библиотек и нжектирование View элемента
import android.os.Bundle
import android.support.v7.widget.SearchView
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.afollestad.materialdialogs.MaterialDialog
import com.arellomobile.mvp.presenter.InjectPresenter
import com.pawegio.kandroid.onQueryChange
import diplom.time.R
import diplom.time.mvp.common.MvpAppCompatActivity
import diplom.time.mvp.models.Note
import diplom.time.mvp.models.Pas
import diplom.time.mvp.presenters.MainPresenter
import diplom.time.mvp.views.MainView
import diplom.time.ui.adapters.NotesAdapter
import diplom.time.ui.commons.ItemClickSupport
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : MvpAppCompatActivity(), MainView {
    override fun showPas(pas: Pas) {
        pTitle.setText(pas.title)
    }
    @InjectPresenter
    lateinit var mPresenter: MainPresenter
    private var mNoteContextDialog: MaterialDialog? = null
    private var mNoteDeleteDialog: MaterialDialog? = null
    private var mNoteInfoDialog: MaterialDialog? = null
    //Перегруженный метод конструктор суперкласса с инициализацией переменных по элементами интерфейса
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        with(ItemClickSupport.addTo(rvNotesList)) {
            setOnItemClickListener { recyclerView, position, v -> mPresenter
                    .openNote(this@MainActivity, position) }
            setOnItemLongClickListener { recyclerView, position, v -> mPresenter
                    .showNoteContextDialog(position); true }
        }
        //Связь кнопои создания записи с слушателям
        fabButton.attachToRecyclerView(rvNotesList)
        fabButton.setOnClickListener { mPresenter.openNewNote(this) }
        val pasId = intent.extras.getLong("pas_id", -1)
        val pasPosition = intent.extras.getInt("pas_position", -1)
        mPresenter.showPas(pasId, pasPosition)
    }
    //Метод вывода сообщения о сохранении заметки
    override fun onPasSaved() {
        Toast.makeText(this, "Сохранено", Toast.LENGTH_SHORT).show()
    }
    //Обновление экрана после загрузки из БД
    override fun onNotesLoaded(notes: List<Note>) {
        rvNotesList.adapter = NotesAdapter(notes)
        updateView()
    }
    //Метод обновления компонентов экрана
    override fun updateView() {
        rvNotesList.adapter.notifyDataSetChanged()
        if (rvNotesList.adapter.itemCount == 0) {
            rvNotesList.visibility = View.GONE
            tvNotesIsEmpty.visibility = View.VISIBLE
        } else {
            rvNotesList.visibility = View.VISIBLE
            tvNotesIsEmpty.visibility = View.GONE
        }
    }
    //Метод вывода сообщения об удалении заметки
    override fun onNoteDeleted() {
        updateView()
        Toast.makeText(this, R.string.note_is_deleted, Toast.LENGTH_SHORT).show()
    }
    override fun onAllNotesDeleted() {
        updateView()
        Toast.makeText(this, R.string.all_notes_is_deleted, Toast.LENGTH_SHORT).show()
    }
    override fun onSearchResult(notes: List<Note>) {
        rvNotesList.adapter = NotesAdapter(notes)
    }
    override fun showNoteContextDialog(notePosition: Int) {
        mNoteContextDialog = MaterialDialog.Builder(this)
                .items(R.array.main_note_context)
                .itemsCallback { dialog, view, position, text ->
                    onContextDialogItemClick(position, notePosition)
                    mPresenter.hideNoteContextDialog()
                }
                .cancelListener { mPresenter.hideNoteContextDialog() }
                .show();
    }
    override fun hideNoteContextDialog() {
        mNoteContextDialog?.dismiss()
    }
    override fun showNoteDeleteDialog(notePosition: Int) {
        mNoteDeleteDialog = MaterialDialog.Builder(this)
                .title("Удаление заметки")
                .content("Вы действительно хотите удалить заметку")
                .positiveText("Да")
                .negativeText("Нет")
                .onPositive { materialDialog, dialogAction ->
                    mPresenter.deleteNoteByPosition(notePosition)
                    mNoteInfoDialog?.dismiss()
                }
                .onNegative { materialDialog, dialogAction -> mPresenter.hideNoteDeleteDialog() }
                .cancelListener { mPresenter.hideNoteDeleteDialog() }
                .show()
    }
    override fun hideNoteDeleteDialog() {
        mNoteDeleteDialog?.dismiss()
    }
    override fun showNoteInfoDialog(noteInfo: String) {
        mNoteInfoDialog = MaterialDialog.Builder(this)
                .title("Информация о заметке")
                .positiveText("Ок")
                .content(noteInfo)
                .onPositive { materialDialog, dialogAction -> mPresenter.hideNoteInfoDialog() }
                .cancelListener { mPresenter.hideNoteInfoDialog() }
                .show()
    }
    override fun hideNoteInfoDialog() {
        mNoteInfoDialog?.dismiss()
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)

        initSearchView(menu)
        return true
    }
    private fun initSearchView(menu: Menu) {
        var searchViewMenuItem = menu.findItem(R.id.action_search);
        var searchView = searchViewMenuItem.actionView as SearchView;
        searchView.onQueryChange { query -> mPresenter.search(query) }
        searchView.setOnCloseListener { mPresenter.search(""); false }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menuDeleteAllNotes -> mPresenter.deleteAllNotesP()
            R.id.menuSave -> mPresenter.savePas(pTitle.text.toString())
            R.id.menuSortByName -> mPresenter.sortNotesBy(MainPresenter.SortNotesBy.NAME)
            R.id.menuSortByDate -> mPresenter.sortNotesBy(MainPresenter.SortNotesBy.DATE)
        }
        return super.onOptionsItemSelected(item)
    }
    fun onContextDialogItemClick(contextItemPosition: Int, notePosition: Int) {
        when (contextItemPosition) {
            0 -> mPresenter.openNote(this, notePosition)
            1 -> mPresenter.showNoteInfo(notePosition)
            2 -> mPresenter.showNoteDeleteDialog(notePosition)
        }
    }
    override fun onDestroy() {
        super.onDestroy()
    }
}
