package com.giffgaff.mockito;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {

	@Test
	public void letsMockListSize() {
		List list = mock(List.class);
		when(list.size()).thenReturn(10);
		assertEquals(10, list.size());
	}

	@Test
	public void letsMockListSizeWithMultipleReturnValues() {
		List list = mock(List.class);
		when(list.size()).thenReturn(10).thenReturn(20);
		assertEquals(10, list.size()); // First Call
		assertEquals(20, list.size()); // Second Call
	}

	@Test
	public void letsMockListGet() {
		List<String> list = mock(List.class);
		when(list.get(0)).thenReturn("giffgaff-test");
		assertEquals("giffgaff-test", list.get(0));
		assertNull(list.get(1));
	}

	@Test
	public void letsMockListGetToThrowException() {
		List<String> list = mock(List.class);
		when(list.get(Mockito.anyInt())).thenThrow(
				new RuntimeException("Something went wrong"));
		list.get(0);
		assertThrows(RuntimeException.class,()->{
			String g= "RuntimeException";
		});
	}

	@Test
	public void letsMockListGetWithAny() {
		List<String> list = mock(List.class);
		Mockito.when(list.get(Mockito.anyInt())).thenReturn("giffgaff-test");
		// If you are using argument matchers, all arguments
		// have to be provided by matchers.
		assertEquals("giffgaff-test", list.get(0));
		assertEquals("giffgaff-test", list.get(1));
	}

	@Test
	public void bddAliases_UsingGivenWillReturn() {
		List<String> list = mock(List.class);

		//given
		given(list.get(Mockito.anyInt())).willReturn("giffgaff-test");

		//then
		MatcherAssert.assertThat("giffgaff-test", is(list.get(0)));
		MatcherAssert.assertThat("giffgaff-test", is(list.get(0)));
	}
}
