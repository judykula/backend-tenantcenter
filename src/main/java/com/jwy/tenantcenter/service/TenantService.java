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
package com.jwy.tenantcenter.service;

import com.jwy.arcwarden.IdGeneratorClient;
import com.jwy.tenantcenter.common.exception.TenantException;
import com.jwy.tenantcenter.common.util.StatusUtils;
import com.jwy.tenantcenter.convertor.TenantConvertor;
import com.jwy.tenantcenter.dao.entity.TenantEntity;
import com.jwy.tenantcenter.dao.repository.TenantRepository;
import com.jwy.tenantcenter.pojo.dto.TenantDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *     tenant的逻辑放这里
 * </p>
 *
 * @author Jiang Wanyu
 * @version 1.0
 * @date 2024/3/22
 */
@Slf4j
@Service
public class TenantService {

    @Autowired
    private TenantRepository tenantRepository;
    @Autowired
    private IdGeneratorClient idGeneratorClient;

    /**
     * 添加tenant
     * @param tenantDto
     */
    public long addTenant(TenantDto tenantDto){

        TenantEntity tenantEntity = TenantConvertor.toTenantEntity(tenantDto);

        long id = this.idGeneratorClient.nextId();
        tenantEntity.setId(id);

        try {
            this.tenantRepository.save(tenantEntity);
            return id;
        } catch (Exception e) {
            log.error("【TS053】save tenant error", e);
            throw new TenantException(StatusUtils.TenantError, e);
        }
    }


}
