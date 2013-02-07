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
	private int num, dryItems, washItems;
	/**
	 * double for specailty price, the base price, and the total price.
	 **/
	private double specialtyPrice, basePrice, totalPrice;
	/**
	 * default tax rate unless different.
	 **/
	private double tax = 0.08;
	/**
	 * Decimal format for final answer price.
	 **/
	private DecimalFormat fmt1 = new DecimalFormat("0.00");

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
		return basePrice;
	}

	/**
	 * Takes no params and returns the total price as an unrounded double value.
	 * 
	 * @return - returns total price as an unrounded double value
	 **/
	public double getTotalPrice() {
		totalPrice = ((getBasePrice() * tax) + getBasePrice());
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
		if (specialtyItems == (null)) {
			output = ("Last Name: " + customer + "\nOrder Code: " + orderCode
					+ "\nWash Items: " + washItems + "\nDry Cleaning: "
					+ dryItems + "\n\rSubtotal:\t$"
					+ fmt1.format(getBasePrice()) + "\nTotal:\t\t$" + fmt1
					.format(getTotalPrice()));
		} else {
			output = ("Last Name: " + customer + "\nOrder Code: " + orderCode
					+ "\nWash Items: " + washItems + "\nDry Cleaning: "
					+ dryItems + "\nSpecialty Item: " + specialtyItems
					+ "\n\rSubtotal:\t$" + fmt1.format(getBasePrice())
					+ "\nTotal:\t$" + fmt1.format(getTotalPrice()));
		}
		return output;
	}
}