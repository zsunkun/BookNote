package com.example.booknote;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.adapter.CommentListAdapter;
import com.example.tools.BookInfo;
import com.example.tools.Util;

public class WriteActivity extends Activity implements OnClickListener {

	public static final String EXTRA_IS_COMMENT = "extras_is_comment";
	private final static int SCANNIN_GREQUEST_CODE = 1;
	private boolean isComment;

	private ImageButton mButtonRelease;
	private ListView mListView;
	private BaseAdapter mAdapter;
	private TextView mTitle;
	private LinearLayout mFromContainer;
	private ImageView mScan;
	private View mFooterView;
	private ImageButton mButtonReturn;
	private EditText mEditBookName;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_write_note);
		isComment = getIntent().getBooleanExtra(EXTRA_IS_COMMENT, false);
		initElement();
	}

	private void initElement() {
		mFooterView = getLayoutInflater().inflate(
				R.layout.view_comment_list_footer_view, null);
		mButtonRelease = (ImageButton) findViewById(R.id.button_return);
		mButtonRelease.setOnClickListener(this);
		mTitle = (TextView) findViewById(R.id.text_write_title);
		mFromContainer = (LinearLayout) mFooterView
				.findViewById(R.id.container_from);
		if (isComment) {
			mFromContainer.setVisibility(View.INVISIBLE);
			mTitle.setText("写评论");
		} else {
			mFromContainer.setVisibility(View.VISIBLE);
			mTitle.setText("写摘抄");
		}
		mScan = (ImageView) mFooterView.findViewById(R.id.image_scan);
		mScan.setOnClickListener(this);
		mListView = (ListView) findViewById(R.id.comment_list);
		mListView.addFooterView(mFooterView);
		mAdapter = new CommentListAdapter(this);
		mListView.setAdapter(mAdapter);
		mButtonReturn = (ImageButton) findViewById(R.id.button_return);
		mEditBookName = (EditText) findViewById(R.id.edit_book_name);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		switch (requestCode) {
		case SCANNIN_GREQUEST_CODE:
			if (resultCode == RESULT_OK) {
				Bundle bundle = data.getExtras();
				String result = bundle.getString("result");
				if (result != null && result.length() > 0)
					new GetBookTitleTask(result, mEditBookName).execute();
			}
			break;
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button_return:
			finish();
			break;
		case R.id.image_scan:
			Intent intent = new Intent();
			intent.setClass(this, MipcaActivityCapture.class);
			startActivityForResult(intent, SCANNIN_GREQUEST_CODE);
			break;
		default:
			break;
		}
	}

	private class GetBookTitleTask extends AsyncTask<Void, Void, String> {

		private String mUrl = "https://api.douban.com/v2/book/isbn/";
		private EditText mEdit;

		public GetBookTitleTask(String url) {
			mUrl = mUrl + url;
		}

		public GetBookTitleTask(String url, EditText editText) {
			mUrl = mUrl + url;
			mEdit = editText;
		}

		@Override
		protected String doInBackground(Void... params) {
			String result = Util.Download(mUrl);
			BookInfo book = new Util().parseBookInfo(result);
			return book.getTitle();
		}

		@Override
		protected void onPostExecute(String result) {
			if (result == null)
				return;
			if (mEdit == null)
				System.out.println("---" + result);
			else
				mEdit.setText(result);

		}
	}
}
