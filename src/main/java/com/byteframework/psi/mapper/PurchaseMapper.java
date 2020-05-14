package com.byteframework.psi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.byteframework.psi.domain.Purchase;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 采购信息表 Mapper 接口
 * </p>
 *
 * @author sa
 * @since 2020-05-14
 */
public interface PurchaseMapper extends BaseMapper<Purchase> {

    /**
     * 查询采购信息
     *
     * @return
     */
    IPage<Purchase> listPurchase(IPage page, @Param("purchase") Purchase purchase);

}
