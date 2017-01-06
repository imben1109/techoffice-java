package com.techoffice.example;

import com.sun.jna.platform.win32.WinDef.HWND;

/**
 * This is an example of JNA which provide access to native user32.dll function
 * 
 * The available method would be referred to https://msdn.microsoft.com/en-us/library/windows/desktop/ms632595(v=vs.85).aspx
 * 
 * @author Ben_c
 *
 */
public class Appl {
    private static final int MAX_TITLE_LENGTH = 1024;

	public static void main(String[] args){
        char[] buffer = new char[MAX_TITLE_LENGTH * 2];
		HWND hwnd = User32DLL.GetForegroundWindow();
		User32DLL.GetWindowTextW(hwnd, buffer, MAX_TITLE_LENGTH);
		System.out.println(buffer);
	}
}
