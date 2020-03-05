package com.giffgaff.junit.business;

import com.giffgaff.junit.business.exception.DifferentCurrenciesException;
import com.giffgaff.junit.model.Amount;
import com.giffgaff.junit.model.Product;

import java.util.List;

public interface ClientBO {

	Amount getClientProductsSum(List<Product> products)
			throws DifferentCurrenciesException;

}