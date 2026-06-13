package abstractFactory;

import PaymentGateway.PaymentGateway;
import invoice.Invoice;

public interface Factory {
    PaymentGateway createPaymentFactory(String paymentGatewayType);
    Invoice createInvoiceFactory(String invoiceType);
}
