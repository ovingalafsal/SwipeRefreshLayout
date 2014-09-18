package com.example.swipetorefresh;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends Activity
{
	private ReferencedSwipeRefreshLayout mReferencedSwipeRefreshLayout;
	private ListView mListView;
	private ArrayAdapter mArrayAdapter;
	private static final ArrayList<String> ANDROID_VERSIONS = new ArrayList<String> (Arrays.asList ("Donut", "Eclair", "Froyo", "Gingerbread", "Honeycomb", "Ice Cream Sandwich", "Jelly Bean", "Kit Kat", "Donut", "Eclair", "Froyo", "Gingerbread", "Honeycomb", "Ice Cream Sandwich", "Jelly Bean", "Kit Kat", "Donut", "Eclair", "Froyo", "Gingerbread", "Honeycomb", "Ice Cream Sandwich", "Jelly Bean", "Kit Kat"));

	private int i = 0;

	@Override
	protected void onCreate (Bundle savedInstanceState)
	{
		super.onCreate (savedInstanceState);
		setContentView (R.layout.activity_main);

		mReferencedSwipeRefreshLayout = (ReferencedSwipeRefreshLayout) findViewById (R.id.referenced_swipe_refresh_layout);
		mReferencedSwipeRefreshLayout.setOnRefreshListener (new ReferencedSwipeRefreshLayoutListener ());
		mReferencedSwipeRefreshLayout.setColorScheme (android.R.color.holo_green_light, android.R.color.holo_red_light, android.R.color.holo_blue_light, android.R.color.holo_orange_light);

		mListView = (ListView) findViewById (R.id.list_view);
		mListView.setEmptyView (findViewById (android.R.id.empty));
		mArrayAdapter = new ArrayAdapter (this, android.R.layout.simple_list_item_1, (ArrayList<String>) ANDROID_VERSIONS.clone ());
		mArrayAdapter.addAll ((ArrayList<String>) ANDROID_VERSIONS.clone ());
		mListView.setAdapter (mArrayAdapter);
	}


	private class ReferencedSwipeRefreshLayoutListener implements SwipeRefreshLayout.OnRefreshListener
	{
//		private boolean mShowVersions = false;


		@Override
		public void onRefresh ()
		{
			mReferencedSwipeRefreshLayout.setRefreshing (true);

//			if (mShowVersions)
//			{
//				mArrayAdapter.addAll ((ArrayList<String>) ANDROID_VERSIONS.clone ());
//			}
//			else
//			{
//				mArrayAdapter.clear ();
//			}

			mArrayAdapter.clear ();
			for(int j = i; j > 0; j--) {
				mArrayAdapter.add("new item added " + j);
			}
			i++;
			mArrayAdapter.addAll ((ArrayList<String>) ANDROID_VERSIONS.clone ());
			mArrayAdapter.notifyDataSetChanged ();
//			mShowVersions = !mShowVersions;

			mReferencedSwipeRefreshLayout.setRefreshing (false);
		}
	}
}
