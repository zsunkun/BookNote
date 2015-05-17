package com.example.booknote;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class BookDetailActivity extends Activity implements OnClickListener {

	private ImageButton mReturn;
	private ImageButton mShare;
	private TextView mBookName;
	private ImageView mBookPic;
	private TextView mBookAuthor;
	private TextView mBookPuslish;
	private TextView mBookDetail;
	private JSONObject mData;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_book_detail);
		String data = getIntent().getStringExtra("json");
		try {
			mData = new JSONObject(data);
		} catch (JSONException e) {
			finish();
		}
		if (mData == null)
			finish();
		initElement();
		initContent();
	}

	private void initContent() {
		try {
			mBookName.setText(mData.getString("cardBookName"));
			mBookPic.setBackgroundDrawable(getResources().getDrawable(
					mData.getInt("bookImage")));
			mBookAuthor.setText(getResources().getString(
					R.string.card_book_author,
					mData.getString("cardBookAuthor")));
			mBookPuslish.setText(getResources().getString(
					R.string.card_book_publish,
					mData.getString("cardBookPublish")));
			mBookDetail.setText(getResources().getString(
					R.string.book_short_introduce, mData.get("bookDetail")));
		} catch (JSONException e) {
		}
	}

	private void initElement() {
		mReturn = (ImageButton) findViewById(R.id.button_return);
		mReturn.setOnClickListener(this);
		mShare = (ImageButton) findViewById(R.id.button_share);
		mShare.setOnClickListener(this);
		mBookName = (TextView) findViewById(R.id.text_book_name);
		mBookPic = (ImageView) findViewById(R.id.img_book_pic);
		mBookAuthor = (TextView) findViewById(R.id.text_book_author);
		mBookPuslish = (TextView) findViewById(R.id.text_book_publish);
		mBookDetail = (TextView) findViewById(R.id.text_book_detail);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button_return:
			finish();
			break;
		case R.id.button_share:
			// TODO onShare;
			break;

		default:
			break;
		}
	}

}
