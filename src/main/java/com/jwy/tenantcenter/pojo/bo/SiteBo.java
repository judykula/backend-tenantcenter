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
package com.jwy.tenantcenter.pojo.bo;

import lombok.Data;

/**
 * <p>
 *     site bo
 * </p>
 *
 * @author Jiang Wanyu
 * @version 1.0
 * @date 2024/3/22
 */
@Data
public class SiteBo {

    private Long id;
    private String siteKey;
    private String domainBase;
    private Integer state;
    private Long tenantId;
    private String tenantKey;
    private Long createTime;
    private Long updateTime;
}
