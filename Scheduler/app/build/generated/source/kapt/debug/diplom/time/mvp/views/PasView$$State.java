package diplom.time.mvp.views;

import com.arellomobile.mvp.viewstate.MvpViewState;
import com.arellomobile.mvp.viewstate.ViewCommand;
import com.arellomobile.mvp.viewstate.ViewCommands;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategy;

public class PasView$$State extends MvpViewState<PasView> implements PasView
{
	private ViewCommands<PasView> mViewCommands = new ViewCommands<>();

	@Override
	public void restoreState(PasView view)
	{
		if (mViewCommands.isEmpty())
		{
			return;
		}

		mViewCommands.reapply(view);
	}

	@Override
	public void onPasLoaded(java.util.List<diplom.time.mvp.models.Pas> arg0)
	{
		OnPasLoadedParams params = new OnPasLoadedParams(arg0);
		mViewCommands.beforeApply(LocalViewCommand.onPasLoaded, params);

		if (mViews == null || mViews.isEmpty())
		{
			return;
		}

		for(PasView view : mViews)
		{
			view.onPasLoaded(arg0);
		}

		mViewCommands.afterApply(LocalViewCommand.onPasLoaded, params);
	}

	@Override
	public void updateView()
	{
		Void params = null;
		mViewCommands.beforeApply(LocalViewCommand.updateView, params);

		if (mViews == null || mViews.isEmpty())
		{
			return;
		}

		for(PasView view : mViews)
		{
			view.updateView();
		}

		mViewCommands.afterApply(LocalViewCommand.updateView, params);
	}

	@Override
	public void onSearchResult(java.util.List<diplom.time.mvp.models.Pas> arg0)
	{
		OnSearchResultParams params = new OnSearchResultParams(arg0);
		mViewCommands.beforeApply(LocalViewCommand.onSearchResult, params);

		if (mViews == null || mViews.isEmpty())
		{
			return;
		}

		for(PasView view : mViews)
		{
			view.onSearchResult(arg0);
		}

		mViewCommands.afterApply(LocalViewCommand.onSearchResult, params);
	}

	@Override
	public void onAllPasDeleted()
	{
		Void params = null;
		mViewCommands.beforeApply(LocalViewCommand.onAllPasDeleted, params);

		if (mViews == null || mViews.isEmpty())
		{
			return;
		}

		for(PasView view : mViews)
		{
			view.onAllPasDeleted();
		}

		mViewCommands.afterApply(LocalViewCommand.onAllPasDeleted, params);
	}

	@Override
	public void onPasDeleted()
	{
		Void params = null;
		mViewCommands.beforeApply(LocalViewCommand.onPasDeleted, params);

		if (mViews == null || mViews.isEmpty())
		{
			return;
		}

		for(PasView view : mViews)
		{
			view.onPasDeleted();
		}

		mViewCommands.afterApply(LocalViewCommand.onPasDeleted, params);
	}

	@Override
	public void showPasInfoDialog(java.lang.String arg0)
	{
		ShowPasInfoDialogParams params = new ShowPasInfoDialogParams(arg0);
		mViewCommands.beforeApply(LocalViewCommand.showPasInfoDialog, params);

		if (mViews == null || mViews.isEmpty())
		{
			return;
		}

		for(PasView view : mViews)
		{
			view.showPasInfoDialog(arg0);
		}

		mViewCommands.afterApply(LocalViewCommand.showPasInfoDialog, params);
	}

	@Override
	public void hidePasInfoDialog()
	{
		Void params = null;
		mViewCommands.beforeApply(LocalViewCommand.hidePasInfoDialog, params);

		if (mViews == null || mViews.isEmpty())
		{
			return;
		}

		for(PasView view : mViews)
		{
			view.hidePasInfoDialog();
		}

		mViewCommands.afterApply(LocalViewCommand.hidePasInfoDialog, params);
	}

	@Override
	public void showPasDeleteDialog(int arg0)
	{
		ShowPasDeleteDialogParams params = new ShowPasDeleteDialogParams(arg0);
		mViewCommands.beforeApply(LocalViewCommand.showPasDeleteDialog, params);

		if (mViews == null || mViews.isEmpty())
		{
			return;
		}

		for(PasView view : mViews)
		{
			view.showPasDeleteDialog(arg0);
		}

		mViewCommands.afterApply(LocalViewCommand.showPasDeleteDialog, params);
	}

	@Override
	public void hidePasDeleteDialog()
	{
		Void params = null;
		mViewCommands.beforeApply(LocalViewCommand.hidePasDeleteDialog, params);

		if (mViews == null || mViews.isEmpty())
		{
			return;
		}

		for(PasView view : mViews)
		{
			view.hidePasDeleteDialog();
		}

		mViewCommands.afterApply(LocalViewCommand.hidePasDeleteDialog, params);
	}

	@Override
	public void showPasContextDialog(int arg0)
	{
		ShowPasContextDialogParams params = new ShowPasContextDialogParams(arg0);
		mViewCommands.beforeApply(LocalViewCommand.showPasContextDialog, params);

		if (mViews == null || mViews.isEmpty())
		{
			return;
		}

		for(PasView view : mViews)
		{
			view.showPasContextDialog(arg0);
		}

		mViewCommands.afterApply(LocalViewCommand.showPasContextDialog, params);
	}

