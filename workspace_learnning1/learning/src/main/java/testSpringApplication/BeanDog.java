package testSpringApplication;

public class BeanDog extends BeanAnimals {

	private String dog;

	@Override
	public void say() {
		// TODO Auto-generated method stub
		System.out.println("汪汪汪");
		System.out.println(dog);
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		System.out.println("BeanDog init");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("BeanDog destroy");
	}

	public String getDog() {
		return dog;
	}

	public void setDog(String dog) {
		this.dog = dog;
	}

}
