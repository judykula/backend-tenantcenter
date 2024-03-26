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
package com.jwy.tenantcenter.feign.server;

import com.jwy.medusa.mvc.MyResponse;
import com.jwy.tenantcenter.convertor.SiteConvertor;
import com.jwy.tenantcenter.pojo.bo.SiteBo;
import com.jwy.tenantcenter.service.SiteService;
import com.jwy.wisp.pojo.response.saas.TenantHostVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *     site feign server
 * </p>
 *
 * @author Jiang Wanyu
 * @version 1.0
 * @date 2024/3/26
 */
@RestController
@RequestMapping("/feign/site")
public class FeignSiteServer {

    @Autowired
    private SiteService siteService;

    @GetMapping("/updateTs")
    public MyResponse<Long> updateTs() {
        long latestTime = this.siteService.getLatestTime();
        return MyResponse.ofSuccess(latestTime);
    }

    @GetMapping("/hostAndTenants")
    public MyResponse<List<TenantHostVo>> hostAndTenants() {
        List<SiteBo> allAvailableSites = this.siteService.getAllAvailableSites();
        List<TenantHostVo> tenantHostVos = SiteConvertor.toTenantHostVoList(allAvailableSites);
        return MyResponse.ofSuccess(tenantHostVos);
    }

}
