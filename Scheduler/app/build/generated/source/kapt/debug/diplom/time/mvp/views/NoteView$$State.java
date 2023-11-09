package diplom.time.mvp.views;

import com.arellomobile.mvp.viewstate.MvpViewState;
import com.arellomobile.mvp.viewstate.ViewCommand;
import com.arellomobile.mvp.viewstate.ViewCommands;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategy;

public class NoteView$$State extends MvpViewState<NoteView> implements NoteView
{
	private ViewCommands<NoteView> mViewCommands = new ViewCommands<>();

	@Override
	public void restoreState(NoteView view)
	{
		if (mViewCommands.isEmpty())
		{
			return;
		}

		mViewCommands.reapply(view);
	}

	@Override
	public void showNote(diplom.time.mvp.models.Note arg0)
	{
		ShowNoteParams params = new ShowNoteParams(arg0);
		mViewCommands.beforeApply(LocalViewCommand.showNote, params);

		if (mViews == null || mViews.isEmpty())
		{
			return;
		}

		for(NoteView view : mViews)
		{
			view.showNote(arg0);
		}

		mViewCommands.afterApply(LocalViewCommand.showNote, params);
	}

	@Override
	public void onNoteSaved()
	{
		Void params = null;
		mViewCommands.beforeApply(LocalViewCommand.onNoteSaved, params);

		if (mViews == null || mViews.isEmpty())
		{
			return;
		}

		for(NoteView view : mViews)
		{
			view.onNoteSaved();
		}

		mViewCommands.afterApply(LocalViewCommand.onNoteSaved, params);
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

		for(NoteView view : mViews)
		{
			view.updateView();
		}

		mViewCommands.afterApply(LocalViewCommand.updateView, params);
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

		for(NoteView view : mViews)
		{
			view.onNoteDeleted();
		}

		mViewCommands.afterApply(LocalViewCommand.onNoteDeleted, params);
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

		for(NoteView view : mViews)
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

		for(NoteView view : mViews)
		{
			view.hideNoteInfoDialog();
		}

		mViewCommands.afterApply(LocalViewCommand.hideNoteInfoDialog, params);
	}

	@Override
	public void showNoteDeleteDialog()
	{
		Void params = null;
		mViewCommands.beforeApply(LocalViewCommand.showNoteDeleteDialog, params);

		if (mViews == null || mViews.isEmpty())
		{
			return;
		}

		for(NoteView view : mViews)
		{
			view.showNoteDeleteDialog();
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

		for(NoteView view : mViews)
		{
			view.hideNoteDeleteDialog();
		}

		mViewCommands.afterApply(LocalViewCommand.hideNoteDeleteDialog, params);
	}

	private enum LocalViewCommand implements ViewCommand<NoteView>
	{
		showNote(com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy.class, "showNote")
				{
					@Override
					public void apply(NoteView mvpView, Object paramsObject)
					{
						final ShowNoteParams params = (ShowNoteParams) paramsObject;
						mvpView.showNote(params.arg0);
					}
				},
		onNoteSaved(com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy.class, "onNoteSaved")
				{
					@Override
					public void apply(NoteView mvpView, Object paramsObject)
					{
						mvpView.onNoteSaved();
					}
				},
		updateView(com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy.class, "updateView")
				{
					@Override
					public void apply(NoteView mvpView, Object paramsObject)
					{
						mvpView.updateView();
					}
				},
		onNoteDeleted(com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy.class, "onNoteDeleted")
				{
					@Override
					public void apply(NoteView mvpView, Object paramsObject)
					{
						mvpView.onNoteDeleted();
					}
				},
		showNoteInfoDialog(com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy.class, "showNoteInfoDialog")
				{
					@Override
					public void apply(NoteView mvpView, Object paramsObject)
					{
						final ShowNoteInfoDialogParams params = (ShowNoteInfoDialogParams) paramsObject;
						mvpView.showNoteInfoDialog(params.arg0);
					}
				},
		hideNoteInfoDialog(com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy.class, "hideNoteInfoDialog")
				{
					@Override
					public void apply(NoteView mvpView, Object paramsObject)
					{
						mvpView.hideNoteInfoDialog();
					}
				},
		showNoteDeleteDialog(com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy.class, "showNoteDeleteDialog")
				{
					@Override
					public void apply(NoteView mvpView, Object paramsObject)
					{
						mvpView.showNoteDeleteDialog();
					}
				},
		hideNoteDeleteDialog(com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy.class, "hideNoteDeleteDialog")
				{
					@Override
					public void apply(NoteView mvpView, Object paramsObject)
					{
						mvpView.hideNoteDeleteDialog();
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

	private class ShowNoteParams
	{
		diplom.time.mvp.models.Note arg0;

		ShowNoteParams(diplom.time.mvp.models.Note arg0)
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
}
