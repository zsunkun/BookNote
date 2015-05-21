package com.example.booknote;

import com.example.adapter.CircleListAdapter;
import com.example.tools.BookData;

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
	private Button mWriteNote;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mView = inflater.inflate(R.layout.tab_circle, null);
		initElement();
		return mView;
	}

	private void initElement() {
		mListView = (ListView) mView.findViewById(R.id.circle_listview);
		mAdapter = new CircleListAdapter(BookData.getBookData(), getActivity());
		mListView.setAdapter(mAdapter);
		mWriteNote = (Button) mView.findViewById(R.id.button_write_note);
		mWriteNote.setOnClickListener(this);
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
