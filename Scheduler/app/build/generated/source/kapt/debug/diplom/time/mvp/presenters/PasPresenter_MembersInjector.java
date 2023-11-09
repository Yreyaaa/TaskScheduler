package diplom.time.mvp.presenters;

import com.arellomobile.mvp.MvpPresenter;
import dagger.MembersInjector;
import diplom.time.mvp.models.PasDao;
import diplom.time.mvp.views.PasView;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class PasPresenter_MembersInjector implements MembersInjector<PasPresenter> {
  private final MembersInjector<MvpPresenter<PasView>> supertypeInjector;
  private final Provider<PasDao> mPasDaoProvider;

  public PasPresenter_MembersInjector(MembersInjector<MvpPresenter<PasView>> supertypeInjector, Provider<PasDao> mPasDaoProvider) {  
    assert supertypeInjector != null;
    this.supertypeInjector = supertypeInjector;
    assert mPasDaoProvider != null;
    this.mPasDaoProvider = mPasDaoProvider;
  }

  @Override
  public void injectMembers(PasPresenter instance) {  
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    supertypeInjector.injectMembers(instance);
    instance.mPasDao = mPasDaoProvider.get();
  }

  public static MembersInjector<PasPresenter> create(MembersInjector<MvpPresenter<PasView>> supertypeInjector, Provider<PasDao> mPasDaoProvider) {  
      return new PasPresenter_MembersInjector(supertypeInjector, mPasDaoProvider);
  }
}

