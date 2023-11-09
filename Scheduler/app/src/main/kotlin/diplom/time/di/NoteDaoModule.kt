package diplom.time.di

import dagger.Module
import dagger.Provides
import diplom.time.mvp.models.NoteDao
import javax.inject.Singleton

@Module
class NoteDaoModule {

    @Provides
    @Singleton
    fun provideNoteDao(): NoteDao = NoteDao()

}