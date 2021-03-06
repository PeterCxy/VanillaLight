package net.typeblog.v2ex.model;

public class TopicModel
{
	public String title,
				topicId,
				nodeName,
				nodeId,
				creator,
				creatorAvatar,
				lastReplier,
				time;
	
	@Override
	public String toString() {
		return "title = " + title + "; " +
			"topicId = " + topicId + "; " +
			"nodeName = " + nodeName + "; " +
			"nodeId = " + nodeId + "; " +
			"creator = " + creator + "; " +
			"creatorAvatar = " + creatorAvatar + "; " +
			"lastReplier = " + lastReplier + "; " +
			"time = " + time;
	}
}
