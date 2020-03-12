package com.giffgaff.ims.service.impl;

import com.giffgaff.ims.dao.ManufacturingMgmtDao;
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
    ManufacturingMgmtDao manufacturingMgmtDao;

    @Autowired
    ProductDAO productDAO;

    @Autowired
    StockDAO stockDAO;

    @Override
    public RawMaterial addRawMaterial(RawMaterial rawMaterial) {
        return manufacturingMgmtDao.save(rawMaterial);
    }

    @Override
    public List<RawMaterial> getRawMaterials() {
       return (List<RawMaterial>) manufacturingMgmtDao.findAll();
    }

    @Override
    public Product addProduct(Product product) {
        return productDAO.save(product);
    }

    @Override
    public List<Product> getProducts() {
        List<Product> productList = new ArrayList<>();
         productDAO.findAll().forEach(product->productList.add(product));
        return productList;
    }

    @Override
    public Stock manufactureAllProductsinLot(Integer lot) {
        if(stockDAO.count()!=0)
        {
            return stockDAO.manufactureProductsInLot(lot);
        }
       return new Stock();
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
        return  stock= stockDAO.manufactureProductInLot(product,lot);
    }

}
