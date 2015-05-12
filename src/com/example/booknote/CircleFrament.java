package com.example.booknote;

import java.util.List;

import org.json.JSONObject;

import com.example.adapter.CircleListAdapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class CircleFrament extends Fragment {
	private View mView;
	private ListView mListView;
	private BaseAdapter mAdapter;
	private List<JSONObject> mData;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mView = inflater.inflate(R.layout.tab_circle, null);
		initElement();
		return mView;
	}

	private void initElement() {
		initData();
		mListView = (ListView) mView.findViewById(R.id.circle_listview);
		mAdapter = new CircleListAdapter(mData);
		mListView.setAdapter(mAdapter);
	}

	private void initData() {
	}

}
