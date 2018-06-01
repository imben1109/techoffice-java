package com.techoffice.util;

import java.lang.reflect.Field;

import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.WinNT;

public class ProcessUtil {
	public static long getProcessId(Process process) throws ProcessUtilException{
		long pid = -1;
		Field field;
		try {
			field = process.getClass().getDeclaredField("handle");
		    field.setAccessible(true);
		    long processPointerInt = (Long) field.get(process);
	        WinNT.HANDLE handle = new WinNT.HANDLE();
	        handle.setPointer(Pointer.createConstant(processPointerInt));
		    pid = Kernel32.INSTANCE.GetProcessId(handle);
		} catch (Exception e) {
			throw new ProcessUtilException("Process Util is not supported");
		} 
		return pid;
	}
}
