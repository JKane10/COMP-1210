import java.util.Random;
import java.text.DecimalFormat;

/**
 * This class will represent an order made at a laundry facility. It will store
 * the customer's last name, order code, the items that the customer would like
 * to have cleaned price of the order.
 * 
 * Project 4A
 * 
 * @author Joshua Kane - section 004
 * @version 2/09/11
 */
public class LaundryOrder {
	/** no discount. **/
	public static final int NO_DISCOUNT = 1;
	/** no discount. **/
	private static final double DISCOUNT_1 = 0.00;
	/** member discount of 10%. **/
	public static final int MEMBER_DISCOUNT = 2;
	/** member discount of 10%. **/
	private static final double DISCOUNT_2 = 0.10;
	/** business discount of 15%. **/
	public static final int BUSINESS_DISCOUNT = 3;
	/** business discount of 15%. **/
	private static final double DISCOUNT_3 = 0.15;
	/** manager discount of 25%. **/
	public static final int MANAGER_DISCOUNT = 4;
	/** manager discount of 25%. **/
	private static final double DISCOUNT_4 = 0.25;
	/** DRY_CLEANING Constant dry cleaning equals 6.80. **/
	private static final double DRY_CLEANING = 6.80;
	/** WASH Constant wash equals 3.50. **/
	private static final double WASH = 3.50;
	/**
	 * String variables for customers, order code, and specialty items.
	 **/
	private String customer, orderCode, specialtyItems;
	/**
	 * this generates a random number.
	 **/
	private Random gen = new Random();
	/**
	 * declares numbers of dry items, wash items, and a int for calculation.
	 **/
	private int num, dryItems, washItems, discountType;
	/**
	 * double for specailty price, the base price, and the total price.
	 **/
	private double specialtyPrice, basePrice, totalPrice, discount;
	/**
	 * default tax rate unless different.
	 **/
	private double tax = 0.08;
	/**
	 * Decimal format for final answer price.
	 **/
	private DecimalFormat fmt1 = new DecimalFormat("0.00");
	/**
	 * Deciaml format for percentage in toString.
	 **/
	private DecimalFormat fmt2 = new DecimalFormat("0");

	/**
	 * Constructor. Calls constructor and creates an object for customer name
	 * 
	 * @param customerName
	 *            this is the name of the customer.
	 **/
	public LaundryOrder(String customerName) {
		customer = customerName;
		num = gen.nextInt(99) + 100;
		if (customerName.length() < 3) {
			orderCode = customerName + num;
		} else {
			orderCode = customerName.substring(0, 3) + num;
		}
	}

	/**
	 * allows the user to set the order code rather than taking a randomly
	 * generated one.
	 * 
	 * @param orderCodeIn
	 *            this is the user defined ordercode.
	 * @return - returns the user defined ordercode as the ordercode.
	 **/
	public boolean setOrderCode(String orderCodeIn) {
		orderCodeIn = orderCodeIn.trim();
		if ((orderCodeIn == (null) || (orderCodeIn.equals("")))) {
			return false;
		} else {
			orderCode = orderCodeIn;
			return true;
		}
	}

