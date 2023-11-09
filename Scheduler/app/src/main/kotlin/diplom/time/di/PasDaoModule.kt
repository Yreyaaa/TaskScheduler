package diplom.time.di

import dagger.Module
import dagger.Provides
import diplom.time.mvp.models.PasDao
import javax.inject.Singleton

@Module
class PasDaoModule {

    @Provides
    @Singleton
    fun providePasDao(): PasDao = PasDao()

}