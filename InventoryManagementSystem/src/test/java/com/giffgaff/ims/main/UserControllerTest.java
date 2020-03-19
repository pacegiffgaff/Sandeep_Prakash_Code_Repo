package com.giffgaff.ims.main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.MapBindingResult;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.giffgaff.ims.controller.UserController;
import com.giffgaff.ims.model.User;
import com.giffgaff.ims.validator.UserValidator;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
	@Autowired
	private MockMvc mockMvc;
	 
	 @Mock
	 UserValidator userValidator;
	 
	@InjectMocks
	UserController userController;

	
   
    
	@Test
	public void test_registration() throws Exception {
		
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
         Model m = new ExtendedModelMap();
		
		String responseEntity = userController.registration(m);
		
		assertEquals("jsp/registration", responseEntity);
	}
	
	@Test
	public void test_registration_withUserForm() throws Exception {
		
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
         Model m = new ExtendedModelMap();
         User userForm =new User();
         BindingResult bindingResult =mock( MapBindingResult.class);
		
		//String responseEntity = userController.registration(userForm, bindingResult);
		
		//doNothing().when(userValidator).validator(any(Object.class), any(Errors.class));
		//assertEquals("jsp/registration", responseEntity);
	}
}
