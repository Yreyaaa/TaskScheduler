package diplom.time.ui.adapters
//Импорт библиотек и нжектирование View элемента
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import diplom.time.R
import diplom.time.mvp.models.Note
import diplom.time.utils.formatDate
import java.util.*
class NotesAdapter : RecyclerView.Adapter<NotesAdapter.ViewHolder> {
    //Объявления массива записей для выгрузки из БД
    private var mNotesList: List<Note> = ArrayList()
    //Стартовый конструктор класса
    constructor(notesList: List<Note>) {
        mNotesList = notesList
    }
    //Метод формирования Viev списка
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): NotesAdapter.ViewHolder {
        var v = LayoutInflater.from(viewGroup.context).inflate(R
                .layout.note_item_layout, viewGroup, false)
        return NotesAdapter.ViewHolder(v);
    }
    override
    //Соотнесение списка с элементами массива
    fun onBindViewHolder(viewHolder: NotesAdapter.ViewHolder, i: Int) {
        var note = mNotesList[i];
        viewHolder.mNoteTitle.text = note.title;
        viewHolder.mNoteDate.text = formatDate(note.changeDate)
    }
    //Метод определения размера массива записей
    override fun getItemCount(): Int {
        return mNotesList.size
    }
    //Субкласс ViewHolder для приведения типов View
    class ViewHolder : RecyclerView.ViewHolder {
        var mNoteTitle: TextView
        var mNoteDate: TextView
        constructor(itemView: View) : super(itemView) {
            mNoteTitle = itemView.findViewById(R.id.tvItemNoteTitle) as TextView
            mNoteDate = itemView.findViewById(R.id.tvItemNoteDate) as TextView
        }
    }
}
