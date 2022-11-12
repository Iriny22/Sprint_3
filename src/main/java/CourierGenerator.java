public class CourierGenerator {

    public static Courier getDefault() {
        return new Courier("irida1505","qweqwe1345","Supergirl");
    }

    public static Courier getWithPasswordOnly() {
        return new Courier(null,"pupk",null);
    }

    public static Courier getWithLoginOnly() {
        return new Courier("vasya66","","");
    }

    public static Courier getWithNameOnly() {
        return new Courier("","","Суперррмачо");
    }
}
