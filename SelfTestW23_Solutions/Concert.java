/**
 * A class to represent a Concert ticket agent.
 * SelfTest
 * @author Marie Hinrichs
 */
public class Concert
{    
    public static final double EPSILON = 0.01;
    
    private String band;
    private int numSeats;
    private int ticketsSold;
    private double ticketPrice;
    private double totalSales;
    
    /**
     * Get the name of the band
     * @return the name of the band
     */
    public String getBand()
    {
        return band;
    }
    
    /**
     * Set the name of the band.
     * @param band the name of the band
     */
    public void setBand(String band)
    {
        this.band = band;
    }
    
    /**
     * Set the seating capacity of the arena
     * @param numSeats the number of seats in the arena
     */
    public void setNumSeats(int numSeats)
    {
        this.numSeats = numSeats;
    }
    
    /**
     * Set the price of a ticket
     * @param ticketPrice the price of a ticket
     */
    public void setTicketPrice(double ticketPrice)
    {
        this.ticketPrice = ticketPrice;
    }
    
    /**
     * Get the number of seats in the arena.
     * @return the seating capacity of the arena
     */
    public int getNumSeats()
    {
        return numSeats;
    }
    
    /**
     * Get the price of a ticket
     * @return the price of a ticket
     */
    public double getTicketPrice()
    {
        return ticketPrice;
    }
    
    /**
     * Get the number of tickets sold so far
     * @return the number of tickets sold for this concert
     */
    public int getTicketsSold()
    {
        return ticketsSold;
    }
    
    /**
     * Get the number of tickets left
     * @return the number of tickets left for this concert
     */
    public int getTicketsLeft()
    {
        return numSeats - ticketsSold;
    }
    
    /**
     * Get the total value in Euro of the tickets sold so far
     * @return the total monetary value of the tickets sold so far
     */
    public double getTotalSales()
    {
        return totalSales;
    }
    
    /**
     * Sell numTickets for this concert, if available, at the current price
     * @param numTickets the number of tickets to sell
     */
    public void sellTickets(int numTickets)
    {
        if (okToSell(numTickets))
        {
            ticketsSold += numTickets;
            totalSales += numTickets * ticketPrice;
        }
    }
    
    /**
     * Determine if there are enough seats left to sell numTickets
     * @return true if there are enough seats left to sell numTickets,
     * false otherwise
     */
    private boolean okToSell(int numTickets)
    {
        return getTicketsLeft() >= numTickets;
    }
    
    /**
     * Return a String representation of this Concert
     * @return a String representation of this Concert
     */
    public String toString()
    {
        String rval = band + " ticket price: " + ticketPrice +
            " tickets left: " + getTicketsLeft();
        return rval;
    }
    
    /**
     * Determine if this Concert is equal to otherConcert
     * @param otherConcert the Concert to compare to
     */
    public boolean equals(Concert otherConcert)
    {
        boolean rval = false;
        
        if ((otherConcert != null) &&
            band.equals(otherConcert.band) &&
            (numSeats == otherConcert.numSeats) &&
            (Math.abs(ticketPrice - otherConcert.ticketPrice) < EPSILON))
        {
            rval = true;
        }
        return rval;    
    }
}