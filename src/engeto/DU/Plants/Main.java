package engeto.DU.Plants;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
	Plant rose = new Plant("Rose","living room", LocalDate.of(2002,11,11),LocalDate.of(2021,8,5),7);
        System.out.println(rose.getWateringInfo());

    }
}
