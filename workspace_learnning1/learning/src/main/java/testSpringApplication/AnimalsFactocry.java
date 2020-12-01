package testSpringApplication;

public class AnimalsFactocry {

	public AnimalsFactocry() {

	}

	public Object getAnimals(Class<?> cls) throws InstantiationException, IllegalAccessException {
		Object bean1 = cls.newInstance();
		return bean1;
	}

	public Object getAnimals(String animalname)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		return this.getAnimals(Class.forName(animalname));
	}

	public Object getAnimals() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		return this.getAnimals("testSpringApplication.BeanDog");
	}

	public BeanAnimals getAnimals2(Class<? extends BeanAnimals> cls)
			throws InstantiationException, IllegalAccessException {
		BeanAnimals bean1 = cls.newInstance();
		return bean1;
	}

	public BeanAnimals getAnimals2(String animalname)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		return (BeanAnimals) this.getAnimals(Class.forName(animalname));
	}

	public BeanAnimals getAnimals2() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		return this.getAnimals2("testSpringApplication.BeanCat");
	}
}
