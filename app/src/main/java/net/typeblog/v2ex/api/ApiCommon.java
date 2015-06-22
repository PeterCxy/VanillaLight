package net.typeblog.v2ex.api;

import android.util.Log;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import net.typeblog.v2ex.model.TopicModel;
import static net.typeblog.v2ex.BuildConfig.DEBUG;

public class ApiCommon
{
	private static final String TAG = ApiCommon.class.getSimpleName();
	
	public static String parseTopicUrl(String url) {
		return getStringBetween(url, "/t/", "#");
	}
	
	public static String parseNodeUrl(String url) {
		return getStringBetween(url, "/go/", null);
	}
	
	public static String getStringBetween(String str, String start, String end) {
		int indexStart = 0;
		if (start != null) {
			indexStart = str.indexOf(start);
			if (indexStart < 0) indexStart = 0;
			else indexStart += start.length();
		}
		
		int indexEnd = str.length();
		if (end != null) {
			indexEnd = str.indexOf(end);
			
			if (indexEnd < 0) {
				indexEnd = str.length();
			}
		}
		
		if (DEBUG) {
			Log.d(TAG, "start " + indexStart + " end " + indexEnd);
		}
		
		if (indexEnd > indexStart) {
			return str.substring(indexStart, indexEnd);
		} else {
			return "";
		}
	}
	
	public static List<TopicModel> parseTopics(Elements cells) {
		List<TopicModel> list = new ArrayList<>();
		
		for (Element item : cells) {
			if (!item.hasClass("cell")) {
				continue;
			}

			TopicModel topic = new TopicModel();

			// Get the node link
			Elements nodes = item.getElementsByClass("node");
			if (nodes == null || nodes.size() == 0) {
				continue;
			}
			Element node = nodes.get(0);
			topic.nodeName = node.text();
			topic.nodeId = parseNodeUrl(node.attr("href"));

			// Item title
			Elements titles = item.getElementsByClass("item_title");
			if (titles == null || titles.size() == 0) {
				continue;
			}
			Element title = titles.get(0);
			Elements links = title.getElementsByTag("a");
			if (links == null || links.size() == 0) {
				continue;
			}
			Element link = links.get(0);
			topic.title = link.text();
			topic.topicId = parseTopicUrl(link.attr("href"));
			
			// Creator
			Elements fades = item.getElementsByClass("fade");
			if (fades == null || fades.size() == 0) {
				continue;
			}
			Element firstFade = fades.get(0);
			Elements strongs = firstFade.getElementsByTag("strong");
			if (strongs == null || strongs.size() == 0) {
				continue;
			}
			Element strong = strongs.get(0);
			links = strong.getElementsByTag("a");
			if (links != null && links.size() > 0) {
				topic.creator = links.get(0).text();
			} else {
				topic.creator = strong.text();
			}
			
			// Last Replier & time
			if (fades.size() > 1) {
				Element secondFade = fades.get(1);
				String text = secondFade.text();
				topic.time = getStringBetween(text, null, "•").trim();
				topic.lastReplier = getStringBetween(text, "最后回复", null).trim();
			}

			list.add(topic);
		}
		
		return list;
	}
}
