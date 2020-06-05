package com.byteframework.psi.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.byteframework.psi.domain.Supplier;
import com.byteframework.psi.service.SupplierService;
import com.byteframework.commons.web.BaseAction;
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
 *  前端控制器
 * </p>
 *
 * @author sa
 * @since 2020-05-14
 */
@RestController
@RequestMapping("/supplier")
public class SupplierController extends BaseAction {

    Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    SupplierService supplierService;


    /**
    *  保存数据
    *
    * @param request
    * @param response
    * @param jsonObject
    */
    @RequestMapping(value = "/saveSupplier")
    public void saveSupplier(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject jsonObject) {
        Supplier supplier = jsonObject.toJavaObject(Supplier.class);
        supplier.setCreateTime(LocalDateTime.now());
        try {
            supplierService.save(supplier);
            this.responseSuccess("数据保存成功!", request, response);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            this.responseFailure("数据保存失败!", request, response);
        }
    }


    /**
     *  分页查询
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/listSupplier")
    public void listSupplier(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject jsonObject) {
        Supplier supplier = jsonObject.toJavaObject(Supplier.class);
        IPage<Supplier> page = jsonObject.toJavaObject(Page.class);
        Wrapper<Supplier> queryWrapper = new QueryWrapper<>(supplier);
        try {
            IPage<Supplier> list = supplierService.page(page, queryWrapper);
            this.responseSuccess(list, request, response);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            this.responseFailure("分页查询失败!", request, response);
        }
    }


    /**
     *  修改数据
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/updateSupplier")
    public void updateSupplier(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject jsonObject) {
        Supplier supplier = jsonObject.toJavaObject(Supplier.class);
        supplier.setUpdateTime(LocalDateTime.now());
        try {
            supplierService.updateById(supplier);
            this.responseSuccess("数据修改成功!", request, response);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            this.responseFailure("数据修改失败!", request, response);
        }
    }


    /**
     *  删除数据
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/removeSupplier")
    public void removeSupplier(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject jsonObject) {
        Supplier supplier = jsonObject.toJavaObject(Supplier.class);
        try {
            supplierService.removeById(supplier);
            this.responseSuccess("数据删除成功!", request, response);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            this.responseFailure("数据删除失败!", request, response);
        }
    }

}

