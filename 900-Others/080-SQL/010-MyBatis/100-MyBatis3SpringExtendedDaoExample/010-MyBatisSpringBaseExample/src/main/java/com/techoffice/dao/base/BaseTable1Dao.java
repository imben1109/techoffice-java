package com.techoffice.dao.base;

import java.util.List;

import com.techoffice.entity.base.BaseTable1;

public interface BaseTable1Dao <T extends BaseTable1>{

	public List<T> select();
}
