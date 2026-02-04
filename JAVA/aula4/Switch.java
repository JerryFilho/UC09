package aula4;

public class Switch {
    public static void main(String[] args) {
        int num;
        num = 1;

        switch (num) {
            case 1:
                System.out.println("UM");
                break;
            case 2:
                System.out.println("DOIS");
                break;
            case 3:
                System.out.println("TRÊS");    
                break;
            default:
                System.out.println("num não listado");
                break;
        }
    }
}
