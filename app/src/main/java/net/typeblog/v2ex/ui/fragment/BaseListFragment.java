package net.typeblog.v2ex.ui.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import net.typeblog.v2ex.R;
import static net.typeblog.v2ex.ui.UiHelper.*;

public abstract class BaseListFragment<A extends RecyclerView.Adapter, M extends RecyclerView.LayoutManager, I> extends Fragment
{
	protected abstract A getAdapter(List<I> list);
	protected abstract M getLayoutManager();
	protected abstract List<I> doLoad(boolean more);
	
	protected RecyclerView mRecycler;
	protected A mAdapter;
	protected M mManager;
	protected List<I> mList = new ArrayList<>();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.list, container, false);
		
		mRecycler = $(v, R.id.list);
		mAdapter = getAdapter(mList);
		mManager = getLayoutManager();
		mRecycler.setAdapter(mAdapter);
		mRecycler.setLayoutManager(mManager);
		
		new RefreshTask().execute(false);
		
		return v;
	}
	
	private class RefreshTask extends AsyncTask<Boolean, Void, List<I>> {

		boolean more;
		
		@Override
		protected List<I> doInBackground(Boolean... params) {
			more = params[0];
			return doLoad(more);
		}

		@Override
		protected void onPostExecute(List<I> result) {
			super.onPostExecute(result);
			
			if (!more) {
				mList.clear();
			}
			
			if (result != null) {
				mList.addAll(result);
			}
			
			mAdapter.notifyDataSetChanged();
		}
	}

}
