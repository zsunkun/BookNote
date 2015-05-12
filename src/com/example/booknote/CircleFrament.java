package com.example.booknote;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
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
	private List<JSONObject> mData = new ArrayList<JSONObject>();

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
		try {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("headImage", R.drawable.ic_circle_indicator);
			jsonObject.put("name", "吉米");
			jsonObject.put("action", "摘抄");
			jsonObject.put("time", "5分钟前");
			jsonObject.put("text", "1、每个人都有自己的青春往事\n2、黄渡高严寒和漫长的春天眼看就要过去了");
			jsonObject.put("showCard", false);
			jsonObject.put("bookName", "《平凡的世界》");
			jsonObject.put("pageCount", "2");
			mData.add(jsonObject);
			JSONObject jsonObject2 = new JSONObject();
			jsonObject2.put("headImage", R.drawable.ic_circle_indicator);
			jsonObject2.put("name", "吉米");
			jsonObject2.put("action", "摘抄");
			jsonObject2.put("time", "5分钟前");
			jsonObject2.put("text", "1、每个人都有自己的青春往事\n2、黄渡高严寒和漫长的春天眼看就要过去了");
			jsonObject2.put("showCard", true);
			jsonObject2.put("bookImage", R.drawable.iconfont_faxian);
			jsonObject2.put("cardBookAuthor", "路遥");
			jsonObject2.put("cardBookName", "平凡的世界");
			jsonObject2.put("cardBookPublish", "中信出版社");
			mData.add(jsonObject2);
		} catch (JSONException e) {
		}
	}

}