	/**
	 * Sets the discount type given a single letter from the driver program.
	 * 
	 * @param discountTypeIn
	 *            number of the discount type.
	 * @return sets discount type.
	 **/
	public boolean setDiscountType(int discountTypeIn) {
		if (discountTypeIn == NO_DISCOUNT) {
			discount = DISCOUNT_1;
			return true;
		} else if (discountTypeIn == MEMBER_DISCOUNT) {
			discount = DISCOUNT_2;
			return true;
		} else if (discountTypeIn == BUSINESS_DISCOUNT) {
			discount = DISCOUNT_3;
			return true;
		} else if (discountTypeIn == MANAGER_DISCOUNT) {
			discount = DISCOUNT_4;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Applied the discount rate to the discount type.
	 * 
	 * 
	 * @return returns an integer
	 **/
	public int getDiscountType() {
		if (discount == DISCOUNT_1) {
			discountType = NO_DISCOUNT;
			return discountType;
		} else if (discount == DISCOUNT_2) {
			discountType = MEMBER_DISCOUNT;
			return discountType;
		} else if (discount == DISCOUNT_3) {
			discountType = BUSINESS_DISCOUNT;
			return discountType;
		} else if (discount == DISCOUNT_4) {
			discountType = MANAGER_DISCOUNT;
			return discountType;
		} else {
			return 0;
		}
	}

	/**
	 * returns string object holding order code.
	 * 
	 * @return - returns a string object
	 **/
	public String getOrderCode() {
		return orderCode;
	}

	/**
	 * takes integer as param that represents the number of items customer wants
	 * washed.
	 * 
	 * @param washItemsIn
	 *            Takes the number of wash items as an integer.
	 */
	public void setWashItems(int washItemsIn) {
		washItems = washItemsIn;
	}

	/**
	 * Takes integer as param that represents the number of items customer wants
	 * dried.
	 * 
	 * @param dryItemsIn
	 *            takes number of items to be dry cleaned as an integer
	 **/
	public void setDryCleanItems(int dryItemsIn) {
		dryItems = dryItemsIn;
	}

	/**
	 * Takes name of special item and price of special item and returns them.
	 * 
	 * @param specialItem
	 *            amount of special items as a string.
	 * @param specialPrice
	 *            the price of special items as a double.
	 **/
	public void setSpecialtyItem(String specialItem, double specialPrice) {
		specialtyItems = specialItem;
		specialtyPrice = specialPrice;
	}

	/**
	 * Takes paramater tax and defaults to 0.08% unless otherwise declared.
	 * 
	 * @param taxRate
	 *            takes tax as a double.
	 * @return true returns true and sets tax rate if the input is between 0 and
	 *         1.
	 */
	public boolean setTaxRate(double taxRate) {
		if ((taxRate < 1) && (taxRate > 0)) {
			tax = taxRate;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Takes no params and returns the base price as an unrounded double value.
	 * 
	 * @return - returns base price as an unrounded double
	 */
	public double getBasePrice() {
		basePrice = ((WASH * washItems) + (DRY_CLEANING * dryItems) + specialtyPrice);
		basePrice = basePrice - (basePrice * discount);
		return basePrice;
	}

	/**
	 * Takes no params and returns the total price as an unrounded double value.
	 * 
	 * @return - returns total price as an unrounded double value
	 **/
	public double getTotalPrice() {
		if (discount <= (0)) {
			totalPrice = ((getBasePrice() * tax) + getBasePrice());
		} else {
			totalPrice = (((getBasePrice() * tax)) + getBasePrice());
		}
		return totalPrice;
	}

	/**
	 * returns a string displaying last name, order code wash items, and dry
	 * cleaning.
	 * 
	 * @return - returns a string declaring name, order code, wash items and dry
	 *         cleaning as well as subtotal and total.
	 **/
	public String toString() {
		String output = ("");
		getDiscountType();
		if (specialtyItems == (null) && discount <= (0)) {
			output = ("Last Name:\t" + customer + "\nOrder Code:\t" + orderCode
					+ "\nWash Items:\t" + washItems + "\nDry Cleaning:\t"
					+ dryItems + "\n\rSubtotal:\t$"
					+ fmt1.format(getBasePrice()) + "\nTotal:\t\t$" + fmt1
					.format(getTotalPrice()));
		} else if (specialtyItems != (null) && discount <= (0)) {
			output = ("Last Name:\t" + customer + "\nOrder Code:\t" + orderCode
					+ "\nWash Items:t" + washItems + "\nDry Cleaning: "
					+ dryItems + "\nSpecialty Item:\t" + specialtyItems
					+ "\n\rSubtotal:\t$" + fmt1.format(getBasePrice())
					+ "\nTotal:\t$" + fmt1.format(getTotalPrice()));
		} else if (specialtyItems == (null) && discount > (0)) {
			output = ("Last Name:\t" + customer + "\nOrder Code:\t" + orderCode
					+ "\nWash Items:\t" + washItems + "\nDry Cleaning:\t"
					+ dryItems + "\n\rSubtotal:\t$"
					+ fmt1.format(getBasePrice()) + "\n** Discount applied: "
					+ fmt2.format(discount * 100) + "% **" + "\nTotal:\t\t$" + fmt1
					.format(getTotalPrice()));
		} else if (specialtyItems != (null) && discount > (0)) {
			output = ("Last Name:\t" + customer + "\nOrder Code:\t" + orderCode
					+ "\nWash Items:\t" + washItems + "\nDry Cleaning:\t"
					+ dryItems + "\nSpecialty Item:\t" + specialtyItems
					+ "\n\rSubtotal:\t$" + fmt1.format(getBasePrice())
					+ "\n** Discount applied: " + fmt2.format(discount * 100)
					+ "% **" + "\nTotal:\t\t$" + fmt1.format(getTotalPrice()));
		}
		return output;
	}
}