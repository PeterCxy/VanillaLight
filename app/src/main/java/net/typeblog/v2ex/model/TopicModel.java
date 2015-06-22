package net.typeblog.v2ex.model;

public class TopicModel
{
	public String title,
				topicId,
				nodeName,
				nodeId,
				creator,
				lastReplier,
				time;
	
	@Override
	public String toString() {
		return "title = " + title + "; " +
			"topicId = " + topicId + "; " +
			"nodeName = " + nodeName + "; " +
			"nodeId = " + nodeId + "; " +
			"creator = " + creator + "; " +
			"lastReplier = " + lastReplier + "; " +
			"time = " + time;
	}
}
