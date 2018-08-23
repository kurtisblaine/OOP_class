package ch.makery.coffee;

import java.util.ArrayList;
import java.util.Arrays;

public class Orders
{

	private ArrayList<Integer> m_currentOrder;
	private ArrayList<Integer> m_currentItems;
	private int m_orderNum;
	private boolean m_orderMade;

	// name of ingredients
	public static final Integer EMPTY_CUPS = 1;
	public static final Integer COFFEE = 2;
	public static final Integer ICE = 3;
	public static final Integer MILK = 4;
	public static final Integer ESPRESSO = 5;
	public static final Integer HAZELNUT = 6;
	public static final Integer CARAMEL = 7;
	public static double m_score = 0.0;	
	public static double m_high_score;
	
	// menus
	public static final Integer[] COFFEE_WITH_CREAM = { EMPTY_CUPS , COFFEE, MILK };
	public static final Integer[] CARAMEL_AMERICANO = { EMPTY_CUPS , ESPRESSO, CARAMEL };
	public static final Integer[] ICED_CARAMEL_AMERICANO = { EMPTY_CUPS , ESPRESSO, CARAMEL, ICE };
	public static final Integer[] HAZELNUT_AMERICANO = { EMPTY_CUPS , ESPRESSO, HAZELNUT };
	public static final Integer[] ICED_HAZELNUT_AMERICANO = { EMPTY_CUPS , ESPRESSO, HAZELNUT, ICE };
	public static final Integer[] HAZELNUT_LATTE = { EMPTY_CUPS , ESPRESSO, MILK, HAZELNUT };
	public static final Integer[] ICED_HAZELNUT_LATTE = { EMPTY_CUPS , ESPRESSO, MILK, HAZELNUT , ICE};
	public static final Integer[] CARAMEL_LATTE = { EMPTY_CUPS , ESPRESSO, MILK, CARAMEL };
	public static final Integer[] ICED_CARAMEL_LATTE = { EMPTY_CUPS , ESPRESSO, MILK, CARAMEL, ICE };
	public static final Integer[] CARAMEL_MACCHIATO = { EMPTY_CUPS , ESPRESSO, CARAMEL, COFFEE, MILK };
	public static final Integer[] ICED_CARAMEL_MACCHIATO = { EMPTY_CUPS , ESPRESSO, CARAMEL, ICE, COFFEE, MILK };
	public static final Integer[] BLACK_COFFEE = {EMPTY_CUPS, COFFEE};
	public static final Integer[] LACTOSE_FREE_CARAMEL_MACCHIATO = { EMPTY_CUPS , ESPRESSO, CARAMEL, COFFEE };
	public static final Integer[] ESPROSELF_SPECIAL = {EMPTY_CUPS , ESPRESSO, CARAMEL, ICE, COFFEE, MILK, HAZELNUT };
	

	// point total per menu
	public static final double easy =  1.75;
	public static final double medium = 2.75;
	public static final double hard = 3.75;
	public static final double impossible = 10.00;
	
	public Orders()
	{
		// first order is coffee with cream
		m_orderNum = 8;
		setM_orderMade(false);
		m_currentOrder = new ArrayList<Integer>( Arrays.asList(BLACK_COFFEE) );
		m_currentItems = new ArrayList<Integer>();
	}

	public String newOrder()
	{
		// return a random number between 1 and 7
		m_orderNum = (int)(Math.random() * 14) + 1;
		if( m_orderNum == 1 )
		{
			m_currentOrder = new ArrayList<Integer>( Arrays.asList( COFFEE_WITH_CREAM ) );
			return "New order! Coffee with cream.";
		}
		else if ( m_orderNum == 2 )
		{
			m_currentOrder = new ArrayList<Integer>( Arrays.asList( CARAMEL_AMERICANO ) );
			return "New order! Carmel americano.";
		}
		else if ( m_orderNum == 3 )
		{
			m_currentOrder = new ArrayList<Integer>( Arrays.asList( ICED_CARAMEL_AMERICANO ) );
			return "New order! Iced carmel americano.";
		}
		else if ( m_orderNum == 4 )
		{
			m_currentOrder = new ArrayList<Integer>( Arrays.asList( HAZELNUT_LATTE ) );
			return "New order! Hazelnut latte.";
		}
		else if ( m_orderNum == 5 )
		{
			m_currentOrder = new ArrayList<Integer>( Arrays.asList( ICED_HAZELNUT_LATTE ) );
			return "New order! Iced Hazelnut Latte.";
		}
		else if ( m_orderNum == 6 )
		{
			m_currentOrder = new ArrayList<Integer>( Arrays.asList( CARAMEL_MACCHIATO ) );
			return "New order! Caramel Macchiato";
		}
		else if ( m_orderNum == 7 )
		{
			m_currentOrder = new ArrayList<Integer>( Arrays.asList( ICED_CARAMEL_MACCHIATO ) );
			return "New order! Iced Caramel Macchiato";
		}
		else if ( m_orderNum == 8){
			m_currentOrder = new ArrayList<Integer>( Arrays.asList( BLACK_COFFEE ) );
			return "New order! Black Coffee";
		}
		else if ( m_orderNum == 9){
			m_currentOrder = new ArrayList<Integer>( Arrays.asList( ICED_CARAMEL_LATTE) );
			return "New order! Iced Caramel Latte";
		}
		else if ( m_orderNum == 10){
			m_currentOrder = new ArrayList<Integer>( Arrays.asList( CARAMEL_LATTE ) );
			return "New order! Caramel Latte";
		}
		else if ( m_orderNum == 11){
			m_currentOrder = new ArrayList<Integer>( Arrays.asList( ICED_HAZELNUT_AMERICANO) );
			return "New order! Iced Hazelnut Americano";
		}
		else if ( m_orderNum == 12){
			m_currentOrder = new ArrayList<Integer>( Arrays.asList( HAZELNUT_AMERICANO ) );
			return "New order! Hazelnut Americano";
		}
		else if ( m_orderNum == 13){
			m_currentOrder = new ArrayList<Integer>( Arrays.asList( LACTOSE_FREE_CARAMEL_MACCHIATO ) );
			return "New order! Lactose-free caramel macchiato";
		}
		else if ( m_orderNum == 14){
			m_currentOrder = new ArrayList<Integer>( Arrays.asList( ESPROSELF_SPECIAL ) );
			return "New order! The EspressoSelf Special!";
		}
		return "ERROR";
	}

