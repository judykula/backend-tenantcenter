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
 *     Tenant Dto
 * </p>
 *
 * @author Jiang Wanyu
 * @version 1.0
 * @date 2024/3/25
 */
@Data
public class TenantDto {

    private String tenantKey;
    private String tenantDesc;
    private Integer state;
    private Long creatorId;
    private String creatorName;

}
