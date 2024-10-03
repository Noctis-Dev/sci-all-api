package com.sci_all.demo.persistance.repositories;

import com.sci_all.demo.persistance.entities.StreamDonation;
import com.sci_all.demo.persistance.repositories.base.IBaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreamDonationRepository extends IBaseRepository<StreamDonation, Long> {
}