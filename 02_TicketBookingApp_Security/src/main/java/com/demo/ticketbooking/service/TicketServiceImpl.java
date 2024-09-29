package com.demo.ticketbooking.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.ticketbooking.entity.Ticket;
import com.demo.ticketbooking.repository.TicketRepository;


@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepository ticketRepository;

	@Override
	public Ticket saveTicket(Ticket ticket) {
		return ticketRepository.save(ticket);
	}

	@Override
	public List<Ticket> fetchTicketList() {
		return (List<Ticket>) ticketRepository.findAll();
	}

	@Override
	public Ticket updateTicket(Ticket ticket, Long ticketId) {
		Ticket tcktDB = ticketRepository.findById(ticketId).get();
		
		if(Objects.nonNull(ticket.getPassengerName())
				&& !"".equalsIgnoreCase(ticket.getPassengerName())) {
			tcktDB.setPassengerName(ticket.getPassengerName());
		}

		 
        if (Objects.nonNull(
                ticket.getSourceStation())
            && !"".equalsIgnoreCase(
                ticket.getSourceStation())) {
            tcktDB.setSourceStation(
                ticket.getSourceStation());
        }
 
        if (Objects.nonNull(ticket.getDestinationStation())
            && !"".equalsIgnoreCase(
                ticket.getDestinationStation())) {
            tcktDB.setDestinationStation(
                ticket.getDestinationStation());
        }
        
        if (Objects.nonNull(ticket.getEmail())
        		&& !"".equalsIgnoreCase(
        				ticket.getEmail())) {
        	tcktDB.setEmail(
        			ticket.getEmail());
        }
 
        return ticketRepository.save(tcktDB);
    }
 
    // Delete operation
    @Override
    public void deleteTicketById(Long ticketId)
    {
        ticketRepository.deleteById(ticketId);
    }

	@Override
	public Ticket getTicketById(Long ticketId) {
		// TODO Auto-generated method stub
		return ticketRepository.findById(ticketId).get();
	}
}