package com.giffgaff.ims.main;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.giffgaff.ims.controller.ProductController;
import com.giffgaff.ims.controller.form.ProductForm;
import com.giffgaff.ims.model.Product;
import com.giffgaff.ims.service.ProductService;


@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

	private MockMvc mockMvc;
	
	@InjectMocks
	private ProductController productController;
	
	@Mock
	ProductService productService;

	@Test
	public void testAddProductWithNoErrors() throws Exception {
		ProductForm product = new ProductForm();
		product.setProductName("AppleJuice");
		product.setDescription("Made with Apples");
		product.setProductType("Juices");
		 Model model = new ExtendedModelMap();
		 ArgumentCaptor<ProductForm> productCaptor = ArgumentCaptor.forClass(ProductForm.class);
		 ArgumentCaptor<Model> modelCaptor = ArgumentCaptor.forClass(Model.class);
		 
		 BindingResult bindingResult = mock(BindingResult.class);
		 doReturn(false).when(bindingResult).hasFieldErrors();
		String output = productController.addProduct(product, model, bindingResult);
		verify(productService, times(1)).addProduct(productCaptor.capture());
		assertThat(productCaptor.getValue().getProductName()).isEqualTo("AppleJuice");
		
		assertEquals("jsp/productview", output);
		assertThat(productCaptor.getValue().getProductType()).isEqualTo("Juices");
		
	}
	
	@Test
	public void testAddProduct_WithErrors() throws Exception {
		ProductForm product = new ProductForm();
		product.setProductName("AppleJuice");
		product.setDescription("Made with Apples");
		product.setProductType("Juices");
		 Model model = new ExtendedModelMap();
		 ArgumentCaptor<ProductForm> productCaptor = ArgumentCaptor.forClass(ProductForm.class);
		 ArgumentCaptor<Model> modelCaptor = ArgumentCaptor.forClass(Model.class);
		 
		 BindingResult bindingResult = mock(BindingResult.class);
		 doReturn(true).when(bindingResult).hasFieldErrors();
		String output = productController.addProduct(product, model, bindingResult);
		
		assertEquals("jsp/addproduct", output);
		
	}
	
	@Test
	public void testViewAllProduct() throws Exception {
		Product inputProduct = new Product();
		inputProduct.setProductName("AppleJuice");
		inputProduct.setDescription("Made with Apples");
		inputProduct.setProductType("Juices");
		
		List<Product> l = new ArrayList<>();
		l.add(inputProduct);
		 Model model = new ExtendedModelMap();
		doReturn(l).when(productService).viewAllProducts();
		 
		String output = productController.viewAllProducts( model);
		
		Product outputProduct =  ((List<Product>) model.getAttribute("viewallproducts")).get(0);
		assertEquals("jsp/viewallproducts", output);
		
		assertEquals(inputProduct.getProductName(), outputProduct.getProductName());
		assertEquals(inputProduct.getDescription(), outputProduct.getDescription());
		assertEquals(inputProduct.getProductType(), outputProduct.getProductType());
		
		//assertThat(productCaptor.getValue().getProductType()).isEqualTo("Juices");
		
	}
	
	public void viewAllProducts() throws Exception {

		this.mockMvc.perform(get("/viewallproducts")).andExpect(status().isOk())
				.andExpect(view().name("viewallproducts")).andDo(MockMvcResultHandlers.print()).andReturn();
	}
}
