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
package com.jwy.tenantcenter.pojo.dto;

import lombok.Data;

/**
 * <p>
 *     site dto
 * </p>
 *
 * @author Jiang Wanyu
 * @version 1.0
 * @date 2024/3/25
 */
@Data
public class SiteDto {
    private String siteKey;
    private String domainBase;
    private Integer state;
    private Long tenantId;
    private String tenantKey;
}