	@Override
	public void hidePasContextDialog()
	{
		Void params = null;
		mViewCommands.beforeApply(LocalViewCommand.hidePasContextDialog, params);

		if (mViews == null || mViews.isEmpty())
		{
			return;
		}

		for(PasView view : mViews)
		{
			view.hidePasContextDialog();
		}

		mViewCommands.afterApply(LocalViewCommand.hidePasContextDialog, params);
	}

	private enum LocalViewCommand implements ViewCommand<PasView>
	{
		onPasLoaded(com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy.class, "onPasLoaded")
				{
					@Override
					public void apply(PasView mvpView, Object paramsObject)
					{
						final OnPasLoadedParams params = (OnPasLoadedParams) paramsObject;
						mvpView.onPasLoaded(params.arg0);
					}
				},
		updateView(com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy.class, "updateView")
				{
					@Override
					public void apply(PasView mvpView, Object paramsObject)
					{
						mvpView.updateView();
					}
				},
		onSearchResult(com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy.class, "onSearchResult")
				{
					@Override
					public void apply(PasView mvpView, Object paramsObject)
					{
						final OnSearchResultParams params = (OnSearchResultParams) paramsObject;
						mvpView.onSearchResult(params.arg0);
					}
				},
		onAllPasDeleted(com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy.class, "onAllPasDeleted")
				{
					@Override
					public void apply(PasView mvpView, Object paramsObject)
					{
						mvpView.onAllPasDeleted();
					}
				},
		onPasDeleted(com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy.class, "onPasDeleted")
				{
					@Override
					public void apply(PasView mvpView, Object paramsObject)
					{
						mvpView.onPasDeleted();
					}
				},
		showPasInfoDialog(com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy.class, "showPasInfoDialog")
				{
					@Override
					public void apply(PasView mvpView, Object paramsObject)
					{
						final ShowPasInfoDialogParams params = (ShowPasInfoDialogParams) paramsObject;
						mvpView.showPasInfoDialog(params.arg0);
					}
				},
		hidePasInfoDialog(com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy.class, "hidePasInfoDialog")
				{
					@Override
					public void apply(PasView mvpView, Object paramsObject)
					{
						mvpView.hidePasInfoDialog();
					}
				},
		showPasDeleteDialog(com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy.class, "showPasDeleteDialog")
				{
					@Override
					public void apply(PasView mvpView, Object paramsObject)
					{
						final ShowPasDeleteDialogParams params = (ShowPasDeleteDialogParams) paramsObject;
						mvpView.showPasDeleteDialog(params.arg0);
					}
				},
		hidePasDeleteDialog(com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy.class, "hidePasDeleteDialog")
				{
					@Override
					public void apply(PasView mvpView, Object paramsObject)
					{
						mvpView.hidePasDeleteDialog();
					}
				},
		showPasContextDialog(com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy.class, "showPasContextDialog")
				{
					@Override
					public void apply(PasView mvpView, Object paramsObject)
					{
						final ShowPasContextDialogParams params = (ShowPasContextDialogParams) paramsObject;
						mvpView.showPasContextDialog(params.arg0);
					}
				},
		hidePasContextDialog(com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy.class, "hidePasContextDialog")
				{
					@Override
					public void apply(PasView mvpView, Object paramsObject)
					{
						mvpView.hidePasContextDialog();
					}
				};

		private Class<? extends StateStrategy> mStateStrategyType;
		private String mTag;

		LocalViewCommand(Class<? extends StateStrategy> stateStrategyType, String tag)
		{
			mStateStrategyType = stateStrategyType;
			mTag = tag;
		}

		@Override
		public Class<? extends StateStrategy> getStrategyType()
		{
			return mStateStrategyType;
		}

		@Override
		public String getTag()
		{
			return mTag;
		}
	}

	private class OnPasLoadedParams
	{
		java.util.List<diplom.time.mvp.models.Pas> arg0;

		OnPasLoadedParams(java.util.List<diplom.time.mvp.models.Pas> arg0)
		{
			this.arg0 = arg0;
		}
	}

	private class OnSearchResultParams
	{
		java.util.List<diplom.time.mvp.models.Pas> arg0;

		OnSearchResultParams(java.util.List<diplom.time.mvp.models.Pas> arg0)
		{
			this.arg0 = arg0;
		}
	}

	private class ShowPasInfoDialogParams
	{
		java.lang.String arg0;

		ShowPasInfoDialogParams(java.lang.String arg0)
		{
			this.arg0 = arg0;
		}
	}

	private class ShowPasDeleteDialogParams
	{
		int arg0;

		ShowPasDeleteDialogParams(int arg0)
		{
			this.arg0 = arg0;
		}
	}

	private class ShowPasContextDialogParams
	{
		int arg0;

		ShowPasContextDialogParams(int arg0)
		{
			this.arg0 = arg0;
		}
	}
}
