package com.byteframework.psi.service.impl;

import com.byteframework.psi.domain.Customer;
import com.byteframework.psi.mapper.CustomerMapper;
import com.byteframework.psi.service.CustomerService;
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
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {

}
