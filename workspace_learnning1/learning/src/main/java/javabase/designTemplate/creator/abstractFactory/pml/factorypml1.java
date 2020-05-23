package javabase.designTemplate.creator.abstractFactory.pml;

import javabase.designTemplate.creator.abstractFactory.abstractFactory;
import javabase.designTemplate.creator.abstractFactory.abstractProduct;
import javabase.designTemplate.creator.abstractFactory.abstractProduct2;

public class factorypml1 implements abstractFactory {

	public abstractProduct createProduct1() {
		// TODO Auto-generated method stub
		product1 product1 = new product1();
		System.out.println("工厂factorypml1创建产品");
		return product1;
	}

	public abstractProduct2 createProduct2() {
		// TODO Auto-generated method stub
		product2 product2 = new product2();
		System.out.println("工厂factorypml1创建产品");
		return product2;
	}

}
