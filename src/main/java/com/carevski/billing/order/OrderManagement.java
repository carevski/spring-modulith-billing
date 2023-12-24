package com.carevski.billing.order;

import com.carevski.billing.customer.Customer;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.jmolecules.ddd.annotation.Service;

@Transactional
@Service
@RequiredArgsConstructor
public class OrderManagement {

	public Order create(Customer.CustomerIdentifier customerId) {
		return new Order(customerId);
	}

	public Order complete(Order order) {
		return order;
	}
}
