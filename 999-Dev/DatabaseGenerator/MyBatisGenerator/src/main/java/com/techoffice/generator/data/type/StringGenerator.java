package com.techoffice.generator.data.type;

import com.techoffice.database.dao.model.Field;
import com.techoffice.generator.data.type.base.BaseTypeGenerator;

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
