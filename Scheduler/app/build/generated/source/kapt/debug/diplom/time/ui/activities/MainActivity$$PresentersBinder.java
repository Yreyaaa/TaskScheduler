package diplom.time.ui.activities;

import java.util.ArrayList;
import java.util.List;

import com.arellomobile.mvp.ParamsHolder;import com.arellomobile.mvp.PresenterBinder;
import com.arellomobile.mvp.presenter.PresenterField;
import com.arellomobile.mvp.PresenterFactory;
import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.presenter.PresenterType;

public class MainActivity$$PresentersBinder implements PresenterBinder<diplom.time.ui.activities.MainActivity>
{
	private diplom.time.ui.activities.MainActivity mTarget;


	@Override
	public void setTarget(final diplom.time.ui.activities.MainActivity target)
	{
		mTarget = target;
	}

	public class mPresenter$$ViewStateClassNameProvider implements PresenterField
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
			mTarget.mPresenter = (diplom.time.mvp.presenters.MainPresenter) presenter;
		}

		@Override
		public Class<? extends MvpPresenter> getPresenterClass()
		{
			return diplom.time.mvp.presenters.MainPresenter.class;
		}

		@Override
		public diplom.time.mvp.presenters.MainPresenter getDefaultInstance()
		{
			return new diplom.time.mvp.presenters.MainPresenter();
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

	public List<PresenterField<? super diplom.time.ui.activities.MainActivity>> getPresenterFields()
	{
		List<PresenterField<? super diplom.time.ui.activities.MainActivity>> presenters = new ArrayList<>();

		presenters.add(new mPresenter$$ViewStateClassNameProvider());

		return presenters;
	}

}
