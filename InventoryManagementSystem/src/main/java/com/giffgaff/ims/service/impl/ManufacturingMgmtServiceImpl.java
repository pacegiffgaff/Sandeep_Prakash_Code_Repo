package com.giffgaff.ims.service.impl;


import com.giffgaff.ims.dao.InventoryDAO;
import com.giffgaff.ims.dao.ProductDAO;
import com.giffgaff.ims.dao.StockDAO;
import com.giffgaff.ims.model.Inventory;
import com.giffgaff.ims.model.Product;
import com.giffgaff.ims.model.RawMaterial;
import com.giffgaff.ims.model.Stock;
import com.giffgaff.ims.service.ManufacturingMgmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ManufacturingMgmtServiceImpl implements ManufacturingMgmtService {


    @Autowired
    ProductDAO productDAO;

    @Autowired
    StockDAO stockDAO;

    @Autowired
    InventoryDAO inventoryDAO;

    @Override
    public RawMaterial addRawMaterial(RawMaterial rawMaterial) {
        return null;
    }

    @Override
    public List<RawMaterial> getRawMaterials() {
        return null;
    }

    @Override
    public Product addProduct(Product product) {
        return productDAO.save(product);
    }

	@Override
	public List<Product> getProducts() {

		List<Product> prodList = productDAO.findAll();
		for (Product product : prodList) {
			System.out.println("Product List : " + " " + product.getProductId() + " " + product.getProductName() + " "
					+ product.getProductComponentList().size() + " " + product.getSpecifications());
		}

		return prodList;
	}

    @Override
    public List<Stock> getStockOfAllProducts() {
        return null;
    }

    @Override
    public List<Inventory> getInventoryOfAllrawMaterials() {
        return null;
    }

    @Override
    public int manufactureProducts(int lot) {
        return 0;
    }

    @Override
    public Integer manufactureAllProductsinLot(Integer lot) {
        if(stockDAO.count()!=0)
        {
            return stockDAO.manufactureProductsInLot(lot);
        }
        return 0;
    }

    @Override
    public Stock manufactureProductInLot(Product product, Integer lot) {
        Stock stock= stockDAO.findByProduct(product);
        if(stock== null){
            stock = new Stock();
            stock.setProduct(product);
            stock.setHistoryTotal(lot);
            stock.setTotalCurrentStock(lot);
            return stockDAO.save(stock);
        }
        stockDAO.manufactureProductInLot(product,lot);
        inventoryDAO.updateRawmaterialonProduction(lot);
        return  stockDAO.findByProduct(product);
    }
}
