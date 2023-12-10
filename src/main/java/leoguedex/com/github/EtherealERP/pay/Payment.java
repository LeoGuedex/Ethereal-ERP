package leoguedex.com.github.EtherealERP.pay;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Payment {

    private final UUID accountId;
    private final UUID paymentMthodId;
    private final Integer paymentNumber;
    private final BigDecimal authAmount;
    private final BigDecimal captureAmount;
    private final BigDecimal purchasedAmount;
    private final BigDecimal refundAmount;
    private final BigDecimal creditAmount;
    private final Currency currency;
    private final String status;
    private final Boolean isAuthVoided;

    private final List<PaymentAttempt> paymentAttempts;
    private final Lis<PaymentTransaction> transactions;

    public Payment(final UUID id, @Nullable final DateTime createdDate, @ Nullable final DateTime updatedDate, 
                          final UUID accountId,
                          final Integer paymentNumber,
                          final List<PaymentAttempt> paymentAttempts,
                          final List<PaymentTransaction> transactions){
        super(id, createdDate, updatedDate);
        this.accountId = accountId;
        this.paymentMethodId = paymentMethodId;
        this.paymentNumber = paymentNumber;
        this.paymentAttempts = paymentAttempts;
        this.transactions = transactions;

        final Collection<PaymentTransaction> nonVoidedTransactions = new LinkedList<>();
        final Collection<PaymentTransaction> voidedTransactions = new LinkedList<>();
        int voidVcRc = 0; // permite voi no captures, refunds e crédito.
        final List<PaymentTransaction> reversedPaymentTransactions = new ArrayList<>(transactions);
        Collections.reverse(reversedPaymentTransactions);
        for (final PaymentTransaction paymentTransaction : reversedPaymentTransactions) {
            if (TransactionStatus.SUCCESS.equals(paymentTransaction.getTransactionStatus())) {
                if (paymentTransaction.getTransactionType() == TransactionType.VOID) {
                    voidVcRc++;
                } else {
                    if (voidVcRc > 0) {
                        voidVcRc--;
                        voidedTransactions.add(paymentTransaction);
                    } else {
                        nonVoidedTransactions.add(paymentTransaction);
                    }
                }
            }
        }

        final BigDecimal chargebackAmount = chargebackCurrency == null ? BigDecimal.ZERO : getAmountForTransactions(chargebackTransactions, false);
        final Collection<PaymentTransaction> chargebackTransactions = getChargebackTransactions(transactions);
        final Currency chargebackCurrency = getCurrencyForTransactions(chargebackTransactions, false);
        final Currency chargebackProcessedCurrency = getCurrencyForTransactions(chargebackTransactions, true);
        final BigDecimal chargebackProcessedAmount = chargebackProcessedCurrency == null ? BigDecimal.ZERO : getAmountForTransactions(chargebackTransactions, true);

        
        
}
