package net.typeblog.v2ex.ui.activity;

import android.os.Bundle;

import net.typeblog.v2ex.R;
import net.typeblog.v2ex.ui.fragment.DiscoveryFragment;

public class MainActivity extends ToolbarActivity
{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getSupportFragmentManager().beginTransaction().replace(R.id.frame, DiscoveryFragment.build("creative")).commit();
	}

	@Override
	protected int getLayoutResource() {
		return R.layout.main;
	}
}
