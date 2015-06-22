package net.typeblog.v2ex.support;

import android.util.Log;

import java.util.List;

public class Utility
{
	public static <T> void debugList(String tag, List<T> list) {
		Log.d(tag, "--- List Debugging ---");
		for (T item : list) {
			Log.d(tag, item.toString());
		}
		Log.d(tag, "--- The End ---");
	}
}
