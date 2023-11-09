package diplom.time.mvp.views

import com.arellomobile.mvp.MvpView
import diplom.time.mvp.models.Note

interface NoteView : MvpView {

    fun showNote(note: Note)

    fun onNoteSaved()
    fun updateView()

    fun onNoteDeleted()

    fun showNoteInfoDialog(noteInfo: String)

    fun hideNoteInfoDialog()

    fun showNoteDeleteDialog()

    fun hideNoteDeleteDialog()

}
