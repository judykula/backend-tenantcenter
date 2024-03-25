/*
 * easy come, easy go.
 *
 * contact : syiae.jwy@gmail.com
 *
 * · · · · ||   ..     __       ___      ____  ®
 * · · · · ||  ||  || _ ||   ||    ||   ||      ||
 * · · · · ||  ||  \\_ ||_.||    ||   \\_  ||
 * · · _//                                       ||
 * · · · · · · · · · · · · · · · · · ·· ·    ___//
 */
package com.jwy.tenantcenter.dao.entity;

import com.jwy.warlock.strategy.AbstractSpecifyIdEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 * <p>
 *     租户信息
 * </p>
 *
 * @author Jiang Wanyu
 * @version 1.0
 * @date 2024/3/22
 */
@Entity
@Data
@Table(name = "saas_tenant", indexes = {
        @Index(name = "idx_key", columnList = "tenantKey"),
        @Index(name = "idx_ctime", columnList = "createTime")
})
public class TenantEntity extends AbstractSpecifyIdEntity {

    /**租户空间唯一标识*/
    @Column(length = 100, nullable = false, unique = true)
    private String tenantKey;
    /**租户空间描述*/
    private String tenantDesc;
    /**状态：1-启用  0-关闭*/
    @Column(length = 1, nullable = false)
    private Integer state;
    /**创建人Id*/
    private Long creatorId;
    /**创建人姓名*/
    @Column(length = 255)
    private String creatorName;

}
