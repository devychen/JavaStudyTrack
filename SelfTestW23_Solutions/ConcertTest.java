import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class ConcertTest extends TestCase
{    
    public static final double EPSILON = 0.01;
    
    /**
     * Test setBand and getBand methods
     */
    public void testGetSetBand()
    {
        Concert concert = new Concert();
        String actual;
        String expected = "The Beatles";
        
        // set the band name
        concert.setBand(expected);
        
        // get the band name
        actual = concert.getBand();
        
        // should be the same
        assertEquals(expected, actual);
    }
    
    /**
     * Test setNumSeats and getNumSeats methods
     */
    public void testGetSetNumSeats()
    {
        Concert concert = new Concert();
        int actual;
        int expected = 1200;
        
        // set the number of seats
        concert.setNumSeats(expected);
        
        // get the number of seats
        actual = concert.getNumSeats();
        
        // should be the same
        assertEquals(expected, actual);
    }
    
    /**
     * Test setTicketPrice and getTicketPrice methods
     */
    public void testGetSetTicketPrice()
    {
        Concert concert = new Concert();
        double actual;
        double expected = 18.50;
        
        // set the ticket price
        concert.setTicketPrice(expected);
        
        // get the ticket price
        actual = concert.getTicketPrice();
        
        // should be the same
        assertEquals(expected, actual, EPSILON);
    }
    
    /**
     * Test getTicketsSold and getTicketLeft- enough tickets left to sell
     */
    public void testGetTicketsSoldLeft1()
    {
        Concert concert = new Concert();
        double ticketPrice = 24.50;
        int capacity = 500;
        int numToSell = 4;
        int actualSold;
        int expectedSold = numToSell;
        int actualLeft;
        int expectedLeft = capacity - numToSell;
        
        // set the ticket price
        concert.setTicketPrice(ticketPrice);
        
        // set the seating capacity
        concert.setNumSeats(capacity);
        
        // sell some tickets
        concert.sellTickets(numToSell);
        
        // get the number of tickets sold
        actualSold = concert.getTicketsSold();
        
        // should sell the tickets
        assertEquals(expectedSold, actualSold);
        
        // get number of tickets left
        actualLeft = concert.getTicketsLeft();
        
        // should have numToSell less
        assertEquals(expectedLeft, actualLeft);
    }
    
    /**
     * Test getTicketsSold and getTicketsLeft- not enough tickets left to sell
     */
    public void testGetTicketsSoldLeft2()
    {
        Concert concert = new Concert();
        double ticketPrice = 24.50;
        int capacity = 300;
        int numToSell = capacity + 1;
        int actualSold;
        int expectedSold = 0;
        int actualLeft;
        int expectedLeft = capacity;
        
        // set the ticket price
        concert.setTicketPrice(ticketPrice);
        
        // set the seating capacity
        concert.setNumSeats(capacity);
        
        // sell some tickets
        concert.sellTickets(numToSell);
        
        // get the number of tickets sold
        actualSold = concert.getTicketsSold();
        
        // should sell the tickets
        assertEquals(expectedSold, actualSold);
        
        // get number of tickets left
        actualLeft = concert.getTicketsLeft();
        
        // should have numToSell less
        assertEquals(expectedLeft, actualLeft);
    }
    
    /**
     * Test getTotalSales - one sale
     */
    public void testGetTotalSales1()
    {
        Concert concert = new Concert();
        int capacity = 500;
        double ticketPrice = 24.50;
        int numToSell = 4;
        double actualSales;
        double expectedSales = numToSell * ticketPrice;
        
        // set the seating capacity
        concert.setNumSeats(capacity);
        
        // set the ticket price
        concert.setTicketPrice(ticketPrice);
        
        // sell some tickets
        concert.sellTickets(numToSell);
        
        // get the total sales
        actualSales = concert.getTotalSales();
        
        // should be the same
        assertEquals(expectedSales, actualSales, EPSILON);
    }
    
    /**
     * Test getTotalSales - multiple sales, different ticket prices
     */
    public void testGetTotalSales2()
    {
        Concert concert = new Concert();
        int capacity = 500;
        double ticketPrice1 = 32.50;
        int numToSell1 = 4;
        double ticketPrice2 = 27.00;
        int numToSell2 = 2;
        double actualSales;
        double expectedSales = (numToSell1 * ticketPrice1) +
            (numToSell2 * ticketPrice2);
        
        // set the seating capacity
        concert.setNumSeats(capacity);
        
        // set the ticket price
        concert.setTicketPrice(ticketPrice1);
        
        // sell some tickets at ticketPrice1
        concert.sellTickets(numToSell1);
        
        // reset the ticket price
        concert.setTicketPrice(ticketPrice2);
        
        // sell some tickets at ticketPrice2
        concert.sellTickets(numToSell2);
        
        // get the total sales amount
        actualSales = concert.getTotalSales();
        
        // should be the same
        assertEquals(expectedSales, actualSales, EPSILON);
    }
}
