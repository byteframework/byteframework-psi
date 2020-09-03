package com.byteframework.psi.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.byteframework.commons.web.BaseAction;
import com.byteframework.psi.domain.Customer;
import com.byteframework.psi.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;


/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author sa
 * @since 2020-05-14
 */
@RestController
@RequestMapping("/customer")
public class CustomerController extends BaseAction {

    Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    CustomerService customerService;


    /**
     * 保存数据
     *
     * @param request
     * @param response
     * @param jsonObject
     */
    @RequestMapping(value = "/saveCustomer")
    public void saveCustomer(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject jsonObject) {
        Customer customer = jsonObject.toJavaObject(Customer.class);
        customer.setCreateTime(LocalDateTime.now());
        try {
            customerService.save(customer);
            this.responseSuccess(request, response, "数据保存成功!");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            this.responseFailure(request, response, "数据保存失败!");
        }
    }


    /**
     * 分页查询
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/listCustomer")
    public void listCustomer(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject jsonObject) {
        Customer customer = jsonObject.toJavaObject(Customer.class);
        IPage<Customer> page = jsonObject.toJavaObject(Page.class);
        Wrapper<Customer> queryWrapper = new QueryWrapper<>(customer);
        try {
            IPage<Customer> list = customerService.page(page, queryWrapper);
            this.responseSuccess(list, request, response);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            this.responseFailure(request, response, "分页查询失败!");
        }
    }


    /**
     * 修改数据
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/updateCustomer")
    public void updateCustomer(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject jsonObject) {
        Customer customer = jsonObject.toJavaObject(Customer.class);
        customer.setUpdateTime(LocalDateTime.now());
        try {
            customerService.updateById(customer);
            this.responseSuccess(request, response, "数据修改成功!");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            this.responseFailure(request, response, "数据修改失败!");
        }
    }


    /**
     * 删除数据
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/removeCustomer")
    public void removeCustomer(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject jsonObject) {
        Customer customer = jsonObject.toJavaObject(Customer.class);
        try {
            customerService.removeById(customer);
            this.responseSuccess(request, response, "数据删除成功!");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            this.responseFailure(request, response, "数据删除失败!");
        }
    }

}

