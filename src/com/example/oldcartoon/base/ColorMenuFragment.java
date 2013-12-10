package com.example.oldcartoon.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.oldcartoon2.FragmentChangeActivity;
import com.example.oldcartoon2.R;

public class ColorMenuFragment extends ListFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.list, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		String[] colors = getResources().getStringArray(R.array.color_names);
		ArrayAdapter<String> colorAdapter = new ArrayAdapter<String>(getActivity(), 
				R.layout.list_item, android.R.id.text1, colors);
		setListAdapter(colorAdapter);
	}

	@Override
	public void onListItemClick(ListView lv, View v, int position, long id) {
		Fragment newContent = null;
		switch (position) {
		case 0:
			newContent = new ColorFragment(R.string.anser0);
			break;
		case 1:
			newContent = new ColorFragment(R.string.anser1);
			break;
		case 2:
			newContent = new ColorFragment(R.string.anser2);
			break;
		case 3:
			newContent = new ColorFragment(R.string.anser3);
			break;
		case 4:
			newContent = new ColorFragment(R.string.anser4);
			break;
		case 5:
			newContent = new ColorFragment(R.string.anser5);
			break;
		case 6:
			newContent = new ColorFragment(R.string.anser6);
			break;
		case 7:
			newContent = new ColorFragment(R.string.anser7);
			break;
		}
		if (newContent != null)
			switchFragment(newContent);
	}

	// the meat of switching the above fragment
	private void switchFragment(Fragment fragment) {
		if (getActivity() == null)
			return;
		
		if (getActivity() instanceof FragmentChangeActivity) {
			FragmentChangeActivity fca = (FragmentChangeActivity) getActivity();
			fca.switchContent(fragment);
		} 
	}


}
