package diplom.time
import android.content.Context
import com.activeandroid.app.Application
import diplom.time.di.AppComponent
import diplom.time.di.DaggerAppComponent
import diplom.time.di.NoteDaoModule
import diplom.time.di.PasDaoModule
import diplom.time.utils.initPrefs
class TimeApplication : Application() {
    companion object {
        lateinit var graph: AppComponent
        lateinit var graph1: AppComponent


        lateinit var context: Context
    }
    override fun onCreate() {
        initPrefs(this)
        context = this
        graph = DaggerAppComponent.builder().pasDaoModule(PasDaoModule()).build()
        graph1 = DaggerAppComponent.builder().noteDaoModule(NoteDaoModule()).build()
        super.onCreate()
    }

}
