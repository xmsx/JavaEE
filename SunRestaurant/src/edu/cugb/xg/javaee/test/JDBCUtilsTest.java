package edu.cugb.xg.javaee.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.cugb.xg.javaee.utils.JDBCUtils;

public class JDBCUtilsTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetConnection() {
		assertNotNull(JDBCUtils.getConnection());
	}

}
