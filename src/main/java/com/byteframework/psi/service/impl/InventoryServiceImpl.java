package com.byteframework.psi.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.byteframework.psi.domain.Inventory;
import com.byteframework.psi.mapper.InventoryMapper;
import com.byteframework.psi.service.InventoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 库存信息表 服务实现类
 * </p>
 *
 * @author sa
 * @since 2020-05-14
 */
@Service
public class InventoryServiceImpl extends ServiceImpl<InventoryMapper, Inventory> implements InventoryService {

    @Resource
    InventoryMapper inventoryMapper;

    /**
     * 查询销售信息
     *
     * @return
     */
    @Override
    public IPage<Inventory> listInventory(IPage page, Inventory inventory) {
        return inventoryMapper.listInventory(page, inventory);
    }
}
