package com.techoffice.jc.horse.model.helper;

import java.util.Arrays;
import java.util.List;

public class RaceResultHorseHelper {

	public static List<String> getRunningPositingList(String runningPositing){
		return Arrays.asList(runningPositing.split("  "));
	}
	
	
}
