import java.util.Map;

import br.com.mariojp.solid.ocp.*;

public class Main {
	public static void main(String[] args) {
		
		Map<CustomerType, DiscountPolicy> policies = Map.of( //a chave de cada política é o tipo, e o valor são as classes que implementam a interface discountPolicy.
		CustomerType.REGULAR, new RegularPolicy(), CustomerType.PARTNER, new PartnerPolicy(), CustomerType.PREMIUM, new PremiumPolicy());
		
		DiscountCalculator calc = new DiscountCalculator(policies); 
	}
}
