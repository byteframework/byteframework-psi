package com.byteframework.psi.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.byteframework.commons.web.BaseAction;
import com.byteframework.psi.domain.Sale;
import com.byteframework.psi.service.SaleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * <p>
 * 销售信息表 前端控制器
 * </p>
 *
 * @author sa
 * @since 2020-05-14
 */
@RestController
@RequestMapping("/sale")
public class SaleController extends BaseAction {

    Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    SaleService saleService;


    /**
     * 销售信息表 保存数据
     *
     * @param request
     * @param response
     * @param jsonObject
     */
    @RequestMapping(value = "/saveSale")
    public void saveSale(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject jsonObject) {
        Sale sale = jsonObject.toJavaObject(Sale.class);
        sale.setSaleDate(DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDateTime.now()));
        sale.setCreateTime(LocalDateTime.now());
        try {
            saleService.saveSale(sale);
            this.responseSuccess(request, response, "数据保存成功!");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            this.responseFailure(request, response, "销售出库失败!");
        }
    }


    /**
     * 销售信息表 分页查询
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/listSale")
    public void listSale(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject jsonObject) {
        Sale sale = jsonObject.toJavaObject(Sale.class);
        IPage<Sale> page = jsonObject.toJavaObject(Page.class);
        try {
            IPage<Sale> list = saleService.listSale(page, sale);
            this.responseSuccess(list, request, response);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            this.responseFailure(request, response, "分页查询失败!");
        }
    }


    /**
     * 销售信息表 修改数据
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/updateSale")
    public void updateSale(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject jsonObject) {
        Sale sale = jsonObject.toJavaObject(Sale.class);
        sale.setUpdateTime(LocalDateTime.now());
        try {
            saleService.updateById(sale);
            this.responseSuccess(request, response, "数据修改成功!");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            this.responseFailure(request, response, "数据修改失败!");
        }
    }


    /**
     * 销售信息表 删除数据
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/removeSale")
    public void removeSale(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject jsonObject) {
        Sale sale = jsonObject.toJavaObject(Sale.class);
        try {
            saleService.removeById(sale);
            this.responseSuccess(request, response, "数据删除成功!");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            this.responseFailure(request, response, "数据删除失败!");
        }
    }

}

