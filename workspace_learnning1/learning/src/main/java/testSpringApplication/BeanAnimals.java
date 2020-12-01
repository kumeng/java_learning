package testSpringApplication;

public abstract class BeanAnimals {
	private String name;
	private Integer age;

	public abstract void say();

	public void excuse() {
		System.out.println("MyName is " + name + "," + age + "岁!");
	}

	public abstract void init();

	public abstract void destroy();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
