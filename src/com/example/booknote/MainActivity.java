package com.example.booknote;

import java.util.ArrayList;
import java.util.List;

import com.example.ui.ChangeColorIconWithTextView;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends FragmentActivity implements
		OnPageChangeListener, OnClickListener {
	private ViewPager mViewPager;
	private List<Fragment> mTabs = new ArrayList<Fragment>();
	private FragmentPagerAdapter mPagerAdapter;
	private ChangeColorIconWithTextView myIndicator;
	private ChangeColorIconWithTextView circleIndicator;
	private ChangeColorIconWithTextView findIndicator;
	private List<ChangeColorIconWithTextView> mTabIndicator = new ArrayList<ChangeColorIconWithTextView>();

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_main);
		initViewPager();
		initIndicator();
	}

	private void initIndicator() {
		myIndicator = (ChangeColorIconWithTextView) findViewById(R.id.my_indicator);
		circleIndicator = (ChangeColorIconWithTextView) findViewById(R.id.circle_indicator);
		findIndicator = (ChangeColorIconWithTextView) findViewById(R.id.find_indicator);
		myIndicator.setOnClickListener(this);
		circleIndicator.setOnClickListener(this);
		findIndicator.setOnClickListener(this);
		mTabIndicator.add(myIndicator);
		mTabIndicator.add(circleIndicator);
		mTabIndicator.add(findIndicator);
		circleIndicator.setIconAlpha(1.0f);
	}

	private void initViewPager() {
		mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
		mTabs.add(new MyFragment());
		mTabs.add(new CircleFrament());
		mTabs.add(new FindFragment());
		mPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {

			@Override
			public int getCount() {
				return mTabs.size();
			}

			@Override
			public Fragment getItem(int arg0) {
				return mTabs.get(arg0);
			}
		};
		mViewPager.setAdapter(mPagerAdapter);
		mViewPager.setCurrentItem(1);
		mViewPager.setOnPageChangeListener(this);
	}

	@Override
	public void onClick(View v) {
		resetOtherTabs();
		switch (v.getId()) {
		case R.id.my_indicator:
			mTabIndicator.get(0).setIconAlpha(1.0f);
			mViewPager.setCurrentItem(0, false);
			break;
		case R.id.circle_indicator:
			mTabIndicator.get(1).setIconAlpha(1.0f);
			mViewPager.setCurrentItem(1, false);
			break;
		case R.id.find_indicator:
			mTabIndicator.get(2).setIconAlpha(1.0f);
			mViewPager.setCurrentItem(2, false);
			break;
		}
	}

	/**
	 * 重置其他的Tab
	 */
	private void resetOtherTabs() {
		for (int i = 0; i < mTabIndicator.size(); i++) {
			mTabIndicator.get(i).setIconAlpha(0);
		}
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {

	}

	@Override
	public void onPageScrolled(int position, float positionOffset, int arg2) {

		if (positionOffset > 0) {
			ChangeColorIconWithTextView left = mTabIndicator.get(position);
			ChangeColorIconWithTextView right = mTabIndicator.get(position + 1);

			left.setIconAlpha(1 - positionOffset);
			right.setIconAlpha(positionOffset);
		}
	}

	@Override
	public void onPageSelected(int arg0) {

	}
}
