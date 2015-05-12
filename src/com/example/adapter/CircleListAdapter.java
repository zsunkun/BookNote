package com.example.adapter;

import java.util.List;

import org.json.JSONObject;

import com.example.booknote.R;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CircleListAdapter extends BaseAdapter implements OnClickListener {

	private List<JSONObject> mData;

	public CircleListAdapter(List<JSONObject> data) {
		mData = data;
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
		ViewHolder viewHolder = null;
		JSONObject json = (JSONObject) getItem(position);
		Resources resources = parent.getContext().getResources();
		if (json == null)
			return null;
		if (convertView == null) {
			LayoutInflater inflater = LayoutInflater.from(parent.getContext());
			convertView = inflater.inflate(R.layout.item_circle_list, null);
			viewHolder = new ViewHolder();
			viewHolder.mHeadImage = (ImageView) convertView
					.findViewById(R.id.img_headimage);
			viewHolder.mName = (TextView) convertView
					.findViewById(R.id.item_name);
			viewHolder.mAction = (TextView) convertView
					.findViewById(R.id.item_action);
			viewHolder.mTime = (TextView) convertView
					.findViewById(R.id.item_time);
			viewHolder.mText = (TextView) convertView
					.findViewById(R.id.item_text);
			viewHolder.mFrom = (LinearLayout) convertView
					.findViewById(R.id.item_from);
			viewHolder.mBookName = (TextView) convertView
					.findViewById(R.id.item_book_name);
			viewHolder.mPageCount = (TextView) convertView
					.findViewById(R.id.item_page_count);
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
			viewHolder.mAttention = (Button) convertView
					.findViewById(R.id.item_attention);
			viewHolder.mShare = (ImageView) convertView
					.findViewById(R.id.item_share);
			viewHolder.mCommment = (ImageView) convertView
					.findViewById(R.id.item_comment);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		try {
			viewHolder.mHeadImage.setBackgroundDrawable(resources
					.getDrawable((int) json.get("headImage")));
			viewHolder.mName.setText(json.getString("name"));
			viewHolder.mAction.setText(resources.getString(R.string.action,
					json.getString("action")));
			viewHolder.mTime.setText(json.getString("time"));
			viewHolder.mText.setText(json.getString("text"));
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
				viewHolder.mAttention.setOnClickListener(this);
			} else {
				viewHolder.mLinkCard.setVisibility(View.GONE);
				viewHolder.mFrom.setVisibility(View.VISIBLE);
				viewHolder.mBookName.setText(json.getString("bookName"));
				viewHolder.mPageCount.setText(resources.getString(
						R.string.page_count, json.getString("pageCount")));
				viewHolder.mBookName.setOnClickListener(this);
				viewHolder.mShare.setOnClickListener(this);
				viewHolder.mCommment.setOnClickListener(this);
			}
		} catch (Exception e) {
		}
		return convertView;
	}

	static class ViewHolder {
		public ImageView mHeadImage;
		public TextView mName;
		public TextView mAction;
		public TextView mTime;
		public TextView mText;
		public LinearLayout mFrom;
		public TextView mBookName;
		public TextView mPageCount;
		public LinearLayout mLinkCard;
		public ImageView mBookImage;
		public TextView mCardBookName;
		public TextView mCardBookAuthor;
		public TextView mCardBookPublish;
		public Button mAttention;
		public ImageView mShare;
		public ImageView mCommment;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}
}
