package net.typeblog.v2ex.ui.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;

import net.typeblog.v2ex.R;
import static net.typeblog.v2ex.ui.UiHelper.*;

public abstract class ToolbarActivity extends AppCompatActivity
{
	protected abstract int getLayoutResource();

	protected AppBarLayout mAppBar;
	protected Toolbar mToolbar;
	protected TabLayout mTabs;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(getLayoutResource());
		
		// Find views
		mAppBar = $(this, R.id.appbar);
		mToolbar = $(this, R.id.toolbar);
		mTabs = $(this, R.id.tabs);
		
		if (mAppBar == null || mToolbar == null || mTabs == null) {
			throw new IllegalStateException("WTF? NO TOOLBAR!");
		}
		
		if (Build.VERSION.SDK_INT >= 21) {
			mAppBar.setElevation(10.8f);
		}
		
		setSupportActionBar(mToolbar);
	}
	
	protected void bindTabs(ViewPager pager) {
		mTabs.setVisibility(View.VISIBLE);
		mTabs.setupWithViewPager(pager);
	}
	
	protected void unbindTabs() {
		mTabs.setupWithViewPager(null);
		mTabs.setVisibility(View.GONE);
	}
	
}
