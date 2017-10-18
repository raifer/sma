
public class TestBalls {

    public static void main(String[] args) {
        Balls mesBalles = new Balls();
        System.out.println(mesBalles.toString());
        mesBalles.translate(2, 100);
        System.out.println(mesBalles.toString());
        mesBalles.reInit();
        System.out.println(mesBalles.toString());

    }

}
