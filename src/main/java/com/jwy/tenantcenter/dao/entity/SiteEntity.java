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
 *     站点信息
 * </p>
 * <p>
 *     站点site与租户tenant是 1-n关系。一个站点只能属于一个租户
 * </p>
 *
 * @author Jiang Wanyu
 * @version 1.0
 * @date 2024/3/22
 */
@Entity
@Data
@Table(name = "saas_site", indexes = {
        @Index(name = "idx_key", columnList = "siteKey")
})
public class SiteEntity extends AbstractSpecifyIdEntity {

    /**站点唯一标识*/
    @Column(length = 100, nullable = false, unique = true)
    private String siteKey;
    /**站点对应的域名信息*/
    @Column(length = 100, nullable = false)
    private String domainBase;
    /**站点状态：1-启用  0-关闭*/
    @Column(length = 1, nullable = false)
    private Integer state;

    /**租户的id*/
    private Long tenantId;
    /**对应的租户名称*/
    @Column(length = 100)
    private String tenantKey;
}
