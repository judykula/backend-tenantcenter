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
package com.jwy.tenantcenter.web;

import com.jwy.medusa.mvc.MyResponse;
import com.jwy.tenantcenter.convertor.SiteConvertor;
import com.jwy.tenantcenter.pojo.bo.SiteBo;
import com.jwy.tenantcenter.pojo.dto.SiteDto;
import com.jwy.tenantcenter.pojo.dto.TenantDto;
import com.jwy.tenantcenter.service.SiteService;
import com.jwy.tenantcenter.service.TenantService;
import com.jwy.wisp.pojo.response.saas.TenantHostVo;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *     测试用的Controller
 * </p>
 *
 * @author archetype
 * @version 1.0
 * @date ${DATE}
 */
@RestController
@RequestMapping("/test")
@Tag(name = "TEST", description = "测试接口")
public class TestController {

    @Autowired
    private SiteService siteService;
    @Autowired
    private TenantService tenantService;

    @GetMapping("/t1")
    public MyResponse t1() {

        TenantDto tenantDto = new TenantDto();
        tenantDto.setTenantKey("jwy");
        tenantDto.setTenantDesc("this is default tenant");
        tenantDto.setCreatorId(123456l);
        tenantDto.setCreatorName("jiangwy");
        tenantDto.setState(1);

        long tenantId = this.tenantService.addTenant(tenantDto);

        SiteDto siteDto = new SiteDto();
        siteDto.setSiteKey("defaultSite1");
        siteDto.setDomainBase("localhost");
        siteDto.setTenantKey("jwy");
        siteDto.setTenantId(tenantId);
        siteDto.setState(1);

        this.siteService.addSite(siteDto);

        return MyResponse.ofSuccess();
    }

    @GetMapping("/t2")
    public MyResponse t2(String siteKey, String host) {

        SiteDto siteDto = new SiteDto();
        siteDto.setSiteKey(siteKey);
        siteDto.setDomainBase(host);
        siteDto.setTenantKey("jwy");
        siteDto.setTenantId(969699323652739072l);
        siteDto.setState(1);

        this.siteService.addSite(siteDto);

        return MyResponse.ofSuccess();
    }

    @GetMapping("/t3")
    public MyResponse<Long> t3() {
        long latestTime = this.siteService.getLatestTime();
        return MyResponse.ofSuccess(latestTime);
    }

    @GetMapping("/t4")
    public MyResponse<List<TenantHostVo>> t4() {
        List<SiteBo> allAvailableSites = this.siteService.getAllAvailableSites();
        List<TenantHostVo> tenantHostVos = SiteConvertor.toTenantHostVoList(allAvailableSites);
        return MyResponse.ofSuccess(tenantHostVos);
    }

}
