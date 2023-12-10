package leoguedex.com.github.EtherealERP.pay;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.UUID;

public class PaymentErrorEvent {
    private final String message;

    @JsonCreator
    public DefaultPaymentErrorEvent(@JsonProperty("accountId") final UUID accountId,
                                    @JsonProperty("paymentId") final UUID paymentId,
                                    @JsonProperty("paymentTransactionId") final UUID paymentTransactionId,
                                    @JsonProperty("amount") final BigDecimal amount,
                                    @JsonProperty("currency") final Currency currency,
                                    @JsonProperty("status") final TransactionStatus status,
                                    @JsonProperty("transactionType") final TransactionType transactionType,
                                    @JsonProperty("effectiveDate") final DateTime effectiveDate,
                                    @JsonProperty("apiPayment") final Boolean isApiPayment,
                                    @JsonProperty("message") final String message,
                                    @JsonProperty("userToken") final UUID userToken) {
        super(accountId, paymentId, paymentTransactionId, amount, currency, status, transactionType, effectiveDate, isApiPayment, userToken);
        this.message = message;
    }

    @JsonIgnore
    @Override
    public BusInternalEventType getBusEventType() {
        return BusInternalEventType.PAYMENT_ERROR;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    protected Class getPaymentInternalEventClass() {
        return DefaultPaymentErrorEvent.class;
    }
}

}
