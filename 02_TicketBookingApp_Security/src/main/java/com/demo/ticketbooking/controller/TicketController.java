package com.demo.ticketbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.ticketbooking.entity.Ticket;
import com.demo.ticketbooking.service.TicketService;

@RestController
@RequestMapping(value = "/tickets")
public class TicketController {

	@Autowired 
	private TicketService ticketService;
	 
    // Save operation
    @PostMapping("/create")
    public Ticket createTicket(@RequestBody Ticket inpObj) {
        return ticketService.saveTicket(inpObj);
    }
 
    // Read operation
    @GetMapping("/all")
    public Iterable<Ticket> getAllTickets() {
        return ticketService.fetchTicketList();
    }
 
   
    @GetMapping("/ticket/{ticketId}")
    public Ticket getTicket(@PathVariable("ticketId") Long ticketId) {
        return ticketService.getTicketById(ticketId);
    }

    // Update operation
    @PutMapping("/{ticketId}")
    public Ticket updateTicket(@RequestBody Ticket ticket, @PathVariable("id") Long ticketId) {
    	return ticketService.updateTicket(
    			ticket, ticketId);
    }
 
    // Delete operation
    @DeleteMapping("/tickets/{id}")
    public String deleteTicketById(@PathVariable("id") Long ticketId) {
        ticketService.deleteTicketById(
            ticketId);
        return "Deleted Successfully";
    }
}
