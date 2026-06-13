import PaymentGateway.PaymentGateway;
import abstractFactory.Factory;
import abstractFactory.IndiaFactory;
import invoice.Invoice;

public class CheckOutService {
    private PaymentGateway paymentGateway;
    private Invoice invoice;
    private double amount;

    public CheckOutService(Factory factory, String paymentGatewayType, String invoiceType, double amount) {
        this.paymentGateway = factory.createPaymentFactory(paymentGatewayType);
        this.invoice = factory.createInvoiceFactory(invoiceType);
        this.amount = amount;
    }

    public void checkOut() {
        paymentGateway.processPayment(amount);
        invoice.generateInvoice(amount);
    }
}
