package ir.coinance.service;

import ir.coinance.config.security.SecurityUtils;
import ir.coinance.config.security.exception.CustomException;
import ir.coinance.domain.Ticket;
import ir.coinance.domain.User;
import ir.coinance.dto.TicketAddDto;
import ir.coinance.dto.TicketDto;
import ir.coinance.dto.TicketFlatDto;
import ir.coinance.mapper.TicketMapper;
import ir.coinance.repository.EnumTypeRepository;
import ir.coinance.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TicketService {

    @Autowired
    private TicketRepository repository;

    @Autowired
    private TicketMapper mapper;

    @Autowired
    private SecurityUtils securityUtils;

    @Autowired
    private EnumTypeRepository enumTypeRepository;

    public TicketFlatDto add(TicketAddDto dto) throws CustomException {
        User user = securityUtils.getCurrentUser();
        Ticket ticket = new Ticket().builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .unit(enumTypeRepository.getOne(dto.getUnitId()))
                .status(enumTypeRepository.getOne(7L))
                .user(user)
                .build();

        return mapper.toDto(repository.save(ticket));
    }

    public TicketFlatDto updateStatus(Long id, Long statusId){
        Ticket ticket = repository.findByIdAndUser(id, securityUtils.getCurrentUser());
        ticket.setStatus(enumTypeRepository.getOne(statusId));

        return mapper.toDto(repository.save(ticket));
    }

    @Transactional(readOnly = true)
    public Page<TicketDto> findAll(Pageable pageable){
        return repository.findAll(pageable)
                .map(mapper::toTicketDto);
    }

    @Transactional(readOnly = true)
    public Page<TicketFlatDto> findByUser(Pageable pageable){
        return repository.findByUserOrderByCreatedDateDesc(
                securityUtils.getCurrentUser(), pageable)
                .map(mapper::toDto);
    }

}
