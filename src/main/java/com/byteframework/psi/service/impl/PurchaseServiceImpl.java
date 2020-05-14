package com.byteframework.psi.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.byteframework.psi.domain.Purchase;
import com.byteframework.psi.mapper.PurchaseMapper;
import com.byteframework.psi.service.PurchaseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 采购信息表 服务实现类
 * </p>
 *
 * @author sa
 * @since 2020-05-14
 */
@Service
public class PurchaseServiceImpl extends ServiceImpl<PurchaseMapper, Purchase> implements PurchaseService {

    @Resource
    PurchaseMapper purchaseMapper;

    /**
     * 查询采购信息
     *
     * @return
     */
    @Override
    public IPage<Purchase> listPurchase(IPage page, Purchase purchase) {
        return purchaseMapper.listPurchase(page, purchase);
    }
}
