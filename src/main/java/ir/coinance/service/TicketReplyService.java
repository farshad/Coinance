package ir.coinance.service;

import ir.coinance.config.security.SecurityUtils;
import ir.coinance.config.security.exception.CustomException;
import ir.coinance.dto.TicketReplyDto;
import ir.coinance.mapper.TicketReplyMapper;
import ir.coinance.repository.TicketReplyRepository;
import ir.coinance.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;

@Service
public class TicketReplyService {

    @Autowired
    private TicketReplyRepository repository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private TicketReplyMapper mapper;

    @Autowired
    private SecurityUtils securityUtils;

    @Autowired
    private MessageSource messageSource;

    @Transactional
    public TicketReplyDto add(TicketReplyDto dto) {
        checkTicketOwner(dto.getTicketId());
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    @Transactional
    public void delete(Long id, Long ticketId){
        checkTicketOwner(ticketId);
        repository.deleteById(id);
    }

    private void checkTicketOwner(Long ticketId){
        if(ticketRepository.findByIdAndUser(ticketId,
                securityUtils.getCurrentUser()) == null ||
                !securityUtils.isCurrentUserInRole("ROLE_ADMIN")){
            throw new CustomException(messageSource.getMessage("illegal.request", null, Locale.US));
        }
    }

}
