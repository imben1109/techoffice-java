package com.techoffice.example;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.ptr.PointerByReference;

/**
 * This class provide the native access to user32.dll method
 * 
 * The available method would be referred to https://msdn.microsoft.com/en-us/library/windows/desktop/ms632595(v=vs.85).aspx
 * @author Ben_c
 *
 */
public class User32DLL {
    static { Native.register("user32"); }
    public static native int GetWindowThreadProcessId(HWND hWnd, PointerByReference pref);
    public static native HWND GetForegroundWindow();
    public static native int GetWindowTextW(HWND hWnd, char[] lpString, int nMaxCount);
}
