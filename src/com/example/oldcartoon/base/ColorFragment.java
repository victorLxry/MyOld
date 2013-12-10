package com.example.oldcartoon.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import cn.waps.AdView;

import com.example.oldcartoon2.R;

public class ColorFragment extends Fragment {

	private int mColorRes = -1;

	public ColorFragment() {
		this(R.color.white);
	}

	public ColorFragment(int colorRes) {
		mColorRes = colorRes;
		setRetainInstance(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (savedInstanceState != null)
			mColorRes = savedInstanceState.getInt("mColorRes");
		// construct the RelativeLayout
		ScrollView v = new ScrollView(getActivity());
		TextView tv = new TextView(getActivity());
		tv.setTextColor(getResources().getColor(R.color.black));
		tv.setTextSize(18f);
		v.addView(tv);
		tv.setText(mColorRes);

		LinearLayout adlayout = new LinearLayout(getActivity());
		adlayout.setGravity(Gravity.BOTTOM);
		RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
				ViewGroup.LayoutParams.FILL_PARENT,
				ViewGroup.LayoutParams.WRAP_CONTENT); //
		new AdView(getActivity(), adlayout).DisplayAd(30);
		layoutParams.addRule(RelativeLayout.ALIGN_BOTTOM);//
		getActivity().addContentView(adlayout, layoutParams);

		return v;
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt("mColorRes", mColorRes);
	}

}
