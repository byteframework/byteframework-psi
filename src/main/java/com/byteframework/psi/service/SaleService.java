package com.byteframework.psi.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.byteframework.commons.exception.CustomException;
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
    void saveSale(Sale sale) throws CustomException;
}
