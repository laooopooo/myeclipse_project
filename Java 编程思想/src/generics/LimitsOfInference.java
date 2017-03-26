package generics;

import java.util.List;
import java.util.Map;

import typeinfo.pets.Person;
import typeinfo.pets.Pet;

public class LimitsOfInference {
	static void f(Map<Person, List<? extends Pet>> petPerson) {

	}

}
