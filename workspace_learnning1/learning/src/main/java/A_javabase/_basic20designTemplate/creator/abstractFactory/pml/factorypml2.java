package A_javabase._basic20designTemplate.creator.abstractFactory.pml;

import A_javabase._basic20designTemplate.creator.abstractFactory.abstractFactory;
import A_javabase._basic20designTemplate.creator.abstractFactory.abstractProduct;
import A_javabase._basic20designTemplate.creator.abstractFactory.abstractProduct2;

public class factorypml2 implements abstractFactory {

	public abstractProduct createProduct1() {
		// TODO Auto-generated method stub
		product1 product1 = new product1();
		System.out.println("工厂factorypml2创建产品");
		return product1;
	}

	public abstractProduct2 createProduct2() {
		// TODO Auto-generated method stub
		product2 product2 = new product2();
		System.out.println("工厂factorypml2创建产品");
		return product2;
	}

}
