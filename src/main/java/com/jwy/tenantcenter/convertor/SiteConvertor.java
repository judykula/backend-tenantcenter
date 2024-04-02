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

import com.jwy.tenantcenter.dao.entity.SiteEntity;
import com.jwy.tenantcenter.pojo.bo.SiteBo;
import com.jwy.tenantcenter.pojo.dto.SiteDto;
import com.jwy.wisp.pojo.response.saas.TenantHostVo;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>
 *     site convertor
 * </p>
 *
 * @author Jiang Wanyu
 * @version 1.0
 * @date 2024/3/22
 */
public class SiteConvertor {

    public static SiteBo toSiteBo(SiteEntity siteEntity) {
        if (siteEntity == null) {
            return null;
        }
        SiteBo siteBo = new SiteBo();
        siteBo.setId(siteEntity.getId());
        siteBo.setSiteKey(siteEntity.getSiteKey());
        siteBo.setDomainBase(siteEntity.getDomainBase());
        siteBo.setState(siteEntity.getState());
        siteBo.setTenantId(siteEntity.getTenantId());
        siteBo.setTenantKey(siteEntity.getTenantKey());
        siteBo.setCreateTime(siteEntity.getCreateTime());
        siteBo.setUpdateTime(siteEntity.getUpdateTime());
        return siteBo;
    }

    public static List<SiteBo> toSiteBoList(List<SiteEntity> siteEntityList) {
        return siteEntityList.stream().map(SiteConvertor::toSiteBo).filter(Objects::nonNull).collect(Collectors.toList());
    }

    public static SiteEntity toSiteEntity(SiteDto siteDto) {
        if (siteDto == null) {
            return null;
        }
        SiteEntity siteEntity = new SiteEntity();
        siteEntity.setSiteKey(siteDto.getSiteKey());
        siteEntity.setDomainBase(siteDto.getDomainBase());
        siteEntity.setState(siteDto.getState());
        siteEntity.setTenantId(siteDto.getTenantId());
        siteEntity.setTenantKey(siteDto.getTenantKey());

        return siteEntity;
    }

    public static TenantHostVo toTenantHostVo(SiteBo sitebo) {
        return new TenantHostVo(sitebo.getTenantKey(), sitebo.getDomainBase());
    }

    public static List<TenantHostVo> toTenantHostVoList(List<SiteBo> siteboList) {
        return siteboList.stream().map(SiteConvertor::toTenantHostVo).collect(Collectors.toList());
    }
}
