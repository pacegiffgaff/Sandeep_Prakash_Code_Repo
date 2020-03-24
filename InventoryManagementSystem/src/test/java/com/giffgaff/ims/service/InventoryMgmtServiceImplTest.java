package com.giffgaff.ims.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.giffgaff.ims.dao.ProductDAO;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.runners.MockitoJUnitRunner;

import com.giffgaff.ims.model.Product;
import com.giffgaff.ims.service.impl.InventoryMgmtServiceImpl;

@ExtendWith(MockitoExtension.class)
public class InventoryMgmtServiceImplTest {


	@Mock
	ProductDAO productDAO;

	@InjectMocks
	InventoryMgmtServiceImpl inventoryMgmtServiceImpl;

	
	@Test
	public void testGetListOfProdcts() {
		
		List<Product> productList = new ArrayList<Product>();
		Product product = new Product();		
		product.setProductName("AppleJuice");
		product.setProductId(1L);
		product.setProductType("Juices");
		
		Product productobj = new Product();
		productobj.setProductName("AppleJuice");
		productobj.setProductId(1L);
		productobj.setProductType("Juices");
		
		productList.add(product);
		productList.add(productobj);
		when(productDAO.findAll()).thenReturn(productList);

		assertEquals(2, inventoryMgmtServiceImpl.getListOfProdcts().size());
	}
	
}
