package diplom.time.mvp.views;

import com.arellomobile.mvp.viewstate.MvpViewState;
import com.arellomobile.mvp.viewstate.ViewCommand;
import com.arellomobile.mvp.viewstate.ViewCommands;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategy;

public class MainView$$State extends MvpViewState<MainView> implements MainView
{
	private ViewCommands<MainView> mViewCommands = new ViewCommands<>();

	@Override
	public void restoreState(MainView view)
	{
		if (mViewCommands.isEmpty())
		{
			return;
		}

		mViewCommands.reapply(view);
	}

	@Override
	public void onNotesLoaded(java.util.List<diplom.time.mvp.models.Note> arg0)
	{
		OnNotesLoadedParams params = new OnNotesLoadedParams(arg0);
		mViewCommands.beforeApply(LocalViewCommand.onNotesLoaded, params);

		if (mViews == null || mViews.isEmpty())
		{
			return;
		}

		for(MainView view : mViews)
		{
			view.onNotesLoaded(arg0);
		}

		mViewCommands.afterApply(LocalViewCommand.onNotesLoaded, params);
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

		for(MainView view : mViews)
		{
			view.updateView();
		}

		mViewCommands.afterApply(LocalViewCommand.updateView, params);
	}

	@Override
	public void onSearchResult(java.util.List<diplom.time.mvp.models.Note> arg0)
	{
		OnSearchResultParams params = new OnSearchResultParams(arg0);
		mViewCommands.beforeApply(LocalViewCommand.onSearchResult, params);

		if (mViews == null || mViews.isEmpty())
		{
			return;
		}

		for(MainView view : mViews)
		{
			view.onSearchResult(arg0);
		}

		mViewCommands.afterApply(LocalViewCommand.onSearchResult, params);
	}

	@Override
	public void onAllNotesDeleted()
	{
		Void params = null;
		mViewCommands.beforeApply(LocalViewCommand.onAllNotesDeleted, params);

		if (mViews == null || mViews.isEmpty())
		{
			return;
		}

		for(MainView view : mViews)
		{
			view.onAllNotesDeleted();
		}

		mViewCommands.afterApply(LocalViewCommand.onAllNotesDeleted, params);
	}

	@Override
	public void onNoteDeleted()
	{
		Void params = null;
		mViewCommands.beforeApply(LocalViewCommand.onNoteDeleted, params);

		if (mViews == null || mViews.isEmpty())
		{
			return;
		}

		for(MainView view : mViews)
		{
			view.onNoteDeleted();
		}

		mViewCommands.afterApply(LocalViewCommand.onNoteDeleted, params);
	}

	@Override
	public void onPasSaved()
	{
		Void params = null;
		mViewCommands.beforeApply(LocalViewCommand.onPasSaved, params);

		if (mViews == null || mViews.isEmpty())
		{
			return;
		}

		for(MainView view : mViews)
		{
			view.onPasSaved();
		}

		mViewCommands.afterApply(LocalViewCommand.onPasSaved, params);
	}

	@Override
	public void showPas(diplom.time.mvp.models.Pas arg0)
	{
		ShowPasParams params = new ShowPasParams(arg0);
		mViewCommands.beforeApply(LocalViewCommand.showPas, params);

		if (mViews == null || mViews.isEmpty())
		{
			return;
		}

		for(MainView view : mViews)
		{
			view.showPas(arg0);
		}

		mViewCommands.afterApply(LocalViewCommand.showPas, params);
	}

	@Override
	public void showNoteInfoDialog(java.lang.String arg0)
	{
		ShowNoteInfoDialogParams params = new ShowNoteInfoDialogParams(arg0);
		mViewCommands.beforeApply(LocalViewCommand.showNoteInfoDialog, params);

		if (mViews == null || mViews.isEmpty())
		{
			return;
		}

		for(MainView view : mViews)
		{
			view.showNoteInfoDialog(arg0);
		}

		mViewCommands.afterApply(LocalViewCommand.showNoteInfoDialog, params);
	}

	@Override
	public void hideNoteInfoDialog()
	{
		Void params = null;
		mViewCommands.beforeApply(LocalViewCommand.hideNoteInfoDialog, params);

		if (mViews == null || mViews.isEmpty())
		{
			return;
		}

		for(MainView view : mViews)
		{
			view.hideNoteInfoDialog();
		}

		mViewCommands.afterApply(LocalViewCommand.hideNoteInfoDialog, params);
	}

	@Override
	public void showNoteDeleteDialog(int arg0)
	{
		ShowNoteDeleteDialogParams params = new ShowNoteDeleteDialogParams(arg0);
		mViewCommands.beforeApply(LocalViewCommand.showNoteDeleteDialog, params);

		if (mViews == null || mViews.isEmpty())
		{
			return;
		}

		for(MainView view : mViews)
		{
			view.showNoteDeleteDialog(arg0);
		}

		mViewCommands.afterApply(LocalViewCommand.showNoteDeleteDialog, params);
	}

	@Override
	public void hideNoteDeleteDialog()
	{
		Void params = null;
		mViewCommands.beforeApply(LocalViewCommand.hideNoteDeleteDialog, params);

		if (mViews == null || mViews.isEmpty())
		{
			return;
		}

		for(MainView view : mViews)
		{
			view.hideNoteDeleteDialog();
		}

		mViewCommands.afterApply(LocalViewCommand.hideNoteDeleteDialog, params);
	}

	@Override
	public void showNoteContextDialog(int arg0)
	{
		ShowNoteContextDialogParams params = new ShowNoteContextDialogParams(arg0);
		mViewCommands.beforeApply(LocalViewCommand.showNoteContextDialog, params);

		if (mViews == null || mViews.isEmpty())
		{
			return;
		}

		for(MainView view : mViews)
		{
			view.showNoteContextDialog(arg0);
		}

		mViewCommands.afterApply(LocalViewCommand.showNoteContextDialog, params);
	}

	@Override
	public void hideNoteContextDialog()
	{
		Void params = null;
		mViewCommands.beforeApply(LocalViewCommand.hideNoteContextDialog, params);

		if (mViews == null || mViews.isEmpty())
		{
			return;
		}

		for(MainView view : mViews)
		{
			view.hideNoteContextDialog();
		}

		mViewCommands.afterApply(LocalViewCommand.hideNoteContextDialog, params);
	}

	private enum LocalViewCommand implements ViewCommand<MainView>
	{
		onNotesLoaded(com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy.class, "onNotesLoaded")
				{
					@Override
					public void apply(MainView mvpView, Object paramsObject)
					{
						final OnNotesLoadedParams params = (OnNotesLoadedParams) paramsObject;
						mvpView.onNotesLoaded(params.arg0);
					}
				},
		updateView(com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy.class, "updateView")
				{
					@Override
					public void apply(MainView mvpView, Object paramsObject)
					{
						mvpView.updateView();
					}
				},
		onSearchResult(com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy.class, "onSearchResult")
				{
					@Override
					public void apply(MainView mvpView, Object paramsObject)
					{
						final OnSearchResultParams params = (OnSearchResultParams) paramsObject;
						mvpView.onSearchResult(params.arg0);
					}
				},
		onAllNotesDeleted(com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy.class, "onAllNotesDeleted")
				{
					@Override
					public void apply(MainView mvpView, Object paramsObject)
					{
						mvpView.onAllNotesDeleted();
					}
				},
		onNoteDeleted(com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy.class, "onNoteDeleted")
				{
					@Override
					public void apply(MainView mvpView, Object paramsObject)
					{
						mvpView.onNoteDeleted();
					}
				},
		onPasSaved(com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy.class, "onPasSaved")
				{
					@Override
					public void apply(MainView mvpView, Object paramsObject)
					{
						mvpView.onPasSaved();
					}
				},
		showPas(com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy.class, "showPas")
				{
					@Override
					public void apply(MainView mvpView, Object paramsObject)
					{
						final ShowPasParams params = (ShowPasParams) paramsObject;
						mvpView.showPas(params.arg0);
					}
				},
		showNoteInfoDialog(com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy.class, "showNoteInfoDialog")
				{
					@Override
					public void apply(MainView mvpView, Object paramsObject)
					{
						final ShowNoteInfoDialogParams params = (ShowNoteInfoDialogParams) paramsObject;
						mvpView.showNoteInfoDialog(params.arg0);
					}
				},
		hideNoteInfoDialog(com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy.class, "hideNoteInfoDialog")
				{
					@Override
					public void apply(MainView mvpView, Object paramsObject)
					{
						mvpView.hideNoteInfoDialog();
					}
				},
		showNoteDeleteDialog(com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy.class, "showNoteDeleteDialog")
				{
					@Override
					public void apply(MainView mvpView, Object paramsObject)
					{
						final ShowNoteDeleteDialogParams params = (ShowNoteDeleteDialogParams) paramsObject;
						mvpView.showNoteDeleteDialog(params.arg0);
					}
				},
		hideNoteDeleteDialog(com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy.class, "hideNoteDeleteDialog")
				{
					@Override
					public void apply(MainView mvpView, Object paramsObject)
					{
						mvpView.hideNoteDeleteDialog();
					}
				},
		showNoteContextDialog(com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy.class, "showNoteContextDialog")
				{
					@Override
					public void apply(MainView mvpView, Object paramsObject)
					{
						final ShowNoteContextDialogParams params = (ShowNoteContextDialogParams) paramsObject;
						mvpView.showNoteContextDialog(params.arg0);
					}
				},
		hideNoteContextDialog(com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy.class, "hideNoteContextDialog")
				{
					@Override
					public void apply(MainView mvpView, Object paramsObject)
					{
						mvpView.hideNoteContextDialog();
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

	private class OnNotesLoadedParams
	{
		java.util.List<diplom.time.mvp.models.Note> arg0;

		OnNotesLoadedParams(java.util.List<diplom.time.mvp.models.Note> arg0)
		{
			this.arg0 = arg0;
		}
	}

	private class OnSearchResultParams
	{
		java.util.List<diplom.time.mvp.models.Note> arg0;

		OnSearchResultParams(java.util.List<diplom.time.mvp.models.Note> arg0)
		{
			this.arg0 = arg0;
		}
	}

	private class ShowPasParams
	{
		diplom.time.mvp.models.Pas arg0;

		ShowPasParams(diplom.time.mvp.models.Pas arg0)
		{
			this.arg0 = arg0;
		}
	}

	private class ShowNoteInfoDialogParams
	{
		java.lang.String arg0;

		ShowNoteInfoDialogParams(java.lang.String arg0)
		{
			this.arg0 = arg0;
		}
	}

	private class ShowNoteDeleteDialogParams
	{
		int arg0;

		ShowNoteDeleteDialogParams(int arg0)
		{
			this.arg0 = arg0;
		}
	}

	private class ShowNoteContextDialogParams
	{
		int arg0;

		ShowNoteContextDialogParams(int arg0)
		{
			this.arg0 = arg0;
		}
	}
}
