package diplom.time.ui.activities
//Импорт библиотек и нжектирование View элемента
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.afollestad.materialdialogs.MaterialDialog
import com.arellomobile.mvp.presenter.InjectPresenter
import diplom.time.R
import diplom.time.mvp.common.MvpAppCompatActivity
import diplom.time.mvp.models.Note
import diplom.time.mvp.presenters.NotePresenter
import diplom.time.mvp.views.NoteView
import diplom.time.utils.formatDate
import kotlinx.android.synthetic.main.activity_note.*
class NoteActivity : MvpAppCompatActivity(), NoteView {
    @InjectPresenter
    lateinit var mPresenter: NotePresenter
    private var mNoteDeleteDialog: MaterialDialog? = null
    private var mNoteInfoDialog: MaterialDialog? = null
    //Перегруженный метод конструктор суперкласса с инициализацией переменных по элементами интерфейса
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)
        etTitle.onFocusChangeListener = View.OnFocusChangeListener() { view, hasFocus ->
            if (hasFocus) {
                var editText = view as EditText
                editText.setSelection((editText.text.length))
            }
        };
        fabButton3.setOnClickListener { mPresenter
                .AddEvent(this, etTitle.text.toString(), etText.text.toString()) }
        fabButton2.setOnClickListener { mPresenter.DeletEvent() }
        val noteId = intent.extras.getLong("note_id", -1)
        val notePosition = intent.extras.getInt("note_position", -1)
        mPresenter.showNote(noteId, notePosition)
    }
    //Метод обновления представления экарна, применяется при регистрациии изменений
    override fun updateView() {
        if (mPresenter.event()){ fabButton2.visibility=View.VISIBLE }else{
            fabButton2.visibility=View.INVISIBLE
        }
    }
    //Импорт наполнения текстовых полей из БД
    override fun showNote(note: Note) {
        tvNoteDate.text = formatDate(note.changeDate)
        etTitle.setText(note.title)
        etText.setText(note.text)
        //Проверка наличичя события для отображения/скрвтия кнопки удаления события
        if (mPresenter.event()){ fabButton2.visibility=View.VISIBLE }
    }
    //Метод показа откан информации о заметке
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
    override fun showNoteDeleteDialog() {
        mNoteDeleteDialog = MaterialDialog.Builder(this)
                .title("Удаление заметки")
                .content("Вы действительно хотите удалить заметку")
                .positiveText("Да")
                .negativeText("Нет")
                .onPositive { materialDialog, dialogAction ->
                    mPresenter.hideNoteDeleteDialog()
                    mPresenter.deleteNote()
                }
                .onNegative { materialDialog, dialogAction -> mPresenter.hideNoteDeleteDialog() }
                .cancelListener { mPresenter.hideNoteDeleteDialog() }
                .show()
    }

    override fun hideNoteDeleteDialog() {
        mNoteDeleteDialog?.dismiss()
    }
    override fun onNoteSaved() {
        Toast.makeText(this, "Сохранено", Toast.LENGTH_SHORT).show()
    }
    override fun onNoteDeleted() {
        Toast.makeText(this, R.string.note_is_deleted, Toast.LENGTH_SHORT).show()
        finish()
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.note, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menuSaveNote -> mPresenter.saveNote(etTitle.text.toString(), etText.text.toString())

            R.id.menuDeleteNote -> mPresenter.showNoteDeleteDialog()

            R.id.menuNoteInfo -> mPresenter.showNoteInfoDialog()
        }
        return super.onOptionsItemSelected(item)
    }
}