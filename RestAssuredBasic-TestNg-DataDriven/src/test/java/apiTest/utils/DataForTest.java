package apiTest.utils;

import org.testng.annotations.DataProvider;

public class DataForTest {
	@DataProvider(name = "DataForPost")
	public Object dataForPost() {

		return new Object[][] { { "abdessalem", "Guesmi", 1 }, { "Mohamed", "Ali", 2 } };

	}

	@DataProvider(name = "DataForDelete")
	public Object dataForDelete() {

		return new Object[] { 4, 5 };

	}
}
