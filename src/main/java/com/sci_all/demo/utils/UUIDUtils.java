package com.sci_all.demo.utils;

import com.sci_all.demo.persistance.repositories.base.IBaseRepository;

import java.util.UUID;

public class UUIDUtils {

    public static UUID generateUniqueUUID(IBaseRepository<?, ?> repository) {
        UUID uuid = UUID.randomUUID();

        while (repository.findByUuid(uuid).isPresent()) {
            uuid = UUID.randomUUID();
        }

        return uuid;
    }

}
