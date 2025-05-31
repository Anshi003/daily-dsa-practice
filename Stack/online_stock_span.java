import java.util.Stack;

class StockSpanner {
    // Stack will store pairs of [price, span]
    private Stack<int[]> stack;

    /** Initializes the StockSpanner object. */
    public StockSpanner() {
        stack = new Stack<>();
    }

    /**
     * Returns the span of the stock's price for the current day.
     * Span = number of consecutive days before today (including today)
     * where stock price was less than or equal to today's price.
     *
     * @param price Today's stock price
     * @return Span of today's price
     */
    public int next(int price) {
        int span = 1;

        // Aggregate spans while the previous price is less than or equal
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }

        stack.push(new int[]{price, span});
        return span;
    }
}
