package com.byteframework.psi.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.byteframework.commons.exception.CustomException;
import com.byteframework.psi.domain.Inventory;
import com.byteframework.psi.domain.Sale;
import com.byteframework.psi.mapper.InventoryMapper;
import com.byteframework.psi.mapper.SaleMapper;
import com.byteframework.psi.service.SaleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <p>
 * 销售信息表 服务实现类
 * </p>
 *
 * @author sa
 * @since 2020-05-14
 */
@Service
public class SaleServiceImpl extends ServiceImpl<SaleMapper, Sale> implements SaleService {

    @Resource
    SaleMapper saleMapper;

    @Resource
    InventoryMapper inventoryMapper;


    /**
     * 查询销售信息
     *
     * @return
     */
    @Override
    public IPage<Sale> listSale(IPage page, Sale sale) {
        return saleMapper.listSale(page, sale);
    }

    /**
     * 保存销售信息
     * <p>
     * 流程：
     * 1. 保存销售信息
     * 2. 根据销售的产品编号查询库存信息
     * 3. 更新库存
     * </p>
     *
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveSale(Sale sale) throws CustomException {
        // 1. 保存销售信息
        saleMapper.insert(sale);

        // 2. 根据销售的产品编号查询库存信息
        Inventory inventory = new Inventory();
        inventory.setProductId(sale.getProductId());
        Wrapper<Inventory> queryWrapper = new QueryWrapper<>(inventory);
        inventory = inventoryMapper.selectOne(queryWrapper);

        // 3. 更新库存
        if (inventory == null) {
            throw new CustomException("销售出库时库存不存在,出库失败!");
        }
        // 销售出库的产品数量
        int saleQuantity = sale.getSaleQuantity();
        // 库存中的产品可用数量
        int stockQuantityAvailable = inventory.getStockQuantityAvailable();
        // 库存余量
        int overQuantity = stockQuantityAvailable - saleQuantity;
        if (overQuantity < 0) {
            throw new CustomException("销售出库的产品数量大于可用库存量,出库失败！");
        }
        // 更新库存量、可用库存量
        inventory.setStockQuantity(overQuantity);
        inventory.setStockQuantityAvailable(overQuantity);

        inventoryMapper.updateById(inventory);
    }
}
