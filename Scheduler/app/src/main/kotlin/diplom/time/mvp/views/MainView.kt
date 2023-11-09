package diplom.time.mvp.views

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import diplom.time.mvp.models.Note
import diplom.time.mvp.models.Pas

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface MainView : MvpView {

    fun onNotesLoaded(notes: List<Note>)

    fun updateView()

    fun onSearchResult(notes: List<Note>)

    fun onAllNotesDeleted()

    fun onNoteDeleted()
    fun onPasSaved()
    fun showPas(pas: Pas)

    fun showNoteInfoDialog(noteInfo: String)

    fun hideNoteInfoDialog()

    fun showNoteDeleteDialog(notePosition: Int)

    fun hideNoteDeleteDialog()

    fun showNoteContextDialog(notePosition: Int)

    fun hideNoteContextDialog()

}