package com.mss.admob;

import com.google.ads.Ad;
import com.google.ads.AdListener;
import com.google.ads.AdRequest;
import com.google.ads.AdView;
import com.google.ads.AdRequest.ErrorCode;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

/**
 * 
 * @author Master Software Solutions
 * 
 */

public class AdmobActivity extends Activity {
	AdView mAdView;
	String TAG;

	/*
	 * 
	 * AdView: The View to display banner ads.The ad size and ad unit ID must be
	 * set prior to calling loadAd(AdRequest).
	 */

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_admob);
		TAG = getResources().getString(R.string.tag);
		mAdView = (AdView) findViewById(R.id.adView);

		mAdView.setAdListener(new AdListener() {

			@Override
			public void onReceiveAd(Ad arg0) {
				Log.i(TAG, getResources().getString(R.string.onreceived_adds));

			}

			@Override
			public void onPresentScreen(Ad arg0) {
				// TODO Auto-generated method stub
				Log.i(TAG, getResources().getString(R.string.onpresent_screen));
			}

			@Override
			public void onLeaveApplication(Ad arg0) {
				// TODO Auto-generated method stub
				Log.i(TAG, getResources().getString(R.string.leave_app));
			}

			@Override
			public void onFailedToReceiveAd(Ad arg0, ErrorCode arg1) {
				// TODO Auto-generated method stub
				Log.i(TAG,
						getResources().getString(R.string.fail_to_receive_add));
			}

			@Override
			public void onDismissScreen(Ad arg0) {
				// TODO Auto-generated method stub
				Log.i(TAG, getResources().getString(R.string.screen_dismiss));
			}
		});
		AdRequest request = new AdRequest();
		mAdView.loadAd(request);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.admob, menu);
		return true;
	}

}
