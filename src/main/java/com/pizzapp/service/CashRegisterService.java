package com.pizzapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pizzapp.entity.CashRegister;
import com.pizzapp.entity.Ticket;
import com.pizzapp.error.ErrorService;
import com.pizzapp.repository.*;

@Service
public class CashRegisterService {

	@Autowired
	private TicketRepository ticketRepository;
	@Autowired
	private CashRegisterRepository cashRegisterRepository;

	@Transactional
	public Ticket paymentticket(String idticket) throws ErrorService {

		Optional<Ticket> check = ticketRepository.findById(idticket);
		
		if (check != null) {
			Ticket ticket = check.get();
			if (ticket.getDelivery().equals(true)) {
				ticket.setStatus(false);
				ticket.setPayment(true);
				return ticketRepository.save(ticket);

			} else {
				throw new ErrorService("El pedido no puede ser facturado, por que todavia no fue entregado");
			}
		} else {
			throw new ErrorService("No se encuentra el pedido que desea facturar");

		}

	}

	@Transactional(readOnly = true)
	public List<CashRegister> findTrue() {
		return cashRegisterRepository.findTrue();
	}

	@Transactional(readOnly = true)
	public List<CashRegister> findFalse() {
		return cashRegisterRepository.findFalse();
	}

	@Transactional(readOnly = true)
	public List<CashRegister> findAll() {
		return cashRegisterRepository.findAll();
	}

}
