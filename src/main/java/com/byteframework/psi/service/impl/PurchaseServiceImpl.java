package com.byteframework.psi.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.byteframework.psi.domain.Inventory;
import com.byteframework.psi.domain.Purchase;
import com.byteframework.psi.mapper.InventoryMapper;
import com.byteframework.psi.mapper.PurchaseMapper;
import com.byteframework.psi.service.PurchaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;

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

    @Resource
    InventoryMapper inventoryMapper;

    /**
     * 查询采购信息
     *
     * @return
     */
    @Override
    public IPage<Purchase> listPurchase(IPage page, Purchase purchase) {
        return purchaseMapper.listPurchase(page, purchase);
    }

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
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void savePurchase(Purchase purchase) {
        // 1. 保存采购信息
        purchaseMapper.insert(purchase);

        // 2. 根据采购的产品编号查询库存信息
        Inventory inventory = new Inventory();
        inventory.setProductId(purchase.getProductId());
        Wrapper<Inventory> queryWrapper = new QueryWrapper<>(inventory);
        inventory = inventoryMapper.selectOne(queryWrapper);
        // 3. 更新库存 (update/insert)
        if(inventory == null){
            inventory = new Inventory();
            inventory.setProductId(purchase.getProductId());
            inventory.setStockQuantity(purchase.getPurchaseQuantity());
            inventory.setStockQuantityAvailable(purchase.getPurchaseQuantity());
            inventory.setCreateTime(LocalDateTime.now());
            inventoryMapper.insert(inventory);
        }else{
            inventory.setStockQuantity(inventory.getStockQuantity() + purchase.getPurchaseQuantity());
            inventory.setStockQuantityAvailable(inventory.getStockQuantity());
            inventory.setUpdateTime(LocalDateTime.now());
            inventoryMapper.updateById(inventory);
        }

    }
}
