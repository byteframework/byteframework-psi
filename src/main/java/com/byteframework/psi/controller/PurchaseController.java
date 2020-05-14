package com.byteframework.psi.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.byteframework.commons.web.BaseAction;
import com.byteframework.psi.domain.Purchase;
import com.byteframework.psi.service.PurchaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * <p>
 * 采购信息表 前端控制器
 * </p>
 *
 * @author sa
 * @since 2020-05-14
 */
@RestController
@RequestMapping("/purchase")
public class PurchaseController extends BaseAction {

    Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    PurchaseService purchaseService;


    /**
     * 采购信息表 保存数据
     *
     * @param request
     * @param response
     * @param jsonObject
     */
    @RequestMapping(value = "/savePurchase")
    public void savePurchase(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject jsonObject) {
        Purchase purchase = jsonObject.toJavaObject(Purchase.class);
        try {
            purchaseService.save(purchase);
            this.responseSuccess("数据保存成功!", request, response);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            this.responseFailure("数据保存失败!", request, response);
        }
    }


    /**
     * 采购信息表 分页查询
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/listPurchase")
    public void listPurchase(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject jsonObject) {
        Purchase purchase = jsonObject.toJavaObject(Purchase.class);
        IPage<Purchase> page = jsonObject.toJavaObject(Page.class);
        try {
            IPage<Purchase> list = purchaseService.listPurchase(page, purchase);
            this.responseSuccess(list, request, response);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            this.responseFailure("分页查询失败!", request, response);
        }
    }


    /**
     * 采购信息表 修改数据
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/updatePurchase")
    public void updatePurchase(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject jsonObject) {
        Purchase purchase = jsonObject.toJavaObject(Purchase.class);
        try {
            purchaseService.updateById(purchase);
            this.responseSuccess("数据修改成功!", request, response);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            this.responseFailure("数据修改失败!", request, response);
        }
    }


    /**
     * 采购信息表 删除数据
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/removePurchase")
    public void removePurchase(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject jsonObject) {
        Purchase purchase = jsonObject.toJavaObject(Purchase.class);
        try {
            purchaseService.removeById(purchase);
            this.responseSuccess("数据删除成功!", request, response);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            this.responseFailure("数据删除失败!", request, response);
        }
    }

}

