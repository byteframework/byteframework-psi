package com.byteframework.psi.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.byteframework.psi.domain.Product;
import com.byteframework.psi.service.ProductService;
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
@RequestMapping("/product")
public class ProductController extends BaseAction {

    Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    ProductService productService;


    /**
    *  保存数据
    *
    * @param request
    * @param response
    * @param jsonObject
    */
    @RequestMapping(value = "/saveProduct")
    public void saveProduct(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject jsonObject) {
        Product product = jsonObject.toJavaObject(Product.class);
        product.setCreateTime(LocalDateTime.now());
        try {
            productService.save(product);
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
    @RequestMapping(value = "/listProduct")
    public void listProduct(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject jsonObject) {
        Product product = jsonObject.toJavaObject(Product.class);
        IPage<Product> page = jsonObject.toJavaObject(Page.class);
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>(product);
        queryWrapper.lambda().orderByDesc(Product :: getId);
        try {
            IPage<Product> list = productService.page(page, queryWrapper);
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
    @RequestMapping(value = "/updateProduct")
    public void updateProduct(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject jsonObject) {
        Product product = jsonObject.toJavaObject(Product.class);
        product.setUpdateTime(LocalDateTime.now());
        try {
            productService.updateById(product);
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
    @RequestMapping(value = "/removeProduct")
    public void removeProduct(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject jsonObject) {
        Product product = jsonObject.toJavaObject(Product.class);
        try {
            productService.removeById(product);
            this.responseSuccess("数据删除成功!", request, response);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            this.responseFailure("数据删除失败!", request, response);
        }
    }

}

