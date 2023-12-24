package com.carevski.billing.customer;

import com.carevski.billing.customer.Customer.CustomerIdentifier;
import lombok.Getter;

import java.util.UUID;

import org.jmolecules.ddd.types.AggregateRoot;
import org.jmolecules.ddd.types.Identifier;

@Getter
public class Customer implements AggregateRoot<Customer, CustomerIdentifier> {

	private final CustomerIdentifier id;
	private final String address;

	public Customer(String address) {

		this.id = new CustomerIdentifier(UUID.randomUUID());
		this.address = address;
	}

	public record CustomerIdentifier(UUID id) implements Identifier {}
}
