/**
 * Created by Pantho on 2017-05-22.
 */
public class Meat {

    public static void welcome() {

//Take the input from public text fields and assign locally
            String p[] = Calc.valUL.split(",");
            float a[] = {Float.parseFloat(p[0]), Float.parseFloat(p[1])};

            String q[] = Calc.valUR.split(",");
            float b[] = {Float.parseFloat(q[0]), Float.parseFloat(q[1])};

            String r[] = Calc.valDL.split(",");
            float c[] = {Float.parseFloat(r[0]), Float.parseFloat(r[1])};

            String s[] = Calc.valDR.split(",");
            float d[] = {Float.parseFloat(s[0]), Float.parseFloat(s[1])};

//turn into payoff matrices
            float p1pay[][] = {
                    {a[0], b[0]},
                    {c[0], d[0]}};
        System.out.println("Below you have the payoffs for Player1");
            SubFunc.asFloatMatrix2(p1pay);
            float p2pay[][] = {
                    {a[1], b[1]},
                    {c[1], d[1]}};
        System.out.println("Below you have the payoffs for Player2");
            SubFunc.asFloatMatrix2(p2pay);

//Find the best
        boolean[][] p1pref = new boolean[2][2];
        boolean[][] p2pref = new boolean[2][2];
        //up better when left?
        p1pref[0][0] = SubFunc.findPref ( p1pay[0][0], p1pay[1][0]
                                        ,p1pref[0][0],p1pref[1][0])[0];
        p1pref[1][0] = SubFunc.findPref ( p1pay[0][0], p1pay[1][0]
                                        ,p1pref[0][0],p1pref[1][0])[1];
        //up better when right?
        p1pref[0][1] = SubFunc.findPref ( p1pay[0][1], p1pay[1][1]
                                        ,p1pref[0][1],p1pref[1][1])[0];
        p1pref[1][1] = SubFunc.findPref ( p1pay[0][1], p1pay[1][1]
                                        ,p1pref[0][1],p1pref[1][1])[1];
        //left better when up?
        p2pref[0][0] = SubFunc.findPref ( p2pay[0][0], p2pay[0][1]
                                        ,p2pref[0][0],p2pref[0][1])[0];
        p2pref[0][1] = SubFunc.findPref ( p2pay[0][0], p2pay[0][1]
                                        ,p2pref[0][0],p2pref[0][1])[1];
        //left better when down?
        p2pref[1][0] = SubFunc.findPref ( p2pay[1][0], p2pay[1][1]
                                        ,p2pref[1][0],p2pref[1][1])[0];
        p2pref[1][1] = SubFunc.findPref ( p2pay[1][0], p2pay[1][1]
                                        ,p2pref[1][0],p2pref[1][1])[1];
        //output commands
        System.out.println("Below you have an interim matrix showing Player1's preferred outcome locations");
        SubFunc.asBooleanMatrix2(p1pref);
        System.out.println("Below you have an interim matrix showing Player2's preferred outcome locations");
        SubFunc.asBooleanMatrix2(p2pref);

//Find the common best(s) & Count the number of pureNE
        boolean locNE[][]=new boolean[2][2];
        byte countNE=0;
        for (byte row = 0; row < locNE.length; row++) {
            for (byte col = 0; col < locNE[row].length; col++) {
                locNE[row][col] = p1pref[row][col] && p2pref[row][col];
                if (locNE[row][col] == true) {countNE++;}
            }
        }

//Nash equilibrium
        System.out.println("Below you have the matrix showing the location(s) of the Nash equilibria");
        SubFunc.asBooleanMatrix2(locNE);
        switch (countNE){
            case 0:
                System.out.println("Number of pure Nash equilibria found is: "+countNE
                +"\nAll pure and mixed Nash Equilibria are listed below (non-essentials included)");
                SubFunc.outputMix(p1pay,p2pay);
                break;
            case 1:
                System.out.println("Number of pure Nash equilibria found is: "+countNE
                        +"\nAll pure and mixed Nash equilibria are listed below (non-essentials included)");
                SubFunc.outputPure(locNE,p1pay,p2pay);
                break;
            case 2:
                System.out.println("Number of pure Nash equilibria found is: "+countNE
                        +"\nAll pure and mixed Nash equilibria are listed below (non-essentials included)");
                SubFunc.outputPure(locNE,p1pay,p2pay);
                if (SubFunc.compass(locNE)==true) {SubFunc.outputMix(p1pay,p2pay);}
                else{SubFunc.outputMixRange(locNE,countNE);}
                break;
            case 3:
                System.out.println("Number of pure Nash equilibria found is: "+countNE
                        +"\nAll pure and mixed Nash equilibria are listed below (non-essentials included)");
                SubFunc.outputPure(locNE,p1pay,p2pay);
                SubFunc.outputMixRange(locNE,countNE);
                break;
            case 4:
                System.out.println("Number of pure Nash equilibria found is: "+countNE
                        +"\nAll pure and mixed Nash equilibria are listed below (non-essentials included)");
                SubFunc.outputPure(locNE,p1pay,p2pay);
                SubFunc.outputMixRange(locNE,countNE);
                break;
            default:
                System.out.println("I don't know how you did it, but you broke the program.");
                System.out.println("Incidentally, number of pure Nash equilibria found is: "+countNE);
        }

    }

    public static void main(String[] args) {
        new Meat().welcome();
    }

}
