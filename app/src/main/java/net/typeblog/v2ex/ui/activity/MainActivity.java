package net.typeblog.v2ex.ui.activity;

import android.os.Bundle;

import net.typeblog.v2ex.R;
import net.typeblog.v2ex.ui.fragment.DiscoveryPagerFragment;

public class MainActivity extends ToolbarActivity
{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getSupportFragmentManager().beginTransaction().replace(R.id.frame, new DiscoveryPagerFragment()).commit();
	}

	@Override
	protected int getLayoutResource() {
		return R.layout.main;
	}
}
