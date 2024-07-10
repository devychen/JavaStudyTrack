public class LexUnitDemo {
    public static void main(String[] args) {
        System.out.println("You entered the following LexUnits:");
        LexUnit test = new LexUnit();
        test.setWordForm("realize");
        test.addSynonym("recognize");
        test.addSynonym("understand");
        test.addSynonym("see");
        System.out.println(test);
        test.setWordForm("theater");
        test.addSynonym("playhouse");
        System.out.println(test);
        test.setWordForm("color");
        test.addSynonym("dye");
        test.addSynonym("pigment");
        test.addSynonym("tinge");
        test.addSynonym("tint");
        System.out.println(test);
    }
}
