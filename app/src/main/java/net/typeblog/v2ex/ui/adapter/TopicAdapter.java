package net.typeblog.v2ex.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;

import com.squareup.picasso.Picasso;

import java.util.List;

import net.typeblog.v2ex.R;
import net.typeblog.v2ex.model.TopicModel;
import static net.typeblog.v2ex.ui.UiHelper.*;

public class TopicAdapter extends Adapter<TopicAdapter.ViewHolder>
{
	private Context mContext;
	private LayoutInflater mInflater;
	private List<TopicModel> mList;
	
	public TopicAdapter(Context context, List<TopicModel> list) {
		mContext = context;
		mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mList = list;
	}

	@Override
	public int getItemCount() {
		return mList.size();
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup container, int type) {
		View v = mInflater.inflate(R.layout.topic_item, container, false);
		return new ViewHolder(v);
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		TopicModel topic = mList.get(position);
		
		holder.creator.setText(topic.creator);
		holder.node.setText(String.format(mContext.getString(R.string.node_format), topic.nodeName));
		holder.title.setText(topic.title);
		holder.extra.setText(String.format(mContext.getString(R.string.extra_format), topic.time, topic.lastReplier));
		
		Picasso.with(mContext)
			.load(topic.creatorAvatar)
			.fit()
			.centerCrop()
			.into(holder.avatar);
	}
	
	static class ViewHolder extends RecyclerView.ViewHolder {
		ImageView avatar;
		TextView creator;
		TextView node;
		TextView title;
		TextView extra;
		
		ViewHolder(View v) {
			super(v);
			
			avatar = $(v, R.id.topic_avatar);
			creator = $(v, R.id.topic_creator);
			node = $(v, R.id.topic_node);
			title = $(v, R.id.topic_title);
			extra = $(v, R.id.topic_extra);
			
			node.getPaint().setFakeBoldText(true);
		}
	}
}
