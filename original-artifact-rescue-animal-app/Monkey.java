
public class Monkey extends RescueAnimal {
	
	
	//Attributes for Monkey
	private String species;
	private float height;
	private float tailLength;
	private float bodyLength;
	
	//Constructor
	public Monkey(String name, String species, String gender, String age, 
			String weight, String acquisitionDate, String acquisitionCountry, 
			String trainingStatus, boolean reserved, String inServiceCountry,
			float height, float tailLength, float bodyLength) {
		
		//attributes inherited from RescueAnimal
		setName(name);
		setGender(gender);
		setAge(age);
		setWeight(weight);
		setAcquisitionDate(acquisitionDate);
		setAcquisitionLocation(acquisitionCountry);
		setTrainingStatus(trainingStatus);
		setReserved(reserved);
		setInServiceCountry(inServiceCountry);
		
		//Setting additional attributes for Monkey class
		setSpecies(species);
		setHeight(height);
		setTailLength(tailLength);
		setBodyLength(bodyLength);
	}
	
	
	// Accessor Method
	public String getSpecies() {
		return species;
	}
	
	// Mutator Method
	public void setSpecies(String monkeySpecies) {
		species = monkeySpecies;
	}
	
	// Accessor Method
	public float getHeight() {
		return height;
	}
	
	// Mutator Method
	public void setHeight(float monkeyHeight) {
		height = monkeyHeight;
	}
	
	// Accessor Method
	public float getTailLength() {
		return tailLength;
	}
	
	// Mutator Method
	public void setTailLength(float monkeyTailLength) {
		tailLength = monkeyTailLength;
	}
	
	// Accessor Method
	public float getBodyLength() {
		return bodyLength;
	}
	
	// Mutator Method
	public void setBodyLength(float monkeyBodyLength) {
		bodyLength = monkeyBodyLength;
	}

}
