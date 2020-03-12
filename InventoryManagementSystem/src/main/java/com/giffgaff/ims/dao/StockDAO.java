package com.giffgaff.ims.dao;

import com.giffgaff.ims.model.Product;
import com.giffgaff.ims.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StockDAO extends JpaRepository<Stock, Long> {
    @Modifying
    @Query("update Stock stk set stk.totalCurrentStock = stk.totalCurrentStock +  :lot , stk.historyTotal = stk.historyTotal +  :lot")
    Stock manufactureProductsInLot(@Param("lot") Integer lot);

    public Stock findByProduct(Product product);

    @Modifying
    @Query("update Stock stk set stk.totalCurrentStock =   :lot , stk.historyTotal =  :lot where stk.product= :product")
    Stock manufactureProductInLot(@Param("product")Product product, @Param("lot") Integer lot);
}
