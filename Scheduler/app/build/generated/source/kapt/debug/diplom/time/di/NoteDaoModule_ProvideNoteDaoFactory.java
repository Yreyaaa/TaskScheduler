package diplom.time.di;

import dagger.internal.Factory;
import diplom.time.mvp.models.NoteDao;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class NoteDaoModule_ProvideNoteDaoFactory implements Factory<NoteDao> {
  private final NoteDaoModule module;

  public NoteDaoModule_ProvideNoteDaoFactory(NoteDaoModule module) {  
    assert module != null;
    this.module = module;
  }

  @Override
  public NoteDao get() {  
    NoteDao provided = module.provideNoteDao();
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<NoteDao> create(NoteDaoModule module) {  
    return new NoteDaoModule_ProvideNoteDaoFactory(module);
  }
}

