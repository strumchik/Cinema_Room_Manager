package cinema;

public enum Strings {
    ENTER_ROW_NUMBER("Enter a row number:"),
    ENTER_SEAT_NUMBER_IN_ROW("Enter a seat number in that row:"),
    WRONG_INPUT("Wrong input!"),
    TICKET_PRICE("Ticket price: $%d%n"),
    ALREADY_PURCHASED("That ticket has already been purchased!"),
    CINEMA("\nCinema:"),
    ENTER_NUMBER_OF_ROWS("Enter the number of rows:"),
    ENTER_NUMBER_OF_SEATS_IN_ROW("Enter the number of seats in each row:"),
    MENU("1. Show the seats\n" +
            "2. Buy a ticket\n" +
            "3. Statistics\n" +
            "0. Exit"),
    NO_SUCH_OPTION("No such option!"),
    STATISTICS("Number of purchased tickets: %d\n" +
            "Percentage: %.2f%%\n" +
            "Current income: $%d\n" +
            "Total income: $%d")

    ;

    private final String text;

    /**
     * @param text - is text
     */
    Strings(final String text) {
        this.text = text;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return text;
    }
}
