package com.example.adapter;

import java.util.List;

import org.json.JSONObject;

import com.example.adapter.CircleListAdapter.ViewHolder;
import com.example.booknote.BookDetailActivity;
import com.example.booknote.R;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyNoteListAdapter extends BaseAdapter {

	private List<JSONObject> mData;
	private Context mContext;

	public MyNoteListAdapter(List<JSONObject> data, Context context) {
		mData = data;
		mContext = context;
	}

	@Override
	public int getCount() {
		if (mData == null)
			return 0;
		return mData.size();
	}

	@Override
	public Object getItem(int position) {
		if (mData == null)
			return null;
		return mData.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder viewHolder;
		final JSONObject json = (JSONObject) getItem(position);
		Resources resources = parent.getContext().getResources();
		if (json == null)
			return null;
		if (convertView == null) {
			LayoutInflater inflater = LayoutInflater.from(parent.getContext());
			convertView = inflater.inflate(R.layout.item_my_note_list, null);
			viewHolder = new ViewHolder();
			viewHolder.mAction = (TextView) convertView
					.findViewById(R.id.text_action);
			viewHolder.mTime = (TextView) convertView
					.findViewById(R.id.text_time);
			viewHolder.mText = (TextView) convertView
					.findViewById(R.id.text_content);
			viewHolder.mMore = (TextView) convertView
					.findViewById(R.id.text_more);
			viewHolder.mFrom = (LinearLayout) convertView
					.findViewById(R.id.item_from);
			viewHolder.mBookName = (TextView) convertView
					.findViewById(R.id.item_book_name);
			viewHolder.mPageCount = (TextView) convertView
					.findViewById(R.id.text_page_count);
			viewHolder.mLinkCard = (LinearLayout) convertView
					.findViewById(R.id.item_card);
			viewHolder.mBookImage = (ImageView) convertView
					.findViewById(R.id.item_book_image);
			viewHolder.mCardBookName = (TextView) convertView
					.findViewById(R.id.item_card_book_name);
			viewHolder.mCardBookAuthor = (TextView) convertView
					.findViewById(R.id.item_card_book_author);
			viewHolder.mCardBookPublish = (TextView) convertView
					.findViewById(R.id.item_card_book_publish);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}

		try {
			viewHolder.mAction.setText(resources.getString(R.string.action,
					json.getString("action")));
			viewHolder.mTime.setText(json.getString("time"));
			viewHolder.mText.setText(json.getString("text"));
			viewHolder.mMore.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					viewHolder.mText.setMaxLines(100);
					viewHolder.mMore.setVisibility(View.GONE);
				}
			});
			boolean isShowCard = json.getBoolean("showCard");
			if (isShowCard) {
				viewHolder.mLinkCard.setVisibility(View.VISIBLE);
				viewHolder.mFrom.setVisibility(View.GONE);
				viewHolder.mBookImage.setBackgroundDrawable(resources
						.getDrawable(json.getInt("bookImage")));
				viewHolder.mCardBookAuthor.setText(resources.getString(
						R.string.card_book_author,
						json.getString("cardBookAuthor")));
				viewHolder.mCardBookName
						.setText(json.getString("cardBookName"));
				viewHolder.mCardBookPublish.setText(resources.getString(
						R.string.card_book_publish,
						json.getString("cardBookPublish")));
			} else {
				viewHolder.mLinkCard.setVisibility(View.GONE);
				viewHolder.mFrom.setVisibility(View.VISIBLE);
				viewHolder.mBookName.setText(json.getString("bookName"));
				viewHolder.mPageCount.setText(resources.getString(
						R.string.page_count, json.getString("pageCount")));
				viewHolder.mBookName.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						Intent intent = new Intent(mContext,
								BookDetailActivity.class);
						Bundle bundle = new Bundle();
						intent.putExtra("json", json.toString());
						mContext.startActivity(intent);
					}
				});
			}
		} catch (Exception e) {
		}
		return convertView;
	}

	static class ViewHolder {
		public TextView mTime;
		public TextView mAction;
		public TextView mText;
		public TextView mMore;
		public LinearLayout mFrom;
		public TextView mBookName;
		public TextView mPageCount;
		public LinearLayout mLinkCard;
		public ImageView mBookImage;
		public TextView mCardBookName;
		public TextView mCardBookAuthor;
		public TextView mCardBookPublish;
	}
}
