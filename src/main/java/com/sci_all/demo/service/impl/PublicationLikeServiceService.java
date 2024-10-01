package com.sci_all.demo.service.impl;

import com.sci_all.demo.persistance.entities.Publication;
import com.sci_all.demo.persistance.entities.PublicationLike;
import com.sci_all.demo.persistance.entities.User;
import com.sci_all.demo.persistance.repositories.PublicationLikeRepository;
import com.sci_all.demo.service.IPublicationLikeService;
import com.sci_all.demo.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublicationLikeServiceService implements IPublicationLikeService {

    @Autowired
    private PublicationLikeRepository repository;

    @Override
    public void createPublicationLike(Publication publication, User user) {
        PublicationLike like = new PublicationLike();

        like.setPublication(publication);
        like.setAuthor(user);
        like.setUuid(UUIDUtils.generateUniqueUUID(repository));
        repository.save(like);
    }
}
