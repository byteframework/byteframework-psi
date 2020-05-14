package com.byteframework.psi.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.byteframework.psi.domain.Inventory;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 库存信息表 服务类
 * </p>
 *
 * @author sa
 * @since 2020-05-14
 */
public interface InventoryService extends IService<Inventory> {

    /**
     * 查询销售信息
     *
     * @return
     */
    IPage<Inventory> listInventory(IPage page, Inventory inventory);

}
