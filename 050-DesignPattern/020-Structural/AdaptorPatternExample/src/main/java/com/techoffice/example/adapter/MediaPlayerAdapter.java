package com.techoffice.example.adapter;

import com.techoffice.example.mediaplayer.Mp4Player;
import com.techoffice.example.mediaplayer.VlcPlayer;
import com.techoffice.example.mediaplayer.intf.MediaPlayer;

public class MediaPlayerAdapter {
	
	private MediaPlayer mediaPlayer;
	
	public MediaPlayerAdapter(String type){
		if ("mp4".equals(type)){
			mediaPlayer = new Mp4Player();
		}
		if ("vlc".equals(type)){
			mediaPlayer = new VlcPlayer();
		}
	}
	
	public void play(){
		mediaPlayer.play();
	}
}
