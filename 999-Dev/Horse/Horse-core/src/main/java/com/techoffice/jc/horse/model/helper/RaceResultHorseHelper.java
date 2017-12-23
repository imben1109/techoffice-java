package com.techoffice.jc.horse.model.helper;

import java.util.Arrays;
import java.util.List;

import com.techoffice.jc.horse.model.RaceResultHorse;

public class RaceResultHorseHelper {

	public static List<String> getRunningPositingList(String runningPositing){
		return Arrays.asList(runningPositing.split("  "));
	}
	
	public static RaceResultHorse getNextRaceResultHorse(RaceResultHorse raceResultHorse, List<RaceResultHorse> toFindHorseList){
		return getNextRaceResultHorse(raceResultHorse, toFindHorseList, null);
	}
	
	public static RaceResultHorse getNextRaceResultHorse(RaceResultHorse raceResultHorse, List<RaceResultHorse> toFindHorseList, Boolean sameClass){
		RaceResultHorse foundHorse = null;
		RaceResultHorse nextHorse = null;
		for (RaceResultHorse toFindHorse: toFindHorseList){
			if (toFindHorse.equals(raceResultHorse)){
				foundHorse = nextHorse;
				if (nextHorse != null){
					if (sameClass != null){
						if (sameClass){
							if (!nextHorse.getRaceResult().getRaceClass().equals(raceResultHorse.getRaceResult().getRaceClass())){
								return null;
							}
						}else {
							if (nextHorse.getRaceResult().getRaceClass().equals(raceResultHorse.getRaceResult().getRaceClass())){
								return null;
							}
						}	
					}	
				}
				return foundHorse;
			}
			nextHorse = toFindHorse;
		}
		return foundHorse;
	}
	
	
}
