package com.groep6.pfor.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.groep6.pfor.factories.CityFactory;
import com.groep6.pfor.models.City;

/**
 * Tests the placement of forts in a city.
 * @author Mitchell van Rijswijk
 *
 */
public class FortTest {
	
	private City city;

	@Before
	public void setUp() throws Exception {
		CityFactory cityFactory = CityFactory.getInstance();
		city = cityFactory.getCityByName("Roma");
	}

	@After
	public void tearDown() throws Exception {
		city = null;
	}

	@Test
	public void test() {
		city.placeFort();
		assertEquals(true, city.hasFort());
	}

}
