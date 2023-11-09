package diplom.time.di;

import dagger.MembersInjector;
import dagger.internal.MembersInjectors;
import dagger.internal.ScopedProvider;
import diplom.time.mvp.models.NoteDao;
import diplom.time.mvp.models.PasDao;
import diplom.time.mvp.presenters.MainPresenter;
import diplom.time.mvp.presenters.MainPresenter_MembersInjector;
import diplom.time.mvp.presenters.NotePresenter;
import diplom.time.mvp.presenters.NotePresenter_MembersInjector;
import diplom.time.mvp.presenters.PasPresenter;
import diplom.time.mvp.presenters.PasPresenter_MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class DaggerAppComponent implements AppComponent {
  private Provider<NoteDao> provideNoteDaoProvider;
  private MembersInjector<MainPresenter> mainPresenterMembersInjector;
  private MembersInjector<NotePresenter> notePresenterMembersInjector;
  private Provider<PasDao> providePasDaoProvider;
  private MembersInjector<PasPresenter> pasPresenterMembersInjector;

  private DaggerAppComponent(Builder builder) {  
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {  
    return new Builder();
  }

  public static AppComponent create() {  
    return builder().build();
  }

  private void initialize(final Builder builder) {  
    this.provideNoteDaoProvider = ScopedProvider.create(NoteDaoModule_ProvideNoteDaoFactory.create(builder.noteDaoModule));
    this.mainPresenterMembersInjector = MainPresenter_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), provideNoteDaoProvider);
    this.notePresenterMembersInjector = NotePresenter_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), provideNoteDaoProvider);
    this.providePasDaoProvider = ScopedProvider.create(PasDaoModule_ProvidePasDaoFactory.create(builder.pasDaoModule));
    this.pasPresenterMembersInjector = PasPresenter_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), providePasDaoProvider);
  }

  @Override
  public void inject(MainPresenter arg0) {  
    mainPresenterMembersInjector.injectMembers(arg0);
  }

  @Override
  public void inject(NotePresenter arg0) {  
    notePresenterMembersInjector.injectMembers(arg0);
  }

  @Override
  public void inject(PasPresenter arg0) {  
    pasPresenterMembersInjector.injectMembers(arg0);
  }

  public static final class Builder {
    private PasDaoModule pasDaoModule;
    private NoteDaoModule noteDaoModule;
  
    private Builder() {  
    }
  
    public AppComponent build() {  
      if (pasDaoModule == null) {
        this.pasDaoModule = new PasDaoModule();
      }
      if (noteDaoModule == null) {
        this.noteDaoModule = new NoteDaoModule();
      }
      return new DaggerAppComponent(this);
    }
  
    public Builder pasDaoModule(PasDaoModule pasDaoModule) {  
      if (pasDaoModule == null) {
        throw new NullPointerException("pasDaoModule");
      }
      this.pasDaoModule = pasDaoModule;
      return this;
    }
  
    public Builder noteDaoModule(NoteDaoModule noteDaoModule) {  
      if (noteDaoModule == null) {
        throw new NullPointerException("noteDaoModule");
      }
      this.noteDaoModule = noteDaoModule;
      return this;
    }
  }
}

