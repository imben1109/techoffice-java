package com.techoffice.example.mediaplayer;

import com.techoffice.example.mediaplayer.intf.MediaPlayer;

public class VlcPlayer implements MediaPlayer{
	public void play(){
		System.out.println("playing VLC");
	}
}
