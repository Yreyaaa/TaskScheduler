package diplom.time.di

import dagger.Component
import diplom.time.mvp.presenters.MainPresenter
import diplom.time.mvp.presenters.NotePresenter
import diplom.time.mvp.presenters.PasPresenter
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(PasDaoModule::class,NoteDaoModule::class))
interface AppComponent {
    fun inject(pasPresenter: MainPresenter)
    fun inject(notePresenter: NotePresenter)
    fun inject(pasPresenter: PasPresenter)


}