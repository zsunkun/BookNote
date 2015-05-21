package com.example.booknote;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class WriteNoteMaskActivity extends Activity implements OnClickListener {

	private ImageButton mWriteNote;
	private ImageButton mWriteAbstract;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_write_note_mask);
		mWriteNote = (ImageButton) findViewById(R.id.button_write_note);
		mWriteAbstract = (ImageButton) findViewById(R.id.button_write_abstract);
		mWriteNote.setOnClickListener(this);
		mWriteAbstract.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button_write_note:
			Intent intent = new Intent(this, WriteActivity.class);
			intent.putExtra(WriteActivity.EXTRA_IS_COMMENT, false);
			startActivity(intent);
			finish();
			break;
		case R.id.button_write_abstract:
			Intent intentTwo = new Intent(this, WriteActivity.class);
			intentTwo.putExtra(WriteActivity.EXTRA_IS_COMMENT, true);
			startActivity(intentTwo);
			finish();
			break;
		default:
			break;
		}
	}
}
