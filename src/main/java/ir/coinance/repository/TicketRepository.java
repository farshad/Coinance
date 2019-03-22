package ir.coinance.repository;

import ir.coinance.domain.Ticket;
import ir.coinance.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    Page<Ticket> findByUserOrderByCreatedDateDesc(User user, Pageable pageable);
    Ticket findByIdAndUser(Long id, User user);
}
