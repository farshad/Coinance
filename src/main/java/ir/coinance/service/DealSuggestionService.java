package ir.coinance.service;

import ir.coinance.config.security.SecurityUtils;
import ir.coinance.domain.DealSuggestion;
import ir.coinance.dto.DealSuggestionDto;
import ir.coinance.mapper.DealSuggestionMapper;
import ir.coinance.repository.DealSuggestionRepository;
import ir.coinance.repository.EnumTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class DealSuggestionService {

    @Autowired
    private DealSuggestionRepository repository;

    @Autowired
    private EnumTypeRepository enumTypeRepository;

    @Autowired
    private DealSuggestionMapper mapper;

    @Autowired
    private SecurityUtils securityUtils;

    @Transactional
    public DealSuggestionDto save(DealSuggestionDto dto){
        DealSuggestion dealSuggestion = mapper.toEntity(dto);
        dealSuggestion.setUser(securityUtils.getCurrentUser());

        return mapper.toDto(repository.save(dealSuggestion));
    }

    @Transactional
    public DealSuggestionDto updateStatus(Long id, Long statusId){
        DealSuggestion dealSuggestion = repository.findByIdAndUserId(id, securityUtils.getCurrentUser().getId());
        dealSuggestion.setStatus(enumTypeRepository.getOne(statusId));

        return mapper.toDto(repository.save(dealSuggestion));
    }

    @Transactional(readOnly = true)
    public Page<DealSuggestionDto> findByUser(Pageable pageable){
        return repository.findByUserId(securityUtils.getCurrentUser().getId(), pageable)
                .map(mapper::toDto);
    }

    @Transactional(readOnly = true)
    public Page<DealSuggestionDto> findByType(Long typeId, Pageable pageable){
        return repository.findByTypeIdOrderByCreatedDateDesc(typeId, pageable)
                .map(mapper::toDto);
    }
}
