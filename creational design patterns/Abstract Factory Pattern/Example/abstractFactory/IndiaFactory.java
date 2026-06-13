package abstractFactory;

import PaymentGateway.PaymentGateway;
import PaymentGateway.RazorPay;
import PaymentGateway.Stripe;
import invoice.GstInvoice;
import invoice.Invoice;
import invoice.RegularInvoice;
import PaymentGateway.Cashfree;

public class IndiaFactory implements Factory {

    @Override
    public PaymentGateway createPaymentFactory(String paymentGatewayType) {
        PaymentGateway paymentGateway;
        switch (paymentGatewayType) {
            case "RazorPay":
                paymentGateway = new RazorPay();
                break;
            case "Cashfree":
                paymentGateway = new Cashfree();
                break;
            default:
                throw new IllegalArgumentException("Invalid payment gateway type: " + paymentGatewayType);
        }
        return paymentGateway;
    }

    @Override
    public Invoice createInvoiceFactory(String invoiceType) {
        Invoice invoice;
        switch (invoiceType) {
            case "GstInvoice":
                invoice = new GstInvoice();
                break;
            case "RegularInvoice":
                invoice = new RegularInvoice();
                break;
            default:
                throw new IllegalArgumentException("Invalid invoice type: " + invoiceType);
        }
        return invoice;
    }
}
