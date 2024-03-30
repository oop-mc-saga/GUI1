package enumExample;

/**
 *
 * @author tadaki
 */
public class EnumExample {

    //Define an enumeration type        
    public static enum ColorName {
        RED, GREEN, BLUE;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ColorName colorName = ColorName.BLUE;
        String colorCode = null;
        //Switch depending on the value of colorName
        switch (colorName) {
            case RED ->
                colorCode = "#FF0000";
            case GREEN ->
                colorCode = "#00FF00";
            case BLUE ->
                colorCode = "#0000FF";
            default -> {
            }
        }
        System.out.println(colorCode);
    }

}
