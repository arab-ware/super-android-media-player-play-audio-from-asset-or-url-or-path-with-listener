# MediaPlayer---Play-Audio-Files-Easily
with this library you will be able to create amazing media playing apps ....


example ===>


ArabWareMediaPlayer awmp = new ArabWareMediaPlayer(YourContextHere);


//how to add listener

awmp.setMediaPlayerListener(new ArabWareMediaPlayer.MediaPlayerListener() {
@Override
public void isPlaying(int current duration) {
//is playing.......
}
@Override
public void onStop() {
//stoped.....
}

@Override
public void onStart() {
//started.......
}
});


//how to set media player from raw folder
awmp.setRawSource(R.raw.media);

//how to set media player from java.io.File source
awmp.setPathSource(Your java.io.File);

how to set media player from url

awmp.setUrlSource(string);

//how to set media player from asser

awmp.setAssetSource(string);


//how to Start ... Pause ... Release

awmp.start()
awmp.pause();
awmp.release();

//how to get current duration or max duration

int a = awmp.getCurrentDuration();
int b = awmp.getDuration();

//how to check if media player is Playing or no

boolean displaying = awmp.isPlaying();


//there is another methods ...??

just use this to make the class return media player

awmp.getMediaPlayer().YourMethodYoknow(......);
