package com.techoffice.example;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;

public interface CLibrary extends Library {
    
	// msvcrt is a Microsoft C runtime library.
	CLibrary INSTANCE = (CLibrary)
        Native.loadLibrary((Platform.isWindows() ? "msvcrt" : "c"),
                           CLibrary.class);
    
	void printf(String format, Object... args);
}