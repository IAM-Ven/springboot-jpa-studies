package com.mycompany.jpabatch.service;

import com.mycompany.jpabatch.exception.PartnerNotFoundException;
import com.mycompany.jpabatch.model.Partner;
import com.mycompany.jpabatch.repository.PartnerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PartnerServiceImpl implements PartnerService {

    private final PartnerRepository partnerRepository;

    public PartnerServiceImpl(PartnerRepository partnerRepository) {
        this.partnerRepository = partnerRepository;
    }

    @Override
    public Partner savePartner(Partner partner) {
        return partnerRepository.save(partner);
    }

    @Override
    public Partner validateAndGetPartner(Long id) {
        return partnerRepository.findById(id)
                .orElseThrow(() -> new PartnerNotFoundException(String.format("Partner with id '%s' not found", id)));
    }

    @Transactional
    @Override
    public void deletePartner(Partner partner) {
        partnerRepository.delete(partner);
    }
}
