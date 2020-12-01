package A_javabase._basic20designTemplate.creator.simplefactory2;

import A_javabase._basic20designTemplate.creator.simplefactory.car;

public class testsimplefactory2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		car aodi = aodifactory.createaodi();
		car baoma = baomafactory.createbaoma();
		aodi.run();
		baoma.run();
	}

}
