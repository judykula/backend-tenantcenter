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
package com.jwy.tenantcenter.convertor;

import com.jwy.tenantcenter.dao.entity.TenantEntity;
import com.jwy.tenantcenter.pojo.dto.TenantDto;

/**
 * <p>
 *     tenant convertor
 * </p>
 *
 * @author Jiang Wanyu
 * @version 1.0
 * @date 2024/3/25
 */
public class TenantConvertor {

    public static TenantEntity toTenantEntity(TenantDto tenantDto) {
        if (tenantDto == null) {
            return null;
        }
        TenantEntity tenantEntity = new TenantEntity();
        tenantEntity.setTenantKey(tenantDto.getTenantKey());
        tenantEntity.setTenantDesc(tenantDto.getTenantDesc());
        tenantEntity.setState(tenantDto.getState());
        tenantEntity.setCreatorId(tenantDto.getCreatorId());
        tenantEntity.setCreatorName(tenantDto.getCreatorName());
        return tenantEntity;
    }
}
