/**
 * Created by Pantho on 2017-05-23.
 */
public class SubFunc {

//working with Playground, needs to be removed at a later date
    public static void pureNE(Integer[][][] arr2D2P) {
        boolean up;
        up = (arr2D2P[0][0][0]>arr2D2P[1][0][0] && arr2D2P[0][1][0]>arr2D2P[1][1][0]) ? true : false;
        System.out.print("up   " + up + "\t\t");
        boolean dn;
        dn = (arr2D2P[0][0][0]<arr2D2P[1][0][0] && arr2D2P[0][1][0]<arr2D2P[1][1][0]) ? true : false;
        System.out.println("down  " +dn);
        boolean lf;
        lf = (arr2D2P[0][0][1]>arr2D2P[0][1][1] && arr2D2P[1][0][1]>arr2D2P[1][1][1]) ? true : false;
        System.out.print("left "+ lf+"\t\t");
        boolean rt;
        rt = (arr2D2P[0][0][1]<arr2D2P[0][1][1] && arr2D2P[1][0][1]<arr2D2P[1][1][1]) ? true : false;
        System.out.println("right "+ rt);
    }

//for the purpose of interim output and checks
    public static void asIntegerMatrix3(Integer[][][] arr2D2P) {
        for (byte row = 0; row < arr2D2P.length; row++) {
            for (byte col = 0; col < arr2D2P[row].length; col++) {
                System.out.print(arr2D2P[row][col][0] + "," + arr2D2P[row][col][1] + "\t\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void asBooleanMatrix2(boolean[][] arr2D) {
        for (byte row = 0; row < arr2D.length; row++) {
            for (byte col = 0; col < arr2D[row].length; col++) {
                System.out.print(arr2D[row][col] + "\t\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void asFloatMatrix2(float[][] arr2D) {
        for (byte row = 0; row < arr2D.length; row++) {
            for (byte col = 0; col < arr2D[row].length; col++) {
                System.out.print(arr2D[row][col] + "\t\t");
            }
            System.out.println();
        }
        System.out.println();
    }

//for the main program
    public static boolean [] findPref (float o1, float o2, boolean p1, boolean p2) {
        if      ( o1==o2 ) {p1 = true;  p2=true;}
        else if ( o1> o2 ) {p1 = true;  p2=false;}
                      else {p1 = false; p2=true;}
        return new boolean[]{p1, p2};
    }

    public static void outputPure(boolean[][] best,float[][] p1,float[][] p2) {
        for (byte row = 0; row < best.length; row++) {
            for (byte col = 0; col < best[row].length; col++) {
                String s1 = (row==0) ? "(Up" : "(Down";
                String s2 = (col==0) ? "Left)\t\t\t" : "Right)\t\t\t";
                if (best[row][col] == true) {
                    System.out.print(s1+","+s2+" : ");
                    System.out.println(p1[row][col]+","+p2[row][col]);
                }
            }
        }
    }

    public static void outputMixRange(boolean[][]best,int count) {
        switch (count){
            case 4:
                System.out.println("([y; 1-y], [x; 1-x]) : where 'x'  and 'y' could be anything in between 0 and 1 \n"+
                        "Both players are indifferent to either strategy.\n" +
                        "For this game, anything is a Nash equilibrium."
                );
                break;
            default:
                if (best[0][0] && best[0][1]) {System.out.println("(Up, [x; 1-x])       : where 'x' is anything in between 0 and 1");}
                if (best[1][0] && best[1][1]) {System.out.println("(Down, [x; 1-x])     : where 'x' is anything in between 0 and 1");}
                if (best[0][0] && best[1][0]) {System.out.println("([y; 1-y], Left)     : where 'y' is anything in between 0 and 1");}
                if (best[1][0] && best[1][1]) {System.out.println("([y; 1-y], Right)    : where 'y' is anything in between 0 and 1");}
        }
    }

    public static boolean compass(boolean[][]best) {
        if      (best[0][0] || best[0][1]) {return true;}
        else if (best[1][0] || best[1][1]) {return true;}
        else if (best[0][0] || best[1][0]) {return true;}
        else if (best[1][0] || best[1][1]) {return true;}
        else                               {return false;}
    }

    public static void outputMix(float[][] p1, float[][] p2) {
        float y = ( (p1[1][1] -p1[0][1]) / (p1[0][0] -p1[0][1] -p1[1][0] +p1[1][1]) );
        float x = ( (p2[1][1] -p2[1][0]) / (p2[0][0] -p2[1][0] -p2[0][1] +p2[1][1]) );
        float z = 1;
        System.out.println("(["+ y +"; "+ (z-y) +"], ["+ x +"; "+ (z-x) +"])"
                +" : which is a Nash equilibrium in mixed strategies");
    }

}