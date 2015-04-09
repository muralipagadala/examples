package com.murali.sql.groovy.jdbc;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.murali.sql.groovy.jdbc.Product;
import com.murali.sql.groovy.jdbc.ProductDAO;
import com.murali.sql.groovy.jdbc.SqlProductDAO;

public class SqlProductDAOTest {

	private ProductDAO dao;
	
	@Before
	public void setUpDatabase()throws Exception{
		dao = new SqlProductDAO();
	}
	
	@Test
	public void testGetAllProducts(){
		assertEquals(3, dao.getAllProducts().size());
	}
	
	@Test
    public void testFindProductById() {
        Product p = dao.findProductById(1);
        assertEquals(1, p.getId());
        assertEquals("baseball", p.getName());
    }
}
