package net.typeblog.v2ex.ui.fragment;

import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;

import java.util.List;

import net.typeblog.v2ex.api.DiscoverApi;
import net.typeblog.v2ex.model.TopicModel;
import net.typeblog.v2ex.ui.adapter.TopicAdapter;

public class DiscoveryFragment extends BaseListFragment<TopicAdapter, LinearLayoutManager, TopicModel>
{
	public static final String CATEGORY = "category";

	public static DiscoveryFragment build(String category) {
		DiscoveryFragment ret = new DiscoveryFragment();
		Bundle arg = new Bundle();
		arg.putString(CATEGORY, category);
		ret.setArguments(arg);
		return ret;
	}
	
	@Override
	protected TopicAdapter getAdapter(List<TopicModel> list) {
		return new TopicAdapter(getActivity(), list);
	}

	@Override
	protected LinearLayoutManager getLayoutManager() {
		return new LinearLayoutManager(getActivity());
	}

	@Override
	protected List<TopicModel> doLoad(boolean more) {
		// TODO Load more or do not allow load more
		return DiscoverApi.getDiscoverTopics(getArguments().getString(CATEGORY));
	}

}
