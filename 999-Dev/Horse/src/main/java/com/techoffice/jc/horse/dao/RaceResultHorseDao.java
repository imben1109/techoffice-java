package com.techoffice.jc.horse.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RaceResultHorseDao {
	@Autowired
	private SessionFactory sessionFactory;
}
