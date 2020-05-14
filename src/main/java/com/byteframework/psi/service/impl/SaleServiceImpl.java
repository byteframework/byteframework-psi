package com.byteframework.psi.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.byteframework.psi.domain.Sale;
import com.byteframework.psi.mapper.SaleMapper;
import com.byteframework.psi.service.SaleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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


    /**
     * 查询销售信息
     *
     * @return
     */
    @Override
    public IPage<Sale> listSale(IPage page, Sale sale) {
        return saleMapper.listSale(page, sale);
    }
}
