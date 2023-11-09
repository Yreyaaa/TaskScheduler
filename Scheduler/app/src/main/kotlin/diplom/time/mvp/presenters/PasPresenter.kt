package diplom.time.mvp.presenters
//Импорт библиотек и нжектирование View элемента
import android.app.Activity
import android.content.Intent
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import diplom.time.TimeApplication
import diplom.time.bus.NoteDeleteAction
import diplom.time.bus.PasEditAction
import diplom.time.mvp.models.Pas
import diplom.time.mvp.models.PasDao
import diplom.time.mvp.views.PasView
import diplom.time.ui.activities.MainActivity
import diplom.time.utils.setPasSortMethod
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import java.util.*
import javax.inject.Inject
@InjectViewState
class PasPresenter : MvpPresenter<PasView>() {
    enum class SortPasBy : Comparator<Pas> {
        NAME {
            override fun compare(lhs: Pas, rhs: Pas) = lhs.title!!.compareTo(rhs.title!!)
        },
    }
    @Inject
    lateinit  var mPasDao: PasDao
    lateinit var mPasList: MutableList<Pas>
    init {
        TimeApplication.graph.inject(this)
        EventBus.getDefault().register(this)
    }
    //Метод первичной загрузки разделов из БД
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadAllPas()
    }
    //Иетод закгрузки разделов из БД
    fun loadAllPas() {
        mPasList = mPasDao.loadAllPas()
        viewState.onPasLoaded(mPasList)
    }
    //Удаление всех разделов
    fun deleteAllPas() {
        mPasDao.deleteAllPas()
        mPasList.removeAll(mPasList)
        viewState.onAllPasDeleted()
    }
    //Удаленре конкретного раздела
    fun deletePasByPosition(position: Int) {
        val pas = mPasList[position];
        mPasDao.deletePas(pas, position)
        mPasList.remove(pas)
        viewState.onPasDeleted()
    }
    //Метод создания носого раздела
    fun openNewPas(activity: Activity) {
        val newPas = mPasDao.createPas()
        mPasList.add(newPas)
        viewState.updateView()
        openPas(activity, mPasList.indexOf(newPas))
    }
    //Метод запуска activity выбранного раздела
    fun openPas(activity: Activity, position: Int) {
        val intent = Intent(activity, MainActivity::class.java)
        intent.putExtra("pas_position", position)
        intent.putExtra("pas_id", mPasList[position].id)
        activity.startActivity(intent)
    }
    fun search(query: String) {}
    fun sortPasBy(sortMethod: PasPresenter.SortPasBy) {
        mPasList.sortWith(sortMethod)
        setPasSortMethod(sortMethod.toString())
        viewState.updateView()
    }
    fun getCurrentSortMethod(): PasPresenter.SortPasBy {
        return PasPresenter.SortPasBy.valueOf("NAME")
    }
    @Subscribe
    fun onPasEdit(action: PasEditAction) {
        val pasPosition = action.position
        mPasList[pasPosition] = mPasDao.getPasById(mPasList[pasPosition].id) //обновляем заметку по позиции
        sortPasBy(getCurrentSortMethod())
    }
    @Subscribe
    fun onPasDelete(action: NoteDeleteAction) {
    }
    fun showPasContextDialog(position: Int) {
        viewState.showPasContextDialog(position)
    }
    fun hidePasContextDialog() {
        viewState.hidePasContextDialog()
    }
    fun showPasDeleteDialog(position: Int) {
        viewState.showPasDeleteDialog(position)
    }

    fun hidePasDeleteDialog() {
        viewState.hidePasDeleteDialog()
    }
    fun showPasInfo(position: Int) {    }
    fun hidePasInfoDialog() {
    }
}
