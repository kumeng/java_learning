package A_javabase._basic20designTemplate.creator.abstractFactory;

import A_javabase._basic20designTemplate.creator.abstractFactory.pml.factorypml1;
import A_javabase._basic20designTemplate.creator.abstractFactory.pml.factorypml2;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//用抽象工厂开始搞产品
		abstractFactory ay = new factorypml1();
		abstractProduct createProduct1 = ay.createProduct1();
		createProduct1.show();
		System.out.println();
		abstractProduct2 createProduct2 = ay.createProduct2();
		createProduct2.show();
		System.out.println();
		
		abstractFactory ay2 = new factorypml2();
		abstractProduct createProduct12 = ay2.createProduct1();
		createProduct12.show();
		System.out.println();
		abstractProduct2 createProduct22 = ay2.createProduct2();
		createProduct22.show();
		System.out.println();		
	}

}
