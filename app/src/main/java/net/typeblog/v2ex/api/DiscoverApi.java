package net.typeblog.v2ex.api;

import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import net.typeblog.v2ex.model.TopicModel;
import net.typeblog.v2ex.support.HttpParameters;
import net.typeblog.v2ex.support.HttpUtility;
import static net.typeblog.v2ex.BuildConfig.DEBUG;
import static net.typeblog.v2ex.api.ApiCommon.*;
import static net.typeblog.v2ex.api.Constants.*;
import static net.typeblog.v2ex.support.Utility.*;

public class DiscoverApi
{
	private static final String TAG = DiscoverApi.class.getSimpleName();
	
	public static List<TopicModel> getDiscoverTopocs(String tab) {
		String html = HttpUtility.request(
			DISCOVER,
			new HttpParameters.Builder()
				.add("tab", tab)
				.build(),
			null, null);
		
		if (html == null || html.trim().equals("")) {
			return null;
		}
		
		if (DEBUG) {
			Log.d(TAG, html);
		}
		
		Document doc = Jsoup.parse(html);
		
		Elements items = doc.getElementsByClass("item");
		
		if (DEBUG) {
			Log.d(TAG, "item count " + items.size());
		}
		
		List<TopicModel> list = parseTopics(items);
		
		if (DEBUG) {
			debugList(TAG, list);
		}
		
		return list;
	}
}
