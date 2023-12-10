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

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        final PaymentAttempt that = (PaymentAttempt) o;

        if (accountId != null ? !accountId.equals(that.accountId) : that.accountId != null) {
            return false;
        }
        if (paymentMethodId != null ? !paymentMethodId.equals(that.paymentMethodId) : that.paymentMethodId != null) {
            return false;
        }
        if (transactionId != null ? !transactionId.equals(that.transactionId) : that.transactionId != null) {
            return false;
        }
        if (transactionType != that.transactionType) {
            return false;
        }
        if (effectiveDate != null ? !effectiveDate.equals(that.effectiveDate) : that.effectiveDate != null) {
            return false;
        }
        if (stateName != null ? !stateName.equals(that.stateName) : that.stateName != null) {
            return false;
        }
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) {
            return false;
        }
        if (currency != that.currency) {
            return false;
        }
        if (pluginName != null ? !pluginName.equals(that.pluginName) : that.pluginName != null) {
            return false;
        }
        return pluginProperties != null ? pluginProperties.equals(that.pluginProperties)
                : that.pluginProperties == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (accountId != null ? accountId.hashCode() : 0);
        result = 31 * result + (paymentMethodId != null ? paymentMethodId.hashCode() : 0);
        result = 31 * result + (transactionId != null ? transactionId.hashCode() : 0);
        result = 31 * result + (transactionType != null ? transactionType.hashCode() : 0);
        result = 31 * result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
        result = 31 * result + (stateName != null ? stateName.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (pluginName != null ? pluginName.hashCode() : 0);
        result = 31 * result + (pluginProperties != null ? pluginProperties.hashCode() : 0);
        return result;
    }
}
