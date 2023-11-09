package diplom.time.mvp.views

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import diplom.time.mvp.models.Note
import diplom.time.mvp.models.Pas

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface PasView : MvpView {

    fun onPasLoaded(pase: List<Pas>)

    fun updateView()


    fun onSearchResult(pase: List<Pas>)

    fun onAllPasDeleted()

    fun onPasDeleted()

    fun showPasInfoDialog(pasInfo: String)


    fun hidePasInfoDialog()

    fun showPasDeleteDialog(pasPosition: Int)

    fun hidePasDeleteDialog()

    fun showPasContextDialog(pasPosition: Int)

    fun hidePasContextDialog()

}