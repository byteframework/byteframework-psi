package com.byteframework.psi.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 采购信息表
 * </p>
 *
 * @author sa
 * @since 2020-05-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("psi_purchase")
public class Purchase implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 采购/入库单号
     */
    private String orderNumber;

    /**
     * 产品ID
     */
    private Long productId;

    /**
     * 产品类型
     */
    private String productType;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 产品型号
     */
    private String productModel;

    /**
     * 采购/入库数量
     */
    private Integer purchaseQuantity;

    /**
     * 单价
     */
    private Double unitPrice;

    /**
     * 总金额
     */
    private Double totalPrice;

    /**
     * 采购/入库日期
     */
    private String purchaseDate;

    /**
     * 供应商ID
     */
    private Long supplierId;

    /**
     * 供应商名称
     */
    private String supplierName;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 采购负责人
     */
    private String purchasePerson;


}
