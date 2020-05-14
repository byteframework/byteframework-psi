package com.byteframework.psi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.byteframework.psi.domain.Inventory;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 库存信息表 Mapper 接口
 * </p>
 *
 * @author sa
 * @since 2020-05-14
 */
public interface InventoryMapper extends BaseMapper<Inventory> {

    /**
     * 查询销售信息
     *
     * @return
     */
    IPage<Inventory> listInventory(IPage page, @Param("inventory") Inventory inventory);

}
