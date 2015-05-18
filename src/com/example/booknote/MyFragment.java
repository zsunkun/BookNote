package com.example.booknote;

import com.example.adapter.MyNoteListAdapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class MyFragment extends Fragment {
	private View mView;
	private ListView mListView;
	private BaseAdapter mAdapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mView = inflater.inflate(R.layout.tab_my, container, false);
		mListView = (ListView) mView.findViewById(R.id.my_note_listview);
		mAdapter = new MyNoteListAdapter(CircleFrament.mData, getActivity());
		mListView.setAdapter(mAdapter);
		return mView;
	}

}
