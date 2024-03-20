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

import com.jwy.medusa.mvc.MyStatus;
import com.jwy.tenantcenter.common.exception.SampleException;
import com.jwy.tenantcenter.convertor.Sample1Convertor;
import com.jwy.tenantcenter.dao.entity.SampleEntity1;
import com.jwy.tenantcenter.dao.repository.SampleRepository1;
import com.jwy.tenantcenter.pojo.bo.SampleBo;
import com.jwy.tenantcenter.pojo.dto.SampleDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * <p>
 *     这个例子结合{@link SampleRepository1} 和 {@link SampleEntity1}使用
 *
 *     主要场景是主键的生成策略你要自己控制，比如在 {@link SampleEntity1}里配置了 "自增主键"
 * </p>
 * <p>
 *     这些是样例代码，在实际使用后删除
 * </p>
 *
 * @author Jiang Wanyu
 * @version 1.0
 * @date 2024/1/30
 */
@Slf4j
@Service
public class SampleService1 {

    @Autowired
    private SampleRepository1 sampleRepository1;

    public long add(SampleDto dto){

        SampleEntity1 entity1 = Sample1Convertor.toSampleEntity1(dto);
        Assert.notNull(dto, "SampleDto is null!");

        try {
            SampleEntity1 s = sampleRepository1.save(entity1);
            return s.getId();
        } catch (Exception e) {
            log.error("【SS058】add sampleDto fail", e);//log中的"【】"规则：取类名的大写字母+对应行数，方便在查询log是进行grep key抓取
            throw new SampleException(MyStatus.of(10000, "SampleException"), e);//TODO 这块要改成使用 公共jar内定义的 statusz
        }
    }

    public List<SampleBo> getAll(){
        List<SampleEntity1> all;
        try {
            all = this.sampleRepository1.findAll();
        } catch (Exception e) {
            log.error("【SS065】get all sampleDto fail", e);
            throw new SampleException(MyStatus.of(10000, "SampleException"), e);//TODO 这块要改成使用 公共jar内定义的 statusz
        }

        // .... do next

        return Sample1Convertor.toSampleBos(all);
    }

}
