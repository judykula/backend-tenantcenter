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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

    @Operation(
            summary = "获取最近的更新时间戳",
            description = "--",
            responses = {
                    @ApiResponse(responseCode = "200", description = "响应成功, 返回的是时间戳 millisecond"),
                    @ApiResponse(responseCode = "500", description = "响应失败",
                            content = @Content(schema = @Schema(implementation = MyResponse.class))
                    ),
                    @ApiResponse(responseCode = "20010", description = "通用的tenant业务异常",
                            content = @Content(schema = @Schema(implementation = MyResponse.class))
                    )
            }
    )
    @GetMapping("/updateTs")
    public MyResponse<Long> updateTs() {
        long latestTime = this.siteService.getLatestTime();
        return MyResponse.ofSuccess(latestTime);
    }

    @Operation(
            summary = "获取site的host-tenant对应列表",
            description = "--",
            responses = {
                    @ApiResponse(responseCode = "200", description = "响应成功"),
                    @ApiResponse(responseCode = "500", description = "响应失败",
                            content = @Content(schema = @Schema(implementation = MyResponse.class))
                    ),
                    @ApiResponse(responseCode = "20010", description = "通用的tenant业务异常",
                            content = @Content(schema = @Schema(implementation = MyResponse.class))
                    )
            }
    )
    @GetMapping("/hostAndTenants")
    public MyResponse<List<TenantHostVo>> hostAndTenants() {
        List<SiteBo> allAvailableSites = this.siteService.getAllAvailableSites();
        List<TenantHostVo> tenantHostVos = SiteConvertor.toTenantHostVoList(allAvailableSites);
        return MyResponse.ofSuccess(tenantHostVos);
    }

}
