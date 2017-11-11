package com.techoffice.jc.horse.helper;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.techoffice.jc.horse.dto.CurrentOdd;
import com.techoffice.util.XmlUtil;

public class CurrentOddHelper {
	
	public static String getVenue(String xml) {
		String venueXpath = "//*[@id='trMeetingInfo']/td[2]/table/tbody/tr/td[4]/nobr[2]";
		String venueStr = XmlUtil.getXpathText(xml, venueXpath);
		if (venueStr.equals("Sha Tin")){
			return "Tin";
		}
		return "";
	}
	
	public static String getCourse(String xml) {
		String trackXpath = "//*[@id='info_bar']/tbody/tr[3]/td/table/tbody/tr/td[3]/nobr[4]";
		String courseXpath = "//*[@id='info_bar']/tbody/tr[3]/td/table/tbody/tr/td[3]/nobr[3]";
		String courseStr = XmlUtil.getXpathText(xml, courseXpath);
		courseStr = courseStr.toUpperCase();
		String trackStr = XmlUtil.getXpathText(xml, trackXpath);
		trackStr = trackStr.toUpperCase();
		String course = trackStr + " - " + courseStr;
		return course;
	}
	
	public static String getDistance(String xml) {
		String distanceXpath = "//*[@id='info_bar']/tbody/tr[3]/td/table/tbody/tr/td[3]/nobr[5]";
		String distanceStr = XmlUtil.getXpathText(xml, distanceXpath);
		distanceStr = distanceStr.toUpperCase();
		return distanceStr;
	}
	
	public static CurrentOdd getNodeInfo(Node node){
		CurrentOdd currentOdd = new CurrentOdd();
		String horseFullName = "";
		int tdNodeSeq = 0;
		NodeList nodeList = node.getChildNodes();
		for (int i=0; i<nodeList.getLength(); i++){
			Node item = nodeList.item(i);
			if (item.getNodeName().equals("td")){
				tdNodeSeq++;
				Node tdNode = item;
				if (tdNodeSeq == 3){
					Node aNode = tdNode.getChildNodes().item(0);
					String hrefString = aNode.getAttributes().getNamedItem("href").getNodeValue();
					String horseId = hrefString.replace("javascript:WACommonTagging('horse');goHorseRecord2('http://www.hkjc.com/english',%20'", "").replace("');", "");
					String horseNmae= aNode.getChildNodes().item(0).getTextContent();
					horseFullName = horseNmae + " (" + horseId + ")";
					currentOdd.setHorseName(horseFullName);
				}
				if (tdNodeSeq == 4){
					String draw = tdNode.getTextContent();
					currentOdd.setDraw(draw);
				}
				if(tdNodeSeq == 5){
					String weight = tdNode.getTextContent();
					currentOdd.setWeight(weight);
				}
				if(tdNodeSeq == 6){
					String jockey = tdNode.getTextContent();
					currentOdd.setJockey(jockey);	
				}
				if(tdNodeSeq == 7){
					String trainer = tdNode.getTextContent();
					currentOdd.setTrainer(trainer );		
				}
				if(tdNodeSeq == 8){
					String win = tdNode.getTextContent();
					currentOdd.setWin(win);
				}
				if(tdNodeSeq == 9){
					String place = tdNode.getTextContent();
					currentOdd.setPlace(place);
				}
			}
		}
		return currentOdd;
	}
}
