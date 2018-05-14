package com.techoffice.data.generator.type;

import com.techoffice.data.generator.type.base.BaseTypeGenerator;
import com.techoffice.database.model.Field;

public class StringGenerator extends BaseTypeGenerator<String> {

	private Integer sequence = 0;
	
	@Override
	public String generate(Field field) {
		if (field.isKey()){
			sequence++;
			return sequence.toString();
		}else if (field.getDataLength() > 7){
			return "TESTING";
		}
		return "";
	}

}
