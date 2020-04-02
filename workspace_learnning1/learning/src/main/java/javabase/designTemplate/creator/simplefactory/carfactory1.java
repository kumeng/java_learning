package javabase.designTemplate.creator.simplefactory;

public class carfactory1 {
	public car createcar(String carname){
		car c1 = null;
		if("奥迪".equals(carname)){
			c1 = new aodi();
		}else if("宝马".equals(carname)){
			c1 = new baoma();
		}
		return c1;
	}
}
