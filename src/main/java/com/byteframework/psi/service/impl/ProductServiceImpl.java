package com.byteframework.psi.service.impl;

import com.byteframework.psi.domain.Product;
import com.byteframework.psi.mapper.ProductMapper;
import com.byteframework.psi.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sa
 * @since 2020-05-14
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

}
