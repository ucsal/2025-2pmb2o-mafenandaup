package br.com.mariojp.solid.ocp;

import java.util.Map;

public class DiscountCalculator {
	
	private final Map<CustomerType, DiscountPolicy> policies; //A chave - CostumerType é o tipo de cliente que já está no ENUM(mesmo pacote).
	// já o DiscountPolicy é a política referente a aquele tipo de cliente
	
	 public DiscountCalculator() {
	        this.policies = Map.of(
	            CustomerType.REGULAR, new RegularPolicy(),
	            CustomerType.PREMIUM, new PremiumPolicy(), //a chave de cada política é o tipo, e o valor são as classes que implementam a interface discountPolicy.
	            CustomerType.PARTNER, new PartnerPolicy() // em cada classe haverá um método específico p calculo
	        );
	    }

    public double apply(double amount, CustomerType type){
    DiscountPolicy policy = policies.get(type); //resgata o tipo de cada política segundo o tipo de cliente.
	
    if (policy == null) { //se não há uma política mapeada, retorna a quantia de dinheiro original
    	return amount;
    }
    return policy.apply(amount); //retorna o método referente ao tipo da política do cliente. 
    }
}
