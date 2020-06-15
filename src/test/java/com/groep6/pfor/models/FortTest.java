package com.groep6.pfor.models;

import static org.junit.jupiter.api.Assertions.*;

import com.groep6.pfor.factories.CityFactory;
import com.groep6.pfor.models.City;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests the placement of forts in a city.
 * @author Mitchell van Rijswijk
 *
 */
public class FortTest {
	
	private City city;

	@BeforeEach
	void setUp(){
		CityFactory cityFactory = CityFactory.getInstance();
		city = cityFactory.getCityByName("Roma");
	}

	@AfterEach
	void tearDown() {
		city = null;
	}

	@Test
	void placeFort() {
		city.placeFort();
		assertTrue(city.hasFort());
	}

}
