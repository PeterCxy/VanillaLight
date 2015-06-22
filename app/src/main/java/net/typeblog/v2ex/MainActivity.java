package net.typeblog.v2ex;

import android.app.*;
import android.os.*;

import java.util.List;

import net.typeblog.v2ex.api.DiscoverApi;
import net.typeblog.v2ex.model.TopicModel;

public class MainActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		new TestTask().execute();
    }
	
	private class TestTask extends AsyncTask<Void, Void, List<TopicModel>>
	{

		@Override
		protected List<TopicModel> doInBackground(Void... params)
		{
			return DiscoverApi.getDiscoverTopocs("tech");
		}

	}
}
