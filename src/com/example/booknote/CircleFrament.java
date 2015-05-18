package com.example.booknote;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.example.adapter.CircleListAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;

public class CircleFrament extends Fragment implements OnClickListener {
	private View mView;
	private ListView mListView;
	private BaseAdapter mAdapter;
	public static List<JSONObject> mData = new ArrayList<JSONObject>();
	private Button mWriteNote;

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
		mAdapter = new CircleListAdapter(mData, getActivity());
		mListView.setAdapter(mAdapter);
		mWriteNote = (Button) mView.findViewById(R.id.button_write_note);
		mWriteNote.setOnClickListener(this);
	}

	private void initData() {
		try {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("headImage", R.drawable.ic_circle_indicator);
			jsonObject.put("name", "吉米");
			jsonObject.put("action", "摘抄");
			jsonObject.put("time", "5分钟前");
			jsonObject.put("text", "1、每个人都有自己的青春往事\n2、黄渡高严寒和漫长的春天眼看就要过去了\n3、黄渡高严寒和漫长的春天眼看就要过去了");
			jsonObject.put("showCard", false);
			jsonObject.put("bookImage", R.drawable.iconfont_faxian);
			jsonObject.put("cardBookAuthor", "路遥");
			jsonObject.put("cardBookName", "平凡的世界");
			jsonObject.put("cardBookPublish", "中信出版社");
			jsonObject.put("bookName", "《平凡的世界》");
			jsonObject.put("pageCount", "2");
			jsonObject.put("bookDetail", "平凡的世界是一部激励了一代代中国年轻人的作品。作者路遥...");
			mData.add(jsonObject);
			JSONObject jsonObject2 = new JSONObject();
			jsonObject2.put("headImage", R.drawable.ic_circle_indicator);
			jsonObject2.put("name", "吉米");
			jsonObject2.put("action", "摘抄");
			jsonObject2.put("time", "5分钟前");
			jsonObject2.put("text", "1、每个人都有自己的青春往事\n2、黄渡高严寒和漫长的春天眼看就要过去了\n3、黄渡高严寒和漫长的春天眼看就要过去了");
			jsonObject2.put("showCard", true);
			jsonObject2.put("bookImage", R.drawable.iconfont_faxian);
			jsonObject2.put("cardBookAuthor", "路遥");
			jsonObject2.put("cardBookName", "平凡的世界");
			jsonObject2.put("cardBookPublish", "中信出版社");
			jsonObject.put("bookName", "《平凡的世界》");
			jsonObject.put("pageCount", "2");
			jsonObject.put("bookDetail", "平凡的世界是一部激励了一代代中国年轻人的作品。作者路遥...");
			mData.add(jsonObject2);
		} catch (JSONException e) {
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button_write_note:
			startActivity(new Intent(getActivity(), WriteNoteMaskActivity.class));
			break;

		default:
			break;
		}
	}

}
