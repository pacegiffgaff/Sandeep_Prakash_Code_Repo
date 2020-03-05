package com.giffgaff.mockito;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class SpyTest {

	@Test
	public void creatingASpyOnArrayList() {
		List<String> listSpy = spy(ArrayList.class);
		listSpy.add("giffgaff");
		listSpy.add("spytest");

		verify(listSpy).add("giffgaff");
		verify(listSpy).add("spytest");

		assertEquals(2, listSpy.size());
		assertEquals("giffgaff", listSpy.get(0));
		
		when(listSpy.size()).thenReturn(10);
		assertEquals(10, listSpy.size());
	}

	@Test
	public void creatingASpyOnArrayList_overridingSpecificMethods() {
		List<String> listSpy = spy(ArrayList.class);
		listSpy.add("giffgaff");
		listSpy.add("spytest");

		assertEquals(-1, listSpy.size());
		assertEquals("giffgaff", listSpy.get(0));

		// @Spy Annotation
	}

}