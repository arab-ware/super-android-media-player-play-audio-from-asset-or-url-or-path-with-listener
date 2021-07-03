package com.my.newproject3;
import android.app.Activity;
import android.app.*;
import android.os.*;
import android.content.*;
import android.media.*;
import android.net.*;
import android.util.*;
import java.util.*;
import java.util.regex.*;
import java.text.*;

public class ArabWareMediaPlayer {

private Context classContext;
public static  MediaPlayerListener mpl;
public static Timer _timer;
public static MediaPlayer mediaplayer;
public static TimerTask timer;

public ArabWareMediaPlayer(Context context) {
classContext = context;
_timer = new Timer();
timer = new TimerTask() {
@Override
public void run() {
((Activity)classContext).runOnUiThread(new Runnable() {
@Override
public void run() {
if(mediaplayer != null) {
if (mediaplayer.isPlaying()) {
if(mpl != null) {
mpl.isPlaying(mediaplayer.getCurrentPosition());
}
}
}
}
});
}
};
_timer.scheduleAtFixedRate(timer, (int)(0), (int)(100));

}


public void setRawSource(int rawFileName) {

mediaplayer = MediaPlayer.create(classContext,rawFileName);

}

public void setPathSource(java.io.File file) {

mediaplayer = MediaPlayer.create(classContext, Uri.fromFile(file));

}

public void setAssetSource(String assetFileName) {
    java.io.File mediaplayerFile = new java.io.File(classContext.getCacheDir(), assetFileName);
try {
java.io.InputStream mediaplayerIS = classContext.getAssets().open(assetFileName); 
java.io.FileOutputStream mediaplayerFOS = null;
mediaplayerFOS = new java.io.FileOutputStream(mediaplayerFile);
final byte[] mediaplayerByte = new byte[1024];
int mediaplayerint;
while ((mediaplayerint = mediaplayerIS.read(mediaplayerByte)) != -1) {
mediaplayerFOS.write(mediaplayerByte, 0, mediaplayerint); } 
mediaplayerIS.close();
mediaplayerFOS.close();
} catch (Exception e) {}
mediaplayer = MediaPlayer.create(classContext, Uri.fromFile(new java.io.File(mediaplayerFile.getAbsolutePath())));
}

public void setUrlSource(String urlSource) {
    mediaplayer = MediaPlayer.create(classContext, Uri.parse(urlSource));
}

public interface MediaPlayerListener {

void isPlaying(int currentDuration);

void onPause();

void onStart();

}


public void setMediaPlayerListener(MediaPlayerListener mpl) {
    this.mpl = mpl;
}

public void start() {
        if(mediaplayer != null) {
           mediaplayer.start();
           if(mpl != null) {
                 mpl.onStart();
           }
    }
}

public void pause() {
    if(mediaplayer != null) {
    if(mediaplayer.isPlaying()) {
        mediaplayer.pause();
    }
      if(mpl != null) {
            mpl.onPause();
        }
    }
}

public void release() {
    mediaplayer.release();
    mediaplayer = null;
}

public boolean isPlaying() {
    return mediaplayer.isPlaying();
}

public void setLooping(boolean isLooping) {
    mediaplayer.setLooping(isLooping);
}

public int getCurrentDuration() {
    return (int) mediaplayer.getCurrentPosition();
}

public int getDuration() {
    return (int) mediaplayer.getDuration();
}

public void seekTo(int seekToValue) {
    mediaplayer.seekTo(seekToValue);
}

public android.media.MediaPlayer getMediaPlayer() {
    return mediaplayer;
}

}