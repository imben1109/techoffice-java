package com.ittechoffice.example.model;
// Generated 2016/10/3 ¤U¤È 04:20:43 by Hibernate Tools 5.2.0.Beta1

/**
 *          This class contains the test entity. 
 *       
 */
public class TestEntity implements java.io.Serializable {

	private int id;
	private String name;
	private String desc;

	public TestEntity() {
	}

	public TestEntity(String name, String desc) {
		this.name = name;
		this.desc = desc;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
