package com.example.adapter;

import com.example.booknote.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CommentListAdapter extends BaseAdapter {

	private int mPosition = 3;
	private Context mContext;

	public CommentListAdapter(Context context) {
		mContext = context;
	}

	@Override
	public int getCount() {
		return mPosition + 1;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		convertView = LayoutInflater.from(mContext).inflate(
				R.layout.item_comment_list, null);
		TextView textCount = (TextView) convertView
				.findViewById(R.id.text_count);
		textCount.setText(String.valueOf(position + 1));
		TextView textDeleteOrAdd = (TextView) convertView
				.findViewById(R.id.button_delete_or_add);
		if (position == mPosition)
			textDeleteOrAdd.setText("+");
		else
			textDeleteOrAdd.setText("-");
		textDeleteOrAdd.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (position == mPosition)
					mPosition++;
				else
					mPosition--;
				notifyDataSetChanged();
			}
		});
		return convertView;
	}

}
