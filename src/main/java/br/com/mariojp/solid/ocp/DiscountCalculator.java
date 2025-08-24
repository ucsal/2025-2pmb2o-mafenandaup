package br.com.mariojp.solid.ocp;

import java.util.Map;

public class DiscountCalculator {
	
	private final Map<CustomerType, DiscountPolicy> policies; //A chave - CostumerType é o tipo de cliente que já está no ENUM(mesmo pacote).
	// já o DiscountPolicy é a política referente a aquele tipo de cliente
	
	  public DiscountCalculator(Map<CustomerType, DiscountPolicy> policies) { // dentro do método há a instância do map das políticas de desconto
	        this.policies = policies; //construtor do calculador de desconto
	    }

    public double apply(double amount, CustomerType type){
    DiscountPolicy policy = policies.get(type); //
	
    if (policy == null) {
    	return amount;
    }
    return policy.apply(amount); //retorna o método referente ao tipo da política do cliente. 
    }
}