	public String submit()
	{	
			if( !m_currentItems.containsAll(m_currentOrder ) 
				|| m_currentItems.size() != m_currentOrder.size() )
		{
			clearCurrentItemsItems();
			m_high_score = m_score;
			m_score = 0.00;
			return "Order does not match! The customer was angry and the boss stole your money! ";
		}
		m_currentItems.clear();
		setM_orderMade(true);
		double score = getOrderScore();
		return "Great Job!" + "\n" + "The customer tipped you $" + score + "\n" + "Total Tips: $ " + (m_score += score) ;
	}

	public String addItem( Integer ingredient )
	{
		if( m_currentItems.isEmpty() == true && ingredient != EMPTY_CUPS )
		{
			return "Please grab a cup first";
		}
		else if( m_currentItems.contains(ingredient) == true )
		{
			// second time click the same item will remove it.
			m_currentItems.remove(ingredient);
			return "You removed" + getIngredientName( ingredient) ;
		}

		m_currentItems.add( ingredient );
		return "You added " + getIngredientName( ingredient);
	}

	private String getIngredientName( Integer ingredient )
	{
		if( ingredient == EMPTY_CUPS )
		{
			return "Cup";
		}
		else if( ingredient == COFFEE )
		{
			return "Coffee";
		}
		else if( ingredient == ICE )
		{
			return "Ice";
		}
		else if( ingredient == MILK )
		{
			return "Milk";
		}
		else if( ingredient == ESPRESSO )
		{
			return "Espresso";
		}
		else if( ingredient == HAZELNUT )
		{
			return "Hazelnut";
		}
		else if( ingredient == CARAMEL )
		{
			return "Caramel";
		}
		return "UNKNOWN INGRIDIENT!!!!!!!!!";
	}
	
	private double getOrderScore(){
		if(m_orderNum == 1 || m_orderNum == 8){
			return easy;
		}
		else if(m_orderNum == 2 || m_orderNum == 4 || m_orderNum == 6 || m_orderNum == 8 ||m_orderNum == 10 || m_orderNum == 12){
			return medium;
		}
		else if(m_orderNum == 3 || m_orderNum == 5 || m_orderNum == 7 || m_orderNum == 9 || m_orderNum == 11 || m_orderNum == 13){
			return hard;
		}
		else if(m_orderNum == 14){
			return impossible;
		}
		return 0;
	}

	private String getOrderName()
	{
		if( m_orderNum == 1 )
		{
			return "Coffee with cream";
		}
		else if( m_orderNum == 2 )
		{
			return "Caramel Americano";
		}
		else if( m_orderNum == 3 )
		{
			return "Iced Caramel Americano";
		}
		else if( m_orderNum == 4 )
		{
			return "Hazelnut Latte";
		}
		else if( m_orderNum == 5 )
		{
			return "Iced Hazelnut Latte";
		}
		else if( m_orderNum == 6 )
		{
			return "Caramel Macchiato";
		}
		else if( m_orderNum == 7 )
		{
			return "Iced Caramel Macchiato";
		}
		else if( m_orderNum == 8 ){
			return "Black Coffee";
		}
		else if( m_orderNum == 9 ){
			return "Iced Caramel Latte";
		}
		else if( m_orderNum == 10 ){
			return "Caramel Latte";
		}
		else if( m_orderNum == 11 ){
			return "Iced Hazelnut Americano";
		}
		else if( m_orderNum == 12 ){
			return "Hazelnut Americano";
		}
		else if( m_orderNum == 13){
			return "Lactose-free Caramel Macchiato";
		}
		else if( m_orderNum == 14){
			return "The EspressoSelf Special";
		}
		return "Unknown Order";
	}

	public String printCurrentOrder()
	{
		return getOrderName();
	}

	public String printCurrentItems()
	{
		String ret = "Current ingredients: ";
		ret = "\n";
		for ( Integer item: m_currentItems ) {
			ret += "\t";
			ret += getIngredientName( item );
			ret += "\n";
		}
		return ret;
	}

	public void clearCurrentItemsItems()
	{
		m_currentItems.clear();
	}

	public boolean isM_orderMade() {
		return m_orderMade;
	}

	public void setM_orderMade(boolean m_orderMade) {
		this.m_orderMade = m_orderMade;
	}


}
