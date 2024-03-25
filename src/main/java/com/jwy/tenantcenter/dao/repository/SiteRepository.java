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
package com.jwy.tenantcenter.dao.repository;

import com.jwy.tenantcenter.dao.entity.SiteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *     SiteRepository
 * </p>
 *
 * @author Jiang Wanyu
 * @version 1.0
 * @date 2024/3/22
 */
@Repository
public interface SiteRepository extends JpaRepository<SiteEntity, Long> {


}
