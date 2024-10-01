package com.sci_all.demo.service;

import com.sci_all.demo.persistance.entities.Publication;
import com.sci_all.demo.persistance.entities.User;

public interface IPublicationLikeService {

    void createPublicationLike(Publication publication, User user);

}
