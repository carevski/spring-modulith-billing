package com.carevski.billing.invoice;

import lombok.Getter;
import org.jmolecules.ddd.types.AggregateRoot;
import org.jmolecules.ddd.types.Identifier;

import java.util.UUID;

@Getter
public class Invoice implements AggregateRoot<Invoice, Invoice.InvoiceIdentifier> {

	private final InvoiceIdentifier id;

	public Invoice() {
		this.id = new InvoiceIdentifier(UUID.randomUUID().toString());
	}

	public record InvoiceIdentifier(String invoiceNumber) implements Identifier {}
}
