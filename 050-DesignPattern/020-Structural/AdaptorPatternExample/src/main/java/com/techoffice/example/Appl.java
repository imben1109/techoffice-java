package com.techoffice.example;

import com.techoffice.example.adapter.MediaPlayerAdapter;

/**
 * Adapter is a structural pattern which create a adapter which acts a bridge between two incompatible class.
 * 
 * @author Ben_c
 *
 */
public class Appl {
	public static void main(String[] args){
		MediaPlayerAdapter mediaPlayerAdapter;
		
		mediaPlayerAdapter = new MediaPlayerAdapter("mp4");
		mediaPlayerAdapter.play();
		
		mediaPlayerAdapter = new MediaPlayerAdapter("vlc");
		mediaPlayerAdapter.play();
	}
}
