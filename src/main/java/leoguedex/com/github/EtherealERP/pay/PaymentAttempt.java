package leoguedex.com.github.EtherealERP.pay;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import com.github.javafaker.Currency;

public class PaymentAttempt {

    private final UUID accountId;
    private final UUID pamentMthodId;
    private final UUID transaction Id;
    private final BigDecimal amount;
    private final DateTime effectiveDate;
    private final String stateName;
    private final Currency currency;
    private final String pluginName;
    private final List<PluginProperty> pluginProperties;

    public PaymentAttempfinal UUID accountId,
    final UUID paymentMethodId,
    final UUID id,
    final DateTime createdDate,
    final DateTime updatedDate,
    final DateTime effectiveDate,
    final UUID transactionId,
    final TransactionType transactionType,
    final String stateName,
    final BigDecimal amount,
    final Currency currency,
    final String pluginName,
    final List<PluginProperty> pluginProperties)
    {
        super(id, createdDate, updatedDate);
        this.accountId = accountId;
        this.paymentMethodId = paymentMethodId;
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.effectiveDate = effectiveDate;
        this.stateName = stateName;
        this.amount = amount;
        this.currency = currency;
        this.pluginName = pluginName;
        this.pluginProperties = pluginProperties;
    }

    @Override
    public UUID getAccountId() {
        return accountId;
    }

    @Override
    public UUID getPaymentMethodId() {
        return paymentMethodId;
    }

    @Override
    public UUID getTransactionId() {
        return transactionId;
    }

    @Override
    public TransactionType getTransactionType() {
        return transactionType;
    }

    @Override
    public DateTime getEffectiveDate() {
        return effectiveDate;
    }

    @Override
    public String getStateName() {
        return stateName;
    }

    @Override
    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public Currency getCurrency() {
        return currency;
    }

    @Override
    public String getPluginName() {
        return pluginName;
    }

    @Override
    public List<PluginProperty> getPluginProperties() {
        return pluginProperties;
    }

    @Override
    public String toString() {
        return "DefaultPaymentAttempt{" +
                "accountId=" + accountId +
                ", paymentMethodId=" + paymentMethodId +
                ", transactionId=" + transactionId +
                ", transactionType=" + transactionType +
                ", effectiveDate=" + effectiveDate +
                ", stateName=" + stateName +
                ", amount=" + amount +
                ", currency=" + currency +
                ", pluginName='" + pluginName + '\'' +
                ", pluginProperties=" + pluginProperties +
                '}';
    }

    
}
