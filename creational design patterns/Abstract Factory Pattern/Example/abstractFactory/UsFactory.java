package abstractFactory;

import invoice.StandardInvoice;
import invoice.ProformaInvoice;
import PaymentGateway.Stripe;
import PaymentGateway.PayPal;
import PaymentGateway.PaymentGateway;
import invoice.Invoice;


public class UsFactory implements Factory {
    @Override
    public PaymentGateway createPaymentFactory(String paymentGatewayType) {
        switch (paymentGatewayType.toLowerCase()) {
            case "stripe":
                return new Stripe();
            case "paypal":
                return new PayPal();
            default:
                throw new IllegalArgumentException("Invalid payment gateway type: " + paymentGatewayType);
        }
    }

    @Override
    public Invoice createInvoiceFactory(String invoiceType) {
        switch (invoiceType.toLowerCase()) {
            case "standard":
                return new StandardInvoice();
            case "proforma":
                return new ProformaInvoice();
            default:
                throw new IllegalArgumentException("Invalid invoice type: " + invoiceType);
        }
    }
}
