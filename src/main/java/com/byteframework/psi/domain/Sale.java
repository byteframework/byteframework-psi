package com.byteframework.psi.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 销售信息表
 * </p>
 *
 * @author sa
 * @since 2020-05-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("psi_sale")
public class Sale implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 销售单号
     */
    private String saleOrder;

    /**
     * 产品ID
     */
    private Long productId;

    /**
     * 产品类型
     */
    @TableField(exist = false)
    private String productType;

    /**
     * 产品名称
     */
    @TableField(exist = false)
    private String productName;

    /**
     * 产品型号
     */
    @TableField(exist = false)
    private String productModel;

    /**
     * 销售数量
     */
    private Integer saleQuantity;

    /**
     * 单价
     */
    private Double unitPrice;

    /**
     * 总金额
     */
    private Double totalPrice;

    /**
     * 销售日期
     */
    private String saleDate;

    /**
     * 客户ID
     */
    private Long customerId;

    /**
     * 客户名称
     */
    @TableField(exist = false)
    private String customerName;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 销售负责人
     */
    private String salePerson;


}
