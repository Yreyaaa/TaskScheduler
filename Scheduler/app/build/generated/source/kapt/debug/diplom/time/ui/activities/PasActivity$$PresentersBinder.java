package diplom.time.ui.activities;

import java.util.ArrayList;
import java.util.List;

import com.arellomobile.mvp.ParamsHolder;import com.arellomobile.mvp.PresenterBinder;
import com.arellomobile.mvp.presenter.PresenterField;
import com.arellomobile.mvp.PresenterFactory;
import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.presenter.PresenterType;

public class PasActivity$$PresentersBinder implements PresenterBinder<diplom.time.ui.activities.PasActivity>
{
	private diplom.time.ui.activities.PasActivity mTarget;


	@Override
	public void setTarget(final diplom.time.ui.activities.PasActivity target)
	{
		mTarget = target;
	}

	public class pPresenter$$ViewStateClassNameProvider implements PresenterField
	{
		@Override
		public String getTag()
		{
			return null;
		}

		@Override
		public PresenterType getPresenterType()
		{
			return PresenterType.LOCAL;
		}

		@Override
		public void setValue(MvpPresenter presenter)
		{
			mTarget.pPresenter = (diplom.time.mvp.presenters.PasPresenter) presenter;
		}

		@Override
		public Class<? extends MvpPresenter> getPresenterClass()
		{
			return diplom.time.mvp.presenters.PasPresenter.class;
		}

		@Override
		public diplom.time.mvp.presenters.PasPresenter getDefaultInstance()
		{
			return new diplom.time.mvp.presenters.PasPresenter();
		}

		@Override
		public Class<? extends PresenterFactory<?, ?>> getFactory()
		{
			return com.arellomobile.mvp.DefaultPresenterFactory.class;
		}

		@Override
		public String getPresenterId()
		{
			return null;
		}
		@Override
		public Class<? extends ParamsHolder<?>> getParamsHolderClass()
		{
			return com.arellomobile.mvp.DefaultParamsHolder.class;
		}
	}

	public List<PresenterField<? super diplom.time.ui.activities.PasActivity>> getPresenterFields()
	{
		List<PresenterField<? super diplom.time.ui.activities.PasActivity>> presenters = new ArrayList<>();

		presenters.add(new pPresenter$$ViewStateClassNameProvider());

		return presenters;
	}

}
