import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
	//Lists to store dogs, monkeys, and availale animals
    private static ArrayList<Dog> dogList = new ArrayList<>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<>();
    // Instance variables (if needed)
    private static ArrayList<RescueAnimal> availableList;

    public static void main(String[] args) {

    	//intializes doglist, monkeylist, and available list
        initializeDogList();
        initializeMonkeyList();
        availableList = new ArrayList<>();

        // Add a loop that displays the menu, accepts the users input
        // and takes the appropriate action.
	// For the project submission you must also include input validation
        // and appropriate feedback to the user.
        // Hint: create a Scanner and pass it to the necessary
        // methods 
	// Hint: Menu options 4, 5, and 6 should all connect to the printAnimals() method.
        Scanner scanner = new Scanner(System.in);
        char choice;
        
        //loop that displays menu for user to choose options
        do {
        	//Display menu options
        	displayMenu();
        	choice = scanner.next().charAt(0);
        	scanner.nextLine();
        	
        	//switch statement to perfom actions based on user input
        	switch (choice) {
        	case '1':
        		intakeNewDog(scanner);
        		break;
        	case '2':
        		intakeNewMonkey(scanner);
        		break;
        	case '3':
        		reserveAnimal(scanner);
        		break;
        	case '4':
        		printAnimals(dogList, "dog");
        		break;
        	case '5':
        		printAnimals(monkeyList, "monkey");
        		break;
        	case '6':
        		if(!availableList.isEmpty()) {
        		printAnimals(availableList, "available");
        		} else {
        			System.out.println("No available animals.");
        		}
        		break;
        	case 'q':
        		System.out.println("Quits appplication");
        		break;
        	default:
        		System.out.println("Invalid input. Please choose an option listed.");
        	}
        	
        } while (choice != 'q');
    }

    // This method prints the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }


    // Adds dogs to a list for testing
    public static void initializeDogList() {
    	//creates instances of Dog class with attributes
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada");
        
        //adds dogs to dogList
        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
        
    	availableList = new ArrayList<>();
    	
    	//loops through dogList to find dogs in service and not reserved and adds them to availableList
        for (Dog dog : dogList) {
        	if (dog.getTrainingStatus().equalsIgnoreCase("in service") && !dog.getReserved()) {
        		availableList.add(dog);
        	}
        }
    }


    // Adds monkeys to a list for testing
    //Optional for testing
    public static void initializeMonkeyList() {
    	Monkey monkey1 = new Monkey("Jojo", "Marmoset", "male", "3", "0.76", "02-23-2021", "Brazil", "Phase I", false, "United States", 7.4f, 7.2f, 7.3f);
    	Monkey monkey2 = new Monkey("Boots", "Squirrel Monkey", "male", "4", "11.4", "07-14-2020", "Ethiopia", "intake", false, "United States", 12.0f, 15.5f, 12.2f);
    	Monkey monkey3 = new Monkey("Sasha", "Tamarin", "female", "9", "1.4", "11-06-2018", "India", "in service", true, "United States", 10.2f, 12.0f, 11.2f);

    	//adds monkeys to monkeyList
    	monkeyList.add(monkey1);
    	monkeyList.add(monkey2);
    	monkeyList.add(monkey3);
    	
    	availableList = new ArrayList<>();
    	
    	//loops through monkeyList to find dogs in service and not reserved and adds them to availableList
    	for (Monkey monkey : monkeyList) {
        	if (monkey.getTrainingStatus().equalsIgnoreCase("in service") && monkey.getReserved()) {
        		availableList.add(monkey);
        	}
    	}
    }


    // Complete the intakeNewDog method
    // The input validation to check that the dog is not already in the list
    // is done for you
    public static void intakeNewDog(Scanner scanner) {
        System.out.println("What is the dog's name?");
        String name = scanner.nextLine();
        for(Dog dog: dogList) {
            if(dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; //returns to menu
            }
        }

        // Add the code to instantiate a new dog and add it to the appropriate list
        //gets info from user about dog and adds to dogList
        System.out.println("Enter Dog's breed:");
        String breed = scanner.nextLine();
        
        System.out.println("Enter Dog's gender:");
        String gender = scanner.nextLine();
        
        System.out.println("Enter Dog's age:");
        String age = scanner.nextLine();
        
        System.out.println("Enter Dog's weight:");
        String weight = scanner.nextLine();
        
        System.out.println("Enter Dog's acquisition date (MM-DD-YYYY):");
        String acquisitionDate = scanner.nextLine();
        
        System.out.println("Enter Dog's acquisition country:");
        String acquisitionCountry = scanner.nextLine();
        
        System.out.println("Enter Dog's training status:");
        String trainingStatus = "";
        while (true) {
        	trainingStatus = scanner.nextLine();
        	if(!(trainingStatus.equalsIgnoreCase("intake")) && !(trainingStatus.equalsIgnoreCase("Phase I")) && !(trainingStatus.equalsIgnoreCase("Phase II")) 
        		&& !(trainingStatus.equalsIgnoreCase("Phase III")) && !(trainingStatus.equalsIgnoreCase("Phase IV")) && !(trainingStatus.equalsIgnoreCase("Phase V")) 
        		&& !(trainingStatus.equalsIgnoreCase("in service")) && !(trainingStatus.equalsIgnoreCase("farm"))) {
        	System.out.println("\n\nPlease enter a proper Training status listed");
        	} else {
        		break;
        	}
        }
        
        System.out.println("Is the dog reserved? (yes/no):");
        boolean reserved;
        while(true) {
        	String reservedInput = scanner.nextLine().toLowerCase();
        	if (reservedInput.equals("yes")) {
        		reserved = true;
        		break;
        	} else if (reservedInput.equals("no")) {
        		reserved = false;
        		break;
        	} else {
        		System.out.println("Invalid input. Enter 'yes' or 'no',");
        	}
        }
        
        System.out.println("Enter the country where dog is in service:");
        String inServiceCountry = scanner.nextLine();
        
        Dog newDog = new Dog(name, breed, gender, age, weight, acquisitionDate, acquisitionCountry,
        		trainingStatus, reserved, inServiceCountry);
        
        dogList.add(newDog);
        if(trainingStatus.equalsIgnoreCase("in service") && !reserved) {
        	availableList.add(newDog);
        }
        System.out.println("Dog added.");
    }


        // Complete intakeNewMonkey
	//Instantiate and add the new monkey to the appropriate list
        // For the project submission you must also  validate the input
	// to make sure the monkey doesn't already exist and the species type is allowed
        public static void intakeNewMonkey(Scanner scanner) {
        	System.out.println("What is the monkey's name?");
            String name = scanner.nextLine();
            
            for(Monkey monkey : monkeyList) {
            	if (monkey.getName().equalsIgnoreCase(name)) {
            		System.out.println("\n\nThis monkey is already in our system\n\n");
            		return;
            	}
            }
            
            System.out.println("Enter Monkey's species:");
            String species = scanner.nextLine();
            
            if(!(species.equalsIgnoreCase("Capuchin")) && !(species.equalsIgnoreCase("Guenon")) && !(species.equalsIgnoreCase("Macaque"))
            		&& !(species.equalsIgnoreCase("Marmoset")) && !(species.equalsIgnoreCase("Squirrel Monkey")) && !(species.equalsIgnoreCase("Tamarin"))) {
            	System.out.println("\n\nThis monkey's species is not permitted");
            }

            
            System.out.println("Enter Monkey's gender:");
            String gender = scanner.nextLine();
            
            System.out.println("Enter Monkey's age:");
            String age = scanner.nextLine();
            
            System.out.println("Enter Monkey's weight:");
            String weight = scanner.nextLine();
            
            System.out.println("Enter Monkey's acquisition date (MM-DD-YYYY):");
            String acquisitionDate = scanner.nextLine();
            
            System.out.println("Enter Monkey's acquistion country:");
            String acquisitionCountry = scanner.nextLine();
            
            System.out.println("Enter Monkey's training status:");
            String trainingStatus = "";
            while (true) {
            	trainingStatus = scanner.nextLine();
            	if(!(trainingStatus.equalsIgnoreCase("intake")) && !(trainingStatus.equalsIgnoreCase("Phase I")) && !(trainingStatus.equalsIgnoreCase("Phase II")) 
            		&& !(trainingStatus.equalsIgnoreCase("Phase III"))&& !(trainingStatus.equalsIgnoreCase("Phase IV")) && !(trainingStatus.equalsIgnoreCase("Phase V")) 
            		&& !(trainingStatus.equalsIgnoreCase("in service")) && !(trainingStatus.equalsIgnoreCase("farm"))) {
            	System.out.println("\n\nPlease enter a proper Training status listed");
            	} else {
            		break;
            	}
            }
            
            System.out.println("Is the monkey reserved? (yes/no):");
            boolean reserved;
            while(true) {
            	String reservedInput = scanner.nextLine().toLowerCase();
            	if (reservedInput.equals("yes")) {
            		reserved = true;
            		break;
            	} else if (reservedInput.equals("no")) {
            		reserved = false;
            		break;
            	} else {
            		System.out.println("Invalid input. Enter 'yes' or 'no'.");
            	}
            }

            
            System.out.println("Enter the country where the monkey is in service:");
            String inServiceCountry = scanner.nextLine();
            
            System.out.println("Enter Monkey's height:");
            float height = scanner.nextFloat();
            
            System.out.println("Enter Monkey's tail length:");
            float tailLength = scanner.nextFloat();
            
            System.out.println("Enter Monkey's body length:");
            float bodyLength = scanner.nextFloat();
            
            
            Monkey newMonkey = new Monkey(name, species, gender, age, weight,
            		acquisitionDate, acquisitionCountry, trainingStatus, reserved, inServiceCountry,
            		height, tailLength, bodyLength);
            
            monkeyList.add(newMonkey);
            if(trainingStatus.equalsIgnoreCase("in service") && !reserved) {
            	availableList.add(newMonkey);
            }
            System.out.println("Monkey added.");
        }

        // Complete reserveAnimal
        // You will need to find the animal by animal type and in service country
        public static void reserveAnimal(Scanner scanner) {
        	System.out.println("Enter the type of animal");
            String animalType = scanner.nextLine().toLowerCase();
            
            System.out.println("Enter the country they are in service:");
            String inServiceCountry = scanner.nextLine();
            
          //checks to see if animeal is a dog
            if(animalType.equals("dog")) {
            	//if its a dog asks for Dog's name
            	System.out.println("Enter the dog's name:");
            	String name = scanner.nextLine();
            	
            	// goes through dogList to find the specified dog
            	for(Dog dog : dogList) {
            		if(dog.getName().equalsIgnoreCase(name) && 
            				dog.getInServiceCountry().equalsIgnoreCase(inServiceCountry)) {
            			if(!dog.getReserved()) {
            				dog.setReserved(true);
            				System.out.println("Dog reserved.");
            			} else {
            				System.out.println("Dog is already reserved.");
            			}
            			return;
            		}
            	}
            }else if(animalType.equals("monkey")) {
            	System.out.println("Enter the monkey's name:");
            	String name = scanner.nextLine();
            	
            	for(Monkey monkey : monkeyList) {
            		if(monkey.getName().equalsIgnoreCase(name) && 
            				monkey.getInServiceCountry().equalsIgnoreCase(inServiceCountry)) {
            			if(!monkey.getReserved()) {
            				monkey.setReserved(true);
            				System.out.println("Monkey reserved.");
            			} else {
            				System.out.println("Monkey is already reserved.");
            			}
            			return;
            		}
            	}
            	
            	System.out.println("Animal not found in system.\n");
            }

        }

        // Complete printAnimals
        // Include the animal name, status, acquisition country and if the animal is reserved.
	// Remember that this method connects to three different menu items.
        // The printAnimals() method has three different outputs
        // based on the listType parameter
        // dog - prints the list of dogs
        // monkey - prints the list of monkeys
        // available - prints a combined list of all animals that are
        // fully trained ("in service") but not reserved 
	// Remember that you only have to fully implement ONE of these lists. 
	// The other lists can have a print statement saying "This option needs to be implemented".
	// To score "exemplary" you must correctly implement the "available" list.
        
        //prints out list based on user choice
        public static void printAnimals(ArrayList<? extends RescueAnimal> animalList, String listType) {
            System.out.println("\n" + listType + " list");
            
            for(RescueAnimal animal : animalList) {
                if ((listType.equalsIgnoreCase("dog") && animal instanceof Dog) ||
                    (listType.equalsIgnoreCase("monkey") && animal instanceof Monkey) ||
                    (listType.equalsIgnoreCase("available") &&
                        animal.getTrainingStatus().equalsIgnoreCase("in service") &&
                        !animal.getReserved())) {
                    printAnimalDetails(animal);
            }
            }

        }
        
        //prints details of animals
        private static void printAnimalDetails(RescueAnimal animal) {
        	System.out.println("Name: " + animal.getName());
        	System.out.println("Status: " + animal.getTrainingStatus());
        	System.out.println("Acquisition Country: " + animal.getAcquisitionLocation());
        	System.out.println("Reserved: " + (animal.getReserved()? "Yes":"No"));
        	System.out.println("_____________________________________");
        }
}


