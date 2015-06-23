package net.typeblog.v2ex.ui.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;

import net.typeblog.v2ex.R;

public class DiscoveryPagerFragment extends BasePagerFragment
{
	private Fragment[] mFragments = new Fragment[] {
		DiscoveryFragment.build("all"),
		DiscoveryFragment.build("creative"),
		DiscoveryFragment.build("tech"),
		DiscoveryFragment.build("play"),
		DiscoveryFragment.build("hot"),
	};

	@Override
	protected PagerAdapter buildAdapter() {
		final String[] titles = getResources().getStringArray(R.array.discover_titles);
		return new FragmentStatePagerAdapter(getChildFragmentManager()) {

			@Override
			public int getCount() {
				return mFragments.length;
			}

			@Override
			public Fragment getItem(int pos) {
				return mFragments[pos];
			}
			
			@Override
			public CharSequence getPageTitle(int pos) {
				return titles[pos];
			}

		};
	}
}
