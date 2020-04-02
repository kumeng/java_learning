package testSpringApplication;

public class AnimalsServices {
	
	private BeanAnimals animals;
	
	public AnimalsServices(BeanAnimals animals2){
		this.animals = animals2;
	}
	public AnimalsServices(){		
	}	

	public void run(){
		animals.excuse();
		animals.say();
	}
	
	public BeanAnimals getAnimals() {
		return animals;
	}

	public void setAnimals(BeanAnimals animals) {
		this.animals = animals;
	}
	
	

	public void init() {
		// TODO Auto-generated method stub
		System.out.println("AnimalsServices init");
	}

	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("AnimalsServices destroy");
	}	
}
