package diplom.time.mvp.presenters;

import com.arellomobile.mvp.MvpPresenter;
import dagger.MembersInjector;
import diplom.time.mvp.models.NoteDao;
import diplom.time.mvp.views.MainView;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class MainPresenter_MembersInjector implements MembersInjector<MainPresenter> {
  private final MembersInjector<MvpPresenter<MainView>> supertypeInjector;
  private final Provider<NoteDao> mNoteDaoProvider;

  public MainPresenter_MembersInjector(MembersInjector<MvpPresenter<MainView>> supertypeInjector, Provider<NoteDao> mNoteDaoProvider) {  
    assert supertypeInjector != null;
    this.supertypeInjector = supertypeInjector;
    assert mNoteDaoProvider != null;
    this.mNoteDaoProvider = mNoteDaoProvider;
  }

  @Override
  public void injectMembers(MainPresenter instance) {  
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    supertypeInjector.injectMembers(instance);
    instance.mNoteDao = mNoteDaoProvider.get();
  }

  public static MembersInjector<MainPresenter> create(MembersInjector<MvpPresenter<MainView>> supertypeInjector, Provider<NoteDao> mNoteDaoProvider) {  
      return new MainPresenter_MembersInjector(supertypeInjector, mNoteDaoProvider);
  }
}

