package testSpringApplication;

public class BeanCat extends BeanAnimals {
	private String cat;

	@Override
	public void say() {
		// TODO Auto-generated method stub
		System.out.println("喵喵喵");
		System.out.println(cat);
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		System.out.println("BeanCat init");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("BeanCat destroy");
	}

	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}

}
