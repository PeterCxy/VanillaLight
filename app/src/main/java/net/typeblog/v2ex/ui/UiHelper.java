package net.typeblog.v2ex.ui;

import android.app.Activity;
import android.view.View;

public class UiHelper
{
	public static final <T extends View> T $(Activity activity, int id) {
		return (T) activity.findViewById(id);
	}
	
	public static final <T extends View> T $(View v, int id) {
		return (T) v.findViewById(id);
	}
}
