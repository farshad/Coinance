package ir.coinance.service;

import ir.coinance.config.security.SecurityUtils;
import ir.coinance.domain.SettlementRequest;
import ir.coinance.dto.SettlementRequestDto;
import ir.coinance.mapper.SettlementRequestMapper;
import ir.coinance.repository.EnumTypeRepository;
import ir.coinance.repository.SettlementRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SettlementRequestService {

    @Autowired
    private SettlementRequestRepository repository;

    @Autowired
    private SettlementRequestMapper mapper;

    @Autowired
    private SecurityUtils securityUtils;

    @Autowired
    private EnumTypeRepository enumTypeRepository;

    @Transactional
    public SettlementRequestDto add(Float amount){
        return mapper.toDto(repository.save(new SettlementRequest().builder()
                .amount(amount)
                .status(enumTypeRepository.findByKey("settlement_request_status_wait"))
                .user(securityUtils.getCurrentUser())
                .build()));
    }

    @Transactional
    public SettlementRequestDto updateStatus(Long id, Long statusId){
        SettlementRequest settlementRequest = repository.getOne(id);
        settlementRequest.setStatus(enumTypeRepository.getOne(statusId));

        if (settlementRequest.getStatus().getKey().equals("settlement_request_status_paid")){
            // send pay sms to customer
        }

        return mapper.toDto(repository.save(settlementRequest));
    }

    @Transactional(readOnly = true)
    public Page<SettlementRequestDto> findAll(Pageable pageable){
        return repository.findAll(pageable)
                .map(mapper::toDto);
    }
}
