package com.giffgaff.ims.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.Authentication;

import com.giffgaff.ims.controller.form.ProductOrderForm;
import com.giffgaff.ims.dao.CartDAO;
import com.giffgaff.ims.dao.OrderDAO;
import com.giffgaff.ims.dao.ProductDAO;
import com.giffgaff.ims.dao.UserRepository;
import com.giffgaff.ims.model.Cart;
import com.giffgaff.ims.model.Product;
import com.giffgaff.ims.model.User;
import com.giffgaff.ims.service.IAuthenticationFacade;

@ExtendWith(MockitoExtension.class)
public class OrderServiceImplTest {

	@InjectMocks
	OrderServiceImpl orderServiceImpl;

	@Mock
	OrderDAO orderDAO;

	@Mock
	ProductDAO productDAO;

	@Mock
	CartDAO cartDAO;

	@Mock
	IAuthenticationFacade authenticationFacade;

	@Mock
	UserRepository userRepository;

	@Test
	public void test_Empty_ProductNameAndQuantityList() {
		ProductOrderForm productOrderForm = new ProductOrderForm();
		Map<String, Integer> productNameAndQuantityList = new HashMap<>();

		productOrderForm.setProductNameAndQuantityList(productNameAndQuantityList);

		orderServiceImpl.placeOrder(productOrderForm);

		verify(authenticationFacade, times(0)).getAuthentication();

	}

	@Test
	public void test_NotEmpty_ProductNameAndQuantityList() {
		ProductOrderForm productOrderForm = new ProductOrderForm();
		Map<String, Integer> productNameAndQuantityList = new HashMap<>();
		productNameAndQuantityList.put("Mango", 1000);

		productOrderForm.setProductNameAndQuantityList(productNameAndQuantityList);
		Authentication authentication = mock(Authentication.class);
		doReturn(authentication).when(authenticationFacade).getAuthentication();
		doReturn("Joy").when(authentication).getName();
		orderServiceImpl.placeOrder(productOrderForm);

		verify(authenticationFacade, times(1)).getAuthentication();
		verify(productDAO, times(1)).findByProductName(any());

	}

	@Test
	public void test_addProductToCart() {

		Product product = new Product();
		doReturn(product).when(productDAO).findByProductName(any());

		Authentication authentication = mock(Authentication.class);
		doReturn(authentication).when(authenticationFacade).getAuthentication();
		doReturn("Joy").when(authentication).getName();

		orderServiceImpl.addProductToCart("");
		verify(productDAO, times(1)).findByProductName(any());
		verify(authenticationFacade, times(1)).getAuthentication();
		verify(cartDAO, times(1)).findByUser_Username(any());
	}

	@Test
	public void test_getCartOfLoggedInUser() {
		Authentication authentication = mock(Authentication.class);
		doReturn(authentication).when(authenticationFacade).getAuthentication();
		doReturn("Joy").when(authentication).getName();

		orderServiceImpl.getCartOfLoggedInUser();
		verify(authenticationFacade, times(1)).getAuthentication();
		verify(cartDAO, times(1)).findByUser_Username(any());
	}

	@Test
	public void test_getProductAndQuantityOfLoggedInUser() {
		Authentication authentication = mock(Authentication.class);
		doReturn(authentication).when(authenticationFacade).getAuthentication();
		doReturn("Joy").when(authentication).getName();

		Cart cart = new Cart();
		cart.setCartId(100L);
		doReturn(cart).when(cartDAO).findByUser_Username(any());

		Cart outputCart = orderServiceImpl.getCartOfLoggedInUser();
		verify(authenticationFacade, times(1)).getAuthentication();
		verify(cartDAO, times(1)).findByUser_Username(any());
		assertEquals(outputCart.getCartId(), 100L);
	}
}
