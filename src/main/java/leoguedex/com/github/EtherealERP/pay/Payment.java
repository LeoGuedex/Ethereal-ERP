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

        
        PaymentTransaction transactionToUseForCurrency = transactions.stream()
                .filter(transaction -> (transaction.getTransactionType() == TransactionType.AUTHORIZE ||
                                        transaction.getTransactionType() == TransactionType.PURCHASE ||
                                        transaction.getTransactionType() == TransactionType.CREDIT) &&
                                      (TransactionStatus.SUCCESS.equals(transaction.getTransactionStatus()) ||
                                       TransactionStatus.PENDING.equals(transaction.getTransactionStatus())))
                .findFirst().orElse(null);

        if (transactionToUseForCurrency == null) {
            final List<PaymentTransaction> nonSuccessfulTransactions = transactions.stream()
                    .filter(transaction -> transaction.getTransactionType() == TransactionType.AUTHORIZE ||
                                           transaction.getTransactionType() == TransactionType.PURCHASE ||
                                           transaction.getTransactionType() == TransactionType.CREDIT)
                    .collect(Collectors.toUnmodifiableList());
            transactionToUseForCurrency = Iterables.getLast(nonSuccessfulTransactions);
        }

        this.currency = transactionToUseForCurrency == null ? null : transactionToUseForCurrency.getCurrency();

        this.authAmount = getAmountForTransactions(this.currency,
                                                   nonVoidedTransactions,
                                                   TransactionType.AUTHORIZE,
                                                   chargebackTransactions,
                                                   chargebackProcessedAmount,
                                                   chargebackProcessedCurrency,
                                                   chargebackAmount,
                                                   chargebackCurrency);
        this.captureAmount = getAmountForTransactions(this.currency,
                                                      nonVoidedTransactions,
                                                      TransactionType.CAPTURE,
                                                      chargebackTransactions,
                                                      chargebackProcessedAmount,
                                                      chargebackProcessedCurrency,
                                                      chargebackAmount,
                                                      chargebackCurrency);
        this.purchasedAmount = getAmountForTransactions(this.currency,
                                                        nonVoidedTransactions,
                                                        TransactionType.PURCHASE,
                                                        chargebackTransactions,
                                                        chargebackProcessedAmount,
                                                        chargebackProcessedCurrency,
                                                        chargebackAmount,
                                                        chargebackCurrency);
        this.creditAmount = getAmountForTransactions(this.currency,
                                                     nonVoidedTransactions,
                                                     TransactionType.CREDIT,
                                                     chargebackTransactions,
                                                     chargebackProcessedAmount,
                                                     chargebackProcessedCurrency,
                                                     chargebackAmount,
                                                     chargebackCurrency);
        this.refundAmount = getAmountForTransactions(this.currency,
                                                     nonVoidedTransactions,
                                                     TransactionType.REFUND,
                                                     chargebackTransactions,
                                                     chargebackProcessedAmount,
                                                     chargebackProcessedCurrency,
                                                     chargebackAmount,
                                                     chargebackCurrency);

        this.isAuthVoided = voidedTransactions
                .stream()
                .anyMatch(input -> input.getTransactionType() == TransactionType.AUTHORIZE &&
                                   TransactionStatus.SUCCESS.equals(input.getTransactionStatus()));
    }
}
