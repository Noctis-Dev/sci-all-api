package com.sci_all.demo.service.impl;

import com.mercadopago.client.preference.PreferenceClient;
import com.mercadopago.client.preference.PreferenceItemRequest;
import com.mercadopago.client.preference.PreferencePayerRequest;
import com.mercadopago.client.preference.PreferenceRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.preference.Preference;
import com.sci_all.demo.configuration.mp.MercadoPagoConfig;
import com.sci_all.demo.persistance.entities.Stream;
import com.sci_all.demo.persistance.entities.StreamDonation;
import com.sci_all.demo.persistance.entities.User;
import com.sci_all.demo.persistance.repositories.StreamDonationRepository;
import com.sci_all.demo.service.IDonationService;
import com.sci_all.demo.service.IStreamService;
import com.sci_all.demo.service.IUserService;
import com.sci_all.demo.utils.UUIDUtils;
import com.sci_all.demo.web.dto.BaseResponse;
import com.sci_all.demo.web.dto.request.DonationRequest;
import com.sci_all.demo.web.dto.response.DonationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class DonationServiceImpl implements IDonationService {

    @Autowired
    private MercadoPagoConfig config;

    @Autowired
    private StreamDonationRepository repository;

    @Autowired
    private IStreamService streamService;

    @Autowired
    private IUserService userService;

    @Override
    public BaseResponse donateToStream(UUID streamId, UUID authorId, DonationRequest request) {
        Stream stream = streamService.findOneAndEnsureExist(streamId);
        User user = userService.findOneAndEnsureExists(authorId);

        com.mercadopago.MercadoPagoConfig.setAccessToken(config.getAccessToken());

        PreferenceClient client = new PreferenceClient();

        PreferenceItemRequest item = PreferenceItemRequest.builder()
                .title("Donation to stream: " + streamId)
                .quantity(1)
                .unitPrice(BigDecimal.valueOf(request.amount()))
                .build();

        PreferenceRequest preferenceRequest = PreferenceRequest.builder()
                .items(List.of(item))
                .payer(PreferencePayerRequest.builder().email(request.email()).build())
                .build();

        Preference preference = null;

        try {
            preference = client.create(preferenceRequest);
        } catch (MPApiException | MPException e) {
            throw new RuntimeException(e);
        }

        StreamDonation donation = new StreamDonation();
        donation.setUuid(UUIDUtils.generateUniqueUUID(repository));
        donation.setAmount(request.amount());
        donation.setStream(stream);
        donation.setAuthor(user);

        repository.save(donation);

        return BaseResponse.builder()
                .data(toResponse(preference))
                .message("Donation created")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.OK)
                .status(200).build();
    }

    private DonationResponse toResponse(Preference preference) {
        return new DonationResponse(
                "Enlace de pago: " + preference.getInitPoint()
        );
    }

}
