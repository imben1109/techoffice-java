package com.techoffice.example;

import java.awt.AWTException;
import java.io.IOException;

import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinDef.RECT;

/**
 * This is an example of JNA which provide access to native user32.dll function
 * 
 * The available method would be referred to 
 * 	- https://msdn.microsoft.com/en-us/library/windows/desktop/ms632595(v=vs.85).aspx
 *  - https://java-native-access.github.io/jna/4.2.0/com/sun/jna/platform/win32/User32.html
 * 
 * @author Ben_c
 *
 */
public class Appl {
    private static final int MAX_TITLE_LENGTH = 1024;

	public static void main(String[] args) throws AWTException, IOException{
		char[] buffer = new char[MAX_TITLE_LENGTH * 2];
		RECT rect = new RECT();
		HWND hwnd = User32.INSTANCE.GetForegroundWindow();
		User32.INSTANCE.GetWindowText(hwnd, buffer, MAX_TITLE_LENGTH);
		User32.INSTANCE.GetWindowRect(hwnd, rect);
		System.out.println(buffer);
		System.out.println("Left Top Coordinate: " + rect.left + "," +  rect.top );
		int width = (rect.right - rect.left);
		int height = (rect.bottom - rect.top);
		System.out.println("width: " + width);
		System.out.println("height: " + height);
	}
}
