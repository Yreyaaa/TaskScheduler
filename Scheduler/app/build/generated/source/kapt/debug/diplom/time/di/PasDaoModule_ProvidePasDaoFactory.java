package diplom.time.di;

import dagger.internal.Factory;
import diplom.time.mvp.models.PasDao;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class PasDaoModule_ProvidePasDaoFactory implements Factory<PasDao> {
  private final PasDaoModule module;

  public PasDaoModule_ProvidePasDaoFactory(PasDaoModule module) {  
    assert module != null;
    this.module = module;
  }

  @Override
  public PasDao get() {  
    PasDao provided = module.providePasDao();
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<PasDao> create(PasDaoModule module) {  
    return new PasDaoModule_ProvidePasDaoFactory(module);
  }
}

