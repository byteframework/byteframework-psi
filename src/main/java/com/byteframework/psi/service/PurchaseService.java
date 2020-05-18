package com.byteframework.psi.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.byteframework.psi.domain.Purchase;

/**
 * <p>
 * 采购信息表 服务类
 * </p>
 *
 * @author sa
 * @since 2020-05-14
 */
public interface PurchaseService extends IService<Purchase> {

    /**
     * 查询采购信息
     *
     * @return
     */
    IPage<Purchase> listPurchase(IPage page, Purchase purchase);


    /**
     * 保存采购信息
     * <p>
     * 流程：
     * 1. 保存采购信息
     * 2. 根据采购的产品编号查询库存信息， 库存中有此产品执行update操作， 库存中无此产品执行insert操作
     * 3. 更新库存
     * </p>
     *
     * @return
     */
    void savePurchase(Purchase purchase);

}
