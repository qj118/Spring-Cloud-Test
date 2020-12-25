package org.demon.springcloud.service.impl;

import org.demon.springcloud.dao.StorageDao;
import org.demon.springcloud.domain.Storage;
import org.demon.springcloud.service.StorageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author demon
 * @create 2020-12-24 14:28
 */
@Service
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        storageDao.decrease(productId, count);
    }

    @Override
    public Storage getByProductId(Long productId) {
        return storageDao.getByProductId(productId);
    }
}
