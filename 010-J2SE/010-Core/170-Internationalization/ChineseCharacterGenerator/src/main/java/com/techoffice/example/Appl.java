package com.ittechoffice.example;

import java.util.Random;

/**
 * The Chinese character in Unicode has defined ranges. 
 * Please note that there are many blocks (ranges) for Chinese Character.
 * Chinese character string can be generated within the specified ranges.
 * 
 * ------------------------------------------------------------------------------------------------------------------
 * CJK Unified Ideographs                  4E00-9FFF   Common 
 * CJK Unified Ideographs Extension A      3400-4DFF   Rare
 * CJK Unified Ideographs Extension B      20000-2A6DF Rare, historic
 * CJK Unified Ideographs Extension C      2A700�V2B73F Rare, historic
 * CJK Unified Ideographs Extension D      2B740�V2B81F Uncommon, some in current use
 * CJK Unified Ideographs Extension E      2B820�V2CEAF Rare, historic
 * CJK Compatibility Ideographs            F900-FAFF   Duplicates, unifiable variants, corporate characters
 * CJK Compatibility Ideographs Supplement 2F800-2FA1F Unifiable variants
 * ------------------------------------------------------------------------------------------------------------------
 * 
 * Even CJK Unified Ideographs (4E00-9FFF) Common covers Unicode 1.0 to Unicode 9.0 and include Private Use, Reserved and Noncharacter.
 * For Unicode 1.0, the range should be 4E00 to 0x9FBB
 * 
 * 
 * @author Ben_c
 *
 */
public class Appl {
	private static int chineseStart = Integer.parseInt(String.valueOf(0x4E00));
	private static int chineseEnd = Integer.parseInt(String.valueOf(0x9FA5));
	
	public static void main(String[] args){
		Random random = new Random();
		int r = random.nextInt(chineseEnd - chineseStart) + chineseStart;
		char rChar = (char) r;
		String rString = String.valueOf(rChar);
		
		System.out.println(rString);
	}
}
