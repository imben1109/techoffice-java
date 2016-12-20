package com.techoffice.jc.horse.service.web.helper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.techoffice.jc.horse.model.RaceResult;
import com.techoffice.jc.horse.model.RaceResultHorse;
import com.techoffice.util.XmlUtil;
import com.techoffice.util.exception.XmlUtilXpathNotUniqueException;

public class ResultWebServiceHelper {
	
	public static RaceResult getRaceResult(String xml, String location) throws XPathExpressionException, ParserConfigurationException, SAXException, IOException, XmlUtilXpathNotUniqueException{
		RaceResult raceResult = new RaceResult();
		String raceMeetingStr = XmlUtil.getXpathText(xml, "/html/body/div[2]/div[2]/div[2]/div[3]/table/tbody/tr/td[1]");
		System.out.println(raceMeetingStr);
		String raceClassStr = XmlUtil.getXpathText(xml, "/html/body/div[2]/div[2]/div[2]/div[5]/div[2]/table/tbody/tr[1]/td[1]");
		System.out.println(raceClassStr);
		String goingStr = XmlUtil.getXpathText(xml, "/html/body/div[2]/div[2]/div[2]/div[5]/div[2]/table/tbody/tr[1]/td[3]");
		System.out.println(goingStr);
		String raceNameStr = XmlUtil.getXpathText(xml, "/html/body/div[2]/div[2]/div[2]/div[5]/div[2]/table/tbody/tr[2]/td[1]");
		System.out.println(raceNameStr);
		String courseStr = XmlUtil.getXpathText(xml, "/html/body/div[2]/div[2]/div[2]/div[5]/div[2]/table/tbody/tr[2]/td[3]");
		System.out.println(courseStr);
		String rewardAndTimeStr = XmlUtil.getXpathText(xml, "/html/body/div[2]/div[2]/div[2]/div[5]/div[2]/table/tbody/tr[3]");
		System.out.println(rewardAndTimeStr);
		String sectionalTimeStr = XmlUtil.getXpathText(xml, "/html/body/div[2]/div[2]/div[2]/div[5]/div[2]/table/tbody/tr[4]");
		System.out.println(sectionalTimeStr);
		return raceResult;
	}
	
	public static List<RaceResultHorse> getRaceResultHorseList(String xml) throws XPathExpressionException, ParserConfigurationException, SAXException, IOException{
		List<RaceResultHorse> raceResultHorseList = new ArrayList<RaceResultHorse>();
		NodeList raceHorseNodeList = XmlUtil.evaluateXpath(xml, "/html/body/div[2]/div[2]/div[2]/div[6]/table/tbody/tr");
		for (int i=0; i<raceHorseNodeList.getLength(); i++){
			Node raceHorseTrNode = raceHorseNodeList.item(i);
			NodeList raceHorseTdNodeList = raceHorseTrNode.getChildNodes();
			List<String> tdValueList = new ArrayList<String>();
			for (int j=0; j<raceHorseTdNodeList.getLength(); j++){
				Node raceHourseTdNode = raceHorseTdNodeList.item(j);
				if ("td".equals(raceHourseTdNode.getNodeName())){
					String tdValue = "";
					if (raceHourseTdNode.getChildNodes().getLength() == 1){
						tdValue = raceHourseTdNode.getFirstChild().getNodeValue();
					}else {
						tdValue = XmlUtil.getNodeText(raceHourseTdNode);
					}
					tdValueList.add(tdValue);
				}
			}
			RaceResultHorse raceResultHorse = new RaceResultHorse();
			raceResultHorse.setPlace(tdValueList.get(0));
			raceResultHorse.setHorseNo(tdValueList.get(1));
			raceResultHorse.setHorseName(tdValueList.get(2));
			raceResultHorse.setJockey(tdValueList.get(3));
			raceResultHorse.setTrainer(tdValueList.get(4));
			raceResultHorse.setActualWt(tdValueList.get(5));
			raceResultHorse.setDeclaredWt(tdValueList.get(6));
			raceResultHorse.setDraw(tdValueList.get(7));
			raceResultHorse.setLbw(tdValueList.get(8));
			raceResultHorse.setRunningPosition(tdValueList.get(9));
			raceResultHorse.setFinishTime(tdValueList.get(10));
			raceResultHorse.setWinOdds(tdValueList.get(11));
			raceResultHorseList.add(raceResultHorse);
		}
		return raceResultHorseList;
	}
	
	
}
