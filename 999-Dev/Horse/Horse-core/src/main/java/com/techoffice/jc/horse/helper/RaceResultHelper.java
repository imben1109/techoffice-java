package com.techoffice.jc.horse.helper;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.apache.commons.lang3.time.DateUtils;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.techoffice.jc.horse.model.RaceResult;
import com.techoffice.jc.horse.model.RaceResultHorse;
import com.techoffice.util.XmlUtil;
import com.techoffice.util.exception.DocumentConversionException;
import com.techoffice.util.exception.XpathException;

public class RaceResultHelper {
	
	public static RaceResult getRaceResult(String xml, String location) throws XPathExpressionException, ParserConfigurationException, SAXException, IOException, XpathException, ParseException, DocumentConversionException{
		RaceResult raceResult = new RaceResult();
		raceResult.setLocation(location);
		if (location.split("/").length > 9 ){
			String raceNum = location.split("/")[location.split("/").length - 1];
			raceResult.setRaceNum(raceNum);
		}else{
			raceResult.setRaceNum("1");
		}
		
		String raceMeetingStr = XmlUtil.getXpathText(xml, "//*[@id='results']/div[3]/table/tbody/tr/td[1]");
		raceMeetingStr = raceMeetingStr.replace("Race Meeting: ", "");
		
		String[] raceMeetingStrArr = raceMeetingStr.split(" ");
		SimpleDateFormat raceDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date raceDate = raceDateFormat.parse(raceMeetingStrArr[0]);
		raceResult.setRaceDate(raceDate);
		
		String venue = raceMeetingStrArr[1];
		raceResult.setVenue(venue);
		
		String raceClassStr = XmlUtil.getXpathText(xml, "//*[@id='results']/div[5]/div[2]/table/tbody/tr[1]/td[1]");
		
		String[] raceClassStrArr = raceClassStr.split(" - ");
		
		String raceClass = raceClassStrArr[0];
		raceResult.setRaceClass(raceClass);
		
		String distance = raceClassStrArr[1];
		raceResult.setDistance(distance);
		if (raceClassStrArr.length > 2){
			String rtgRange = raceClassStrArr[2];
			raceResult.setRtgRange(rtgRange);	
		}

		
		String goingStr = XmlUtil.getXpathText(xml, "//*[@id='results']/div[5]/div[2]/table/tbody/tr[1]/td[3]");
		raceResult.setGoing(goingStr);
		
		String raceNameStr = XmlUtil.getXpathText(xml, "//*[@id='results']/div[5]/div[2]/table/tbody/tr[2]/td[1]");
		raceResult.setRaceName(raceNameStr);
		
		String courseStr = XmlUtil.getXpathText(xml, "//*[@id='results']/div[5]/div[2]/table/tbody/tr[2]/td[3]");
		raceResult.setCourse(courseStr);
		
		String rewardAndTimeStr = XmlUtil.getXpathText(xml, "//*[@id='results']/div[5]/div[2]/table/tbody/tr[3]");
		String[] rewardAndTimeStrArr = rewardAndTimeStr.split("Time : ");
		String reward = rewardAndTimeStrArr[0];
		raceResult.setReward(reward);
		String raceTime = rewardAndTimeStrArr[1];
		raceResult.setRaceTime(raceTime);
		
		String sectionalTimeStr = XmlUtil.getXpathText(xml, "//*[@id='results']/div[5]/div[2]/table/tbody/tr[4]");
		sectionalTimeStr = sectionalTimeStr.replace("Sectional Time : ", "");
		raceResult.setSectionalTime(sectionalTimeStr);
		
		return raceResult;
	}
	
	public static List<RaceResultHorse> getRaceResultHorseList(String xml, RaceResult raceResult) throws XpathException {
		List<RaceResultHorse> raceResultHorseList = new ArrayList<RaceResultHorse>();
		NodeList raceHorseNodeList = XmlUtil.evaluateXpath(xml, "//*[@id='results']/div[6]/table/tbody/tr");
		for (int i=0; i<raceHorseNodeList.getLength(); i++){
			Node raceHorseTrNode = raceHorseNodeList.item(i);
			NodeList raceHorseTdNodeList = raceHorseTrNode.getChildNodes();
			List<String> tdValueList = new ArrayList<String>();
			for (int j=0; j<raceHorseTdNodeList.getLength(); j++){
				Node raceHourseTdNode = raceHorseTdNodeList.item(j);
				if ("td".equals(raceHourseTdNode.getNodeName())){
					String tdValue = "";
					if (raceHourseTdNode.getChildNodes().getLength() == 1){
						if (raceHourseTdNode.getFirstChild().getChildNodes() != null &&
								raceHourseTdNode.getFirstChild().getChildNodes().getLength() == 1){
							tdValue = XmlUtil.getNodeText(raceHourseTdNode);
						}else{
							tdValue = raceHourseTdNode.getFirstChild().getNodeValue();
						}
					}else {
						tdValue = XmlUtil.getNodeText(raceHourseTdNode);
					}
					tdValueList.add(tdValue);
				}
			}
			RaceResultHorse raceResultHorse = listToRaceResultHorse(tdValueList);
			raceResultHorse.setRaceResult(raceResult);
			raceResultHorseList.add(raceResultHorse);
		}
		return raceResultHorseList;
	}
	
	public static RaceResultHorse listToRaceResultHorse(List<String> tdValueList){
		RaceResultHorse raceResultHorse = new RaceResultHorse();
		raceResultHorse.setPlace(tdValueList.get(0));
		raceResultHorse.setHorseNo(tdValueList.get(1));
		raceResultHorse.setHorseName(tdValueList.get(2));
		if (raceResultHorse.getHorseName() != null){
			String horseName = raceResultHorse.getHorseName();
			if (horseName.split("\\(").length > 1){
				String horseId = horseName.split("\\(")[1].replace(")", "");
				raceResultHorse.setHorseId(horseId);
			}
		}
		raceResultHorse.setJockey(tdValueList.get(3));
		raceResultHorse.setTrainer(tdValueList.get(4));
		raceResultHorse.setActualWt(tdValueList.get(5));
		raceResultHorse.setDeclaredWt(tdValueList.get(6));
		raceResultHorse.setDraw(tdValueList.get(7));
		raceResultHorse.setLbw(tdValueList.get(8));
		raceResultHorse.setRunningPosition(tdValueList.get(9));
		raceResultHorse.setFinishTime(tdValueList.get(10));
		raceResultHorse.setWinOdds(tdValueList.get(11));
		return raceResultHorse;
	}
	
	public static Date getRaceDate(String raceDateStr) throws ParseException{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		Date raceDate = simpleDateFormat.parse(raceDateStr);
		raceDate = DateUtils.truncate(raceDate, Calendar.DATE);
		return raceDate;
	}
}
