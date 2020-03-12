package com.giffgaff.ims.service.impl;

import com.giffgaff.ims.dao.RawMaterialDao;
import com.giffgaff.ims.dao.ProductDAO;
import com.giffgaff.ims.dao.StockDAO;
import com.giffgaff.ims.model.Product;
import com.giffgaff.ims.model.RawMaterial;
import com.giffgaff.ims.model.Stock;
import com.giffgaff.ims.service.ManufacturingMgmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManufacturingMgmtServiceImpl implements ManufacturingMgmtService {

    @Autowired
    RawMaterialDao rawMaterialDao;

    @Autowired
    ProductDAO productDAO;

    @Autowired
    StockDAO stockDAO;

    @Override
    public RawMaterial addRawMaterial(RawMaterial rawMaterial) {
        return rawMaterialDao.save(rawMaterial);
    }

    @Override
    public List<RawMaterial> getRawMaterials() {
       return (List<RawMaterial>) rawMaterialDao.findAll();
    }

    @Override
    public Product addProduct(Product product) {
        return productDAO.save(product);
    }

    @Override
    public List<Product> getProducts() {
         return productDAO.findAll();
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
        return  stockDAO.findByProduct(product);
    }



}
