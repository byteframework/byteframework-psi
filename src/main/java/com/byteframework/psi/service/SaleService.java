package com.byteframework.psi.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.byteframework.psi.domain.Sale;

/**
 * <p>
 * 销售信息表 服务类
 * </p>
 *
 * @author sa
 * @since 2020-05-14
 */
public interface SaleService extends IService<Sale> {

    /**
     * 查询销售信息
     *
     * @return
     */
    IPage<Sale> listSale(IPage page, Sale sale);
}
