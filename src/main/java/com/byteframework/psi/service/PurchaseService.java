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

}
