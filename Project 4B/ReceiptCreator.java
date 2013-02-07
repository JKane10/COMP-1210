import java.util.Scanner;

/**
 * This class creates a reciept with user input and the laundryOrder class.
 * 
 * @author - Joshua Kane section 004
 * @version - 2/16/11
 **/

public class ReceiptCreator {

	/**
	 * This class creates a reciept with user input and the laundryOrder class.
	 * 
	 * @param args
	 *            user defined.
	 */

	public static void main(String[] args) {

		String name, discount;
		int washItems, dryItems;
		double tax, discountType;
		Scanner scan = new Scanner(System.in);

		// get user info, name
		System.out.print("Enter your name: ");
		name = scan.nextLine();

		// get info for number of items washed, dried, the discount, and tax
		System.out.print("How many items are being washed? ");
		washItems = Integer.parseInt(scan.nextLine());
		System.out.print("How many items are being dried? ");
		dryItems = Integer.parseInt(scan.nextLine());
		System.out.print("What is the tax rate? "
				+ "(this should be entered as a decimal.) ");
		tax = Double.parseDouble(scan.nextLine());
		if ((tax < 0) || (tax > 1)) {
			System.out.println("Invalid tax rate");
		}

		System.out.print("What discount should be applied? "
				+ "(Enter either n, m, b, or x) ");
		discount = scan.nextLine();

		// interactions
		LaundryOrder order = new LaundryOrder(name);

		order.setWashItems(washItems);
		order.setDryCleanItems(dryItems);
		order.setTaxRate(tax);

		if (discount.equals("n") || discount.equals("N")) {
			order.setDiscountType(LaundryOrder.NO_DISCOUNT);
			System.out.print(order);
		} else if (discount.equals("m") || discount.equals("M")) {
			order.setDiscountType(LaundryOrder.MEMBER_DISCOUNT);
			System.out.print(order);
		} else if (discount.equals("b") || discount.equals("B")) {
			order.setDiscountType(LaundryOrder.BUSINESS_DISCOUNT);
			System.out.print(order);
		} else if (discount.equals("x") || discount.equals("X")) {
			order.setDiscountType(LaundryOrder.MANAGER_DISCOUNT);
			System.out.print(order);
		} else {
			System.out.println("Invalid discount type");
		}

	}
}