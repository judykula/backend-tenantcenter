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
package com.jwy.tenantcenter.common.util;

import com.jwy.medusa.mvc.MyStatus;
import com.jwy.medusa.mvc.MyStatusz;

/**
 * <p>
 *     定义自己的业务状态描述，用于web api 返回
 * </p>
 * <p>
 *     业务系统返回的状态码是5位数，请阅读{@link MyStatusz}的注解
 *
 *     其中前两位以标记业务，后面三位为状态码区间，步长为10(0～10之间用于后序补偿使用)
 * </p>
 * <p>
 *     20xxx
 * </p>
 *
 * @author archetype
 * @version 1.0
 * @date ${DATE}
 */
public class StatusUtils extends MyStatusz {

    public static MyStatus TenantError =  MyStatus.of(20010, "TenantError");


}
