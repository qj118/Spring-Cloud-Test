package org.demon.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.demon.springcloud.domain.Storage;

/**
 * @author demon
 * @create 2020-12-24 14:20
 */
@Mapper
public interface StorageDao {

    void decrease(@Param("productId") Long productId, @Param("count") Integer count);

    Storage getByProductId(@Param("productId")Long productId);
}
