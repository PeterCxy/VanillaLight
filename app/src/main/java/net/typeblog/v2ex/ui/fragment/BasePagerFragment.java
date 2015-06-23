package net.typeblog.v2ex.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import net.typeblog.v2ex.R;
import net.typeblog.v2ex.ui.activity.ToolbarActivity;
import static net.typeblog.v2ex.ui.UiHelper.*;

public abstract class BasePagerFragment extends Fragment
{
	protected abstract PagerAdapter buildAdapter();

	protected ViewPager mPager;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.pager, container, false);
		
		mPager = $(v, R.id.pager);
		mPager.setOffscreenPageLimit(Integer.MAX_VALUE);
		
		return v;
	}

	@Override
	public void onStart() {
		super.onStart();
		mPager.setAdapter(buildAdapter());
		
		if (getActivity() instanceof ToolbarActivity) {
			((ToolbarActivity) getActivity()).bindTabs(mPager);
		}
	}
	
}
