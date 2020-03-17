package com.giffgaff.ims.controller;

import com.giffgaff.ims.dao.ProductDAO;
import com.giffgaff.ims.model.Product;
import com.giffgaff.ims.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.ui.Model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static javafx.beans.binding.Bindings.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@WebAppConfiguration
public class ProductControllerTest {

	private MockMvc mockMvc;
	private ProductController ProductController;

	@Test
	public void testAddProduct() throws Exception {
		Product product = new Product();
		product.setProductName("AppleJuice");
		product.setDescription("Made with Apples");
		product.setProductType("Juices");

		mockMvc.perform(post("/addproduct", 1).param("AppleJuice", "true").param("Made with Apples").param("Juices"))
				.andExpect(status().isOk());

		ArgumentCaptor<Product> productCaptor = ArgumentCaptor.forClass(Product.class);
		ArgumentCaptor<Model> modelCaptor = ArgumentCaptor.forClass(Model.class);
		verify(ProductController, times(1)).addProduct(productCaptor.capture(), modelCaptor.capture());
		assertThat(productCaptor.getValue().getProductName()).isEqualTo("AppleJuice");
		assertThat(productCaptor.getValue().getProductType()).isEqualTo("Juices");
	}

	public void viewAllProducts() throws Exception {

		this.mockMvc.perform(get("/viewallproducts")).andExpect(status().isOk())
				.andExpect(view().name("viewallproducts")).andDo(MockMvcResultHandlers.print()).andReturn();
	}
}
