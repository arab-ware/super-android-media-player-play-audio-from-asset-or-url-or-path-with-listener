package com.my.newproject3;

import android.app.Activity;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import org.json.*;
import android.widget.Button;
import android.widget.SeekBar;
import android.content.Intent;
import android.content.ClipData;
import android.view.View;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.DialogFragment;
import android.Manifest;
import android.content.pm.PackageManager;


public class MainActivity extends Activity {
	public final int REQ_CD_AUDIOFILE = 101;
	
	private double currentDuration = 0;
	private double maxDuration = 0;
	private String pathOrUrlOrAsset = "";
	
	private Button button1;
	private Button button2;
	private Button button3;
	private Button button4;
	private Button button5;
	private SeekBar seekbar1;
	
	private Intent audioFile = new Intent(Intent.ACTION_GET_CONTENT);
	private RequestNetwork JUST_FOR_INTERNET_PERMISSION_OK;
	private RequestNetwork.RequestListener _JUST_FOR_INTERNET_PERMISSION_OK_request_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		if (Build.VERSION.SDK_INT >= 23) {
			if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
				requestPermissions(new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, 1000);
			}
			else {
				initializeLogic();
			}
		}
		else {
			initializeLogic();
		}
	}
	
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == 1000) {
			initializeLogic();
		}
	}
	
	private void initialize(Bundle _savedInstanceState) {
		button1 = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);
		button3 = (Button) findViewById(R.id.button3);
		button4 = (Button) findViewById(R.id.button4);
		button5 = (Button) findViewById(R.id.button5);
		seekbar1 = (SeekBar) findViewById(R.id.seekbar1);
		audioFile.setType("audio/*");
		audioFile.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		JUST_FOR_INTERNET_PERMISSION_OK = new RequestNetwork(this);
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				awmp.setRawSource(R.raw.quran);
			}
		});
		
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(audioFile, REQ_CD_AUDIOFILE);
			}
		});
		
		button3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				pathOrUrlOrAsset = "https://dl2.sura.pw/dl/reciter/1/128/001.mp3?h=dZdqS8bkxekHmADb9BcF-A&expires=1625369208&dl=true";
				awmp.setUrlSource(pathOrUrlOrAsset);
			}
		});
		
		button4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				awmp.start();
			}
		});
		
		button5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				awmp.pause();
			}
		});
		
		_JUST_FOR_INTERNET_PERMISSION_OK_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
	}
	
	private void initializeLogic() {
		_explain("hi brother/sister .....\n\n\ni will example every thing in this library\n\nbefore that ...\n\nthis is a simple library made by ArabWare\n\n\ni will be thankful if you take minute of your time to subscribe my channel if not\n\n\n\n\n\nThe name of class of library is ArabWareMediaPlayer \n\nso the variable name is ArabWareMediaPlayer\n\nso when you try to create it\n\nArabWareMediaPlayer a = new ArabWareMediaPlayer(YourActivityHere.this);\n\n\n\nmethods of the library\n\n\n\nYourVariable.setRawSource(Your Music Name in Your Project Here)\n\nexample awmp.setRawSource(R.raw.quran);\n\nYourVariable.setPathSource(File);\n\nthis can Be used To load a media player from storage or cache\n\nexample for storage\n\nYourVariable.setPathSource(new java.io.File(\"YourPath\"));\n\nexample for cache\n\nYourVariable.setPathSource(new java.io.File(YourActivityHere.this.getCacheDir(),\"Your File Name Or Path In Cache.....\"));\n\n\nYourVariable.setUrlSource(\"Link\");\n\n\nnote : only direct links that is downloadable .... i mean your can download them directly when paste in browser .... direct download\n\n\nYourVariable.setAssetSource(\"your file path in asset\");\n\nuse this if you want to play audio from asset .......\n\n\n\n\nYourVariable.getMediaPlayer().YourMethod(.....);\n\n\nthis is If You Think There is a method i did not put in my class .... and it is avaiable in MediaPlayer\n\n\nexample\n\nYourVarible.getMediaPlayer().setDataSource(........);\n\n\n\n\nfinally ..... you can set Listener.....\n\n\ni have put an example in onCreate");
		_explain("مرحباً أخي / أخت ..... سأقوم بشرح هذه المكتبة قبل ذلك ...\n هذه مكتبة بسيطة من صنع ArabWare سأكون شاكرا إذا كنت تأخذ دقيقة من وقتك للاشتراك في قناتي\nاسم كلاس المكتبة هو ArabWareMediaPlayer لذا فإن اسم المتغير هو ArabWareMediaPlayer لذلك عندما تحاول إنشائه \n\nArabWareMediaPlayer a = new ArabWareMediaPlayer (YourActivityHere.this);\nوظائف المكتبة \nYourVariable.setRawSource (اسم الموسيقى الخاص بك في مشروعك هنا) \nمثال \nawmp.setRawSource (R.raw.quran); \n\nYourVariable.setPathSource (ملف);\n يمكن استخدام هذا لتحميل مشغل وسائط من التخزين أو ذاكرة التخزين المؤقت\n مثال للتخزين \nYourVariable.setPathSource (new java.io.File (\"مسارك\"));\nمثال المثال لذاكرة التخزين المؤقت \nYourVariable.setPathSource (new java.io.File (YourActivityHere.this.getCacheDir ()، \"اسم الملف أو المسار في ذاكرة التخزين المؤقت .....\")); \n\nYourVariable.setUrlSource (\"رابط مباشر\");\nملاحظة: الروابط المباشرة التي يمكن تنزيلها فقط .... أعني أنه يمكنك تنزيلها مباشرة عند اللصق في المتصفح .... تنزيل مباشر\n\n\n\nYourVariable.setAssetSource(\"asset مسار الملف في\");\n\nتستخدم لتشغيل وسائط صوتية من asset\n \nYourVariable.getMediaPlayer (). YourMethod (.....);\n\nهذا إذا كنت تعتقد أن هناك طريقة لم أضعها في صفي .... وهي متوفرة في MediaPlayer مثال \nYourVarible.getMediaPlayer (). setDataSource (........);\nأخيرًا ..... يمكنك ضبط listener و الذي هو يقوم بشيء معين تحدده حين يحدث شيء للمتغير الذي صنعته مثلا حين كذا و حين كذا..... ..... لقد قدمت مثالاً في onCreate");
		awmp = new ArabWareMediaPlayer(MainActivity.this);
		awmp.setMediaPlayerListener(new ArabWareMediaPlayer.MediaPlayerListener() {
			 @Override
			public void isPlaying(int currentDurationValue) {
				currentDuration = currentDurationValue;
				maxDuration = awmp.getDuration();
				if (!(maxDuration == seekbar1.getMax())) {
					seekbar1.setMax((int)maxDuration);
				}
				seekbar1.setProgress((int)currentDuration);
			}
			 @Override
			public void onPause() {
				SketchwareUtil.showMessage(getApplicationContext(), "pause......");
			}
			 @Override
			public void onStart() {
				SketchwareUtil.showMessage(getApplicationContext(), "start........");
			}
		});
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		switch (_requestCode) {
			case REQ_CD_AUDIOFILE:
			if (_resultCode == Activity.RESULT_OK) {
				ArrayList<String> _filePath = new ArrayList<>();
				if (_data != null) {
					if (_data.getClipData() != null) {
						for (int _index = 0; _index < _data.getClipData().getItemCount(); _index++) {
							ClipData.Item _item = _data.getClipData().getItemAt(_index);
							_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _item.getUri()));
						}
					}
					else {
						_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _data.getData()));
					}
				}
				pathOrUrlOrAsset = _filePath.get((int)(0));
				awmp.setPathSource(new java.io.File(pathOrUrlOrAsset));
			}
			else {
				
			}
			break;
			default:
			break;
		}
	}
	
	public void _variable_name () {
	}
	private ArabWareMediaPlayer awmp;
	{
	}
	
	
	public void _explain (final String _readme) {
		
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}