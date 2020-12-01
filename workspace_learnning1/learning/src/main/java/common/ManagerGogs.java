package common;

import java.util.List;

/**
 * 宠物狗饲养机构
 * 
 * @author Administrator
 *
 */
public class ManagerGogs {
	private String name;
	private List<dog> dogs;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<dog> getDogs() {
		return dogs;
	}

	public void setDogs(List<dog> dogs) {
		this.dogs = dogs;
	}
}
