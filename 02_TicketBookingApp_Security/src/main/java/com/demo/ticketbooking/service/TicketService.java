package com.demo.ticketbooking.service;

import java.util.List;

import com.demo.ticketbooking.entity.Ticket;

public interface TicketService {

	//C
	Ticket saveTicket(Ticket ticket);
	
	//R
	List<Ticket> fetchTicketList();
	Ticket getTicketById(Long ticketId);
	
	//U
	Ticket updateTicket(Ticket ticket, Long ticketId);
	
	//D
	void deleteTicketById(Long ticketId);
	
}
