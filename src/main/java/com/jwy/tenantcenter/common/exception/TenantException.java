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
package com.jwy.tenantcenter.common.exception;

import com.jwy.medusa.common.exception.MyServiceException;
import com.jwy.medusa.mvc.MyStatus;
import com.jwy.tenantcenter.common.util.StatusUtils;

/**
 * <p>
 *     tenant exception
 * </p>
 *
 * @author Jiang Wanyu
 * @version 1.0
 * @date 2024/3/22
 */
public class TenantException extends MyServiceException {

    public TenantException() {
        super(StatusUtils.TenantError);
    }

    public TenantException(MyStatus status) {
        super(status);
    }

    public TenantException(MyStatus status, Throwable cause) {
        super(status, cause);
    }
}
