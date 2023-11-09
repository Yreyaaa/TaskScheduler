package diplom.time.ui.activities
//Импорт библиотек и нжектирование View элемента
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.afollestad.materialdialogs.MaterialDialog
import com.arellomobile.mvp.presenter.InjectPresenter
import diplom.time.R
import diplom.time.mvp.common.MvpAppCompatActivity
import diplom.time.mvp.models.Pas
import diplom.time.mvp.presenters.PasPresenter
import diplom.time.mvp.views.PasView
import diplom.time.ui.adapters.PasAdapter
import diplom.time.ui.commons.ItemClickSupport
import kotlinx.android.synthetic.main.activity_pas.*
class PasActivity : MvpAppCompatActivity(), PasView{
    @InjectPresenter
    lateinit var pPresenter: PasPresenter
    private var mPasContextDialog: MaterialDialog? = null
    private var mPasDeleteDialog: MaterialDialog? = null
    private var mPasInfoDialog: MaterialDialog? = null
    //Перегруженный метод конструктор суперкласса с инициализацией переменных по элементами интерфейса
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pas)
        with(ItemClickSupport.addTo(rvPasList)) {
            setOnItemClickListener { recyclerView, position, v -> pPresenter
                    .openPas(this@PasActivity, position) }
            setOnItemLongClickListener { recyclerView, position, v -> pPresenter
                    .showPasContextDialog(position); true }
        }
        //Связь кнопои создания раздела с слушателям
       fabButtonp.attachToRecyclerView(rvPasList)
       fabButtonp.setOnClickListener { pPresenter.openNewPas(this) }
    }
    //Обновление экрана после загрузки из БД
    override fun onPasLoaded(pas: List<Pas>) {
        rvPasList.adapter = PasAdapter(pas)
        updateView()
    }
    //Метод обновления компонентов экрана
    override fun updateView() {
        rvPasList.adapter.notifyDataSetChanged()
        if (rvPasList.adapter.itemCount == 0) {
            rvPasList.visibility = View.GONE
        } else {
            rvPasList.visibility = View.VISIBLE
        }
    }
    //Метод вывода сообщения об удалении раздела
    override fun onPasDeleted() {
        updateView()
        Toast.makeText(this, "Раздел удален", Toast.LENGTH_SHORT).show()
    }
    //Метод вывода сообщения об удалении всех разделов
    override fun onAllPasDeleted() {
        updateView()
        Toast.makeText(this, "Все разделы удалены", Toast.LENGTH_SHORT).show()
    }
    //Инициализация адаптера формирования списка
    override fun onSearchResult(pas: List<Pas>) {
        rvPasList.adapter = PasAdapter(pas)
    }
    override fun showPasContextDialog(pasPosition: Int) {
        mPasContextDialog = MaterialDialog.Builder(this)
                .items(R.array.main_pas_context)
                .itemsCallback { dialog, view, position, text ->
                    onContextDialogItemClick(position, pasPosition)
                    pPresenter.hidePasContextDialog()
                }
                .cancelListener { pPresenter.hidePasContextDialog() }
                .show();
    }

    override fun hidePasContextDialog() {
        mPasContextDialog?.dismiss()
    }

    override fun showPasDeleteDialog(pasPosition: Int) {
        mPasDeleteDialog = MaterialDialog.Builder(this)
                .title("Удаление раздела")
                .content("Вы действительно хотите удалить раздел")
                .positiveText("Да")
                .negativeText("Нет")
                .onPositive { materialDialog, dialogAction ->
                    pPresenter.deletePasByPosition(pasPosition)
                }
                .onNegative { materialDialog, dialogAction -> pPresenter.hidePasDeleteDialog() }
                .cancelListener { pPresenter.hidePasDeleteDialog() }
                .show()
    }


    override fun hidePasDeleteDialog() {

    }

    override fun showPasInfoDialog(PasInfo: String) {

    }

    override fun hidePasInfoDialog() {

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.pas, menu)


        return true
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menuDeleteAllNotes -> pPresenter.deleteAllPas()
        }
        return super.onOptionsItemSelected(item)
    }

    fun onContextDialogItemClick(contextItemPosition: Int, pasPosition: Int) {
        when (contextItemPosition) {
            0 -> pPresenter.openPas(this, pasPosition)
            1 -> pPresenter.showPasDeleteDialog(pasPosition)
        }
    }

}
