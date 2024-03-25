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
import com.jwy.tenantcenter.convertor.SiteConvertor;
import com.jwy.tenantcenter.dao.entity.SiteEntity;
import com.jwy.tenantcenter.dao.repository.SiteRepository;
import com.jwy.tenantcenter.pojo.bo.SiteBo;
import com.jwy.tenantcenter.pojo.dto.SiteDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * <p>
 *     Site的操作逻辑放这里
 * </p>
 *
 * @author Jiang Wanyu
 * @version 1.0
 * @date 2024/3/22
 */
@Slf4j
@Service
public class SiteService {

    @Autowired
    private SiteRepository siteRepository;
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private IdGeneratorClient idGeneratorClient;

    private final String getLatestTimeKey(){
        return "tenant:r:t";
    }

    public long getLatestTime(){
        String key = this.getLatestTimeKey();
        try {
            String timeStr = this.redisTemplate.opsForValue().get(key);
            return NumberUtils.toLong(timeStr);
        } catch (Exception e) {
            log.error("【SS062】getLatestTime error", e);
        }
        return 0;
    }

    public void updateLatestTime(long timestamp){
        String key = this.getLatestTimeKey();
        try {
            this.redisTemplate.opsForValue().set(key, timestamp+"", 1, TimeUnit.DAYS);
        } catch (Exception e) {
            log.error("【SS072】updateLatestTime error", e);
        }
    }

    /**
     * 获取所有可用的数据
     * @return
     */
    public List<SiteBo> getAllAvailableSites(){
        try {
            List<SiteEntity> siteEntities = this.siteRepository.findAll();
            List<SiteEntity> resultList = siteEntities.stream().filter(s -> s.getState() > 0).collect(Collectors.toList());
            return SiteConvertor.toSiteBoList(resultList);
        } catch (Exception e) {
            log.error("【SS086】getAllAvailableSites error", e);
            throw new TenantException(StatusUtils.TenantError, e);
        }
    }

    /**
     * 添加site
     * @param siteDto
     */
    public long addSite(SiteDto siteDto){

        SiteEntity siteEntity = SiteConvertor.toSiteEntity(siteDto);

        long id = this.idGeneratorClient.nextId();
        siteEntity.setId(id);

        try {
            this.siteRepository.save(siteEntity);
            this.updateLatestTime(System.currentTimeMillis());
            return id;
        } catch (Exception e) {
            log.error("【SS107】addSite error", e);
            throw new TenantException(StatusUtils.TenantError, e);
        }
    }

}
