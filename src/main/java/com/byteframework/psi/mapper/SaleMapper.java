package com.byteframework.psi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.byteframework.psi.domain.Sale;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 销售信息表 Mapper 接口
 * </p>
 *
 * @author sa
 * @since 2020-05-14
 */
public interface SaleMapper extends BaseMapper<Sale> {

    /**
     * 查询销售信息
     *
     * @return
     */
    IPage<Sale> listSale(IPage page, @Param("sale") Sale sale);
}
