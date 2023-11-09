package diplom.time.mvp.presenters;

import com.arellomobile.mvp.MvpPresenter;
import dagger.MembersInjector;
import diplom.time.mvp.models.NoteDao;
import diplom.time.mvp.views.NoteView;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class NotePresenter_MembersInjector implements MembersInjector<NotePresenter> {
  private final MembersInjector<MvpPresenter<NoteView>> supertypeInjector;
  private final Provider<NoteDao> mNoteDaoProvider;

  public NotePresenter_MembersInjector(MembersInjector<MvpPresenter<NoteView>> supertypeInjector, Provider<NoteDao> mNoteDaoProvider) {  
    assert supertypeInjector != null;
    this.supertypeInjector = supertypeInjector;
    assert mNoteDaoProvider != null;
    this.mNoteDaoProvider = mNoteDaoProvider;
  }

  @Override
  public void injectMembers(NotePresenter instance) {  
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    supertypeInjector.injectMembers(instance);
    instance.mNoteDao = mNoteDaoProvider.get();
  }

  public static MembersInjector<NotePresenter> create(MembersInjector<MvpPresenter<NoteView>> supertypeInjector, Provider<NoteDao> mNoteDaoProvider) {  
      return new NotePresenter_MembersInjector(supertypeInjector, mNoteDaoProvider);
  }
}

