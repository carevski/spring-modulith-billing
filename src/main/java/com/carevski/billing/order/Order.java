package com.carevski.billing.order;

import com.carevski.billing.customer.Customer;
import com.carevski.billing.customer.Customer.CustomerIdentifier;
import com.carevski.billing.order.Order.LineItem.LineItemId;
import com.carevski.billing.order.Order.OrderIdentifier;
import jakarta.persistence.Table;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.jmolecules.ddd.types.AggregateRoot;
import org.jmolecules.ddd.types.Association;
import org.jmolecules.ddd.types.Entity;
import org.jmolecules.ddd.types.Identifier;

@Getter
@Table(name = "Order")
public class Order implements AggregateRoot<Order, OrderIdentifier> {

	private final OrderIdentifier id;
	private final Association<Customer, CustomerIdentifier> customer;
	private Status status;

	private final List<LineItem> lineItems = new ArrayList<>();

	public Order(CustomerIdentifier customerId) {

		this.id = new OrderIdentifier(UUID.randomUUID());
		this.status = Status.OPEN;
		this.customer = Association.forId(customerId);
	}

	Order complete() {

		this.status = Status.COMPLETED;

		return this;
	}

	Order add(LineItem item) {

		this.lineItems.add(item);

		return this;
	}

	public record OrderIdentifier(UUID id) implements Identifier {}

	enum Status {
		OPEN, COMPLETED, CANCELLED;
	}

	@Getter
	static class LineItem implements Entity<Order, LineItemId> {

		private LineItemId id;
		private String description;
		private long amount;

		LineItem(String description, long amount) {

			this.id = new LineItemId(UUID.randomUUID());
			this.description = description;
			this.amount = amount;
		}

		record LineItemId(UUID id) implements Identifier {}
	}
}
