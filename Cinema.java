package cinema;

enum status {
    OFF, MENU, SELL, SHOW, STATISTIC
}

public class Cinema {

    public static void main(String[] args) {
        Room room = new Room();
        room.initiateCinema();
        while (true) {
            switch (room.currentStatus) {
                case MENU:
                    room.menu();
                    break;
                case SHOW:
                    room.showCinema();
                    break;
                case SELL:
                    room.sellTicket();
                    break;
                case STATISTIC:
                    room.showStat();
                    break;
                case OFF:
                    return;
            }
        }
    }

}