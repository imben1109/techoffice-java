package com.techoffice.service;

import java.util.List;

import com.techoffice.entity.base.BaseTable1;

public interface Table1Service <T extends BaseTable1>{

	List<T> select();

}
