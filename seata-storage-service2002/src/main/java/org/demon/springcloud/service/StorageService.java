package org.demon.springcloud.service;

import org.demon.springcloud.domain.Storage;

/**
 * @author demon
 * @create 2020-12-24 14:27
 */
public interface StorageService {

    void decrease(Long productId, Integer count);

    Storage getByProductId(Long productId);

}
