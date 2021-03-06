  package eg.edu.alexu.csd.datastructure.linkedList;

        import java.util.ArrayList;
        import java.util.Scanner;
        import java.awt.Point;

public class Polynomial extends SinglyLinkedList implements IPolynomialSolver {

    private static Polynomial A = new Polynomial();
    private static Polynomial A_ = new Polynomial();
    private static Polynomial B = new Polynomial();
    private static Polynomial B_ = new Polynomial();
    private static Polynomial C = new Polynomial();
    private static Polynomial C_ = new Polynomial();
    private  static Polynomial R = new Polynomial();
    private  static Polynomial R_ = new Polynomial();

    public void setPolynomial(char poly, int[][] terms) {

        switch (poly)
        {
            case 'A':
            {
                A.clearPolynomial('A');
                for(int i=0;i<terms.length;i++) {
                    if (terms[i][1] >= 0) {
                        while (A.size() <= terms[i][1]) {
                            A.add(0);
                        }
                        A.set(terms[i][1], terms[i][0]);
                    }
                    else
                    {
                        while (A_.size() <=  java.lang.Math.abs(terms[i][1])) {
                            A_.add(0);
                        }
                        A_.set( java.lang.Math.abs(terms[i][1]), terms[i][0]);
                    }
                }
            }
            break;
            case 'B': {
                A.clearPolynomial('B');
                for (int i = 0; i < terms.length; i++) {
                    if (terms[i][1] >= 0) {
                        while (B.size() <= terms[i][1]) {
                            B.add(0);
                        }
                        B.set(terms[i][1], terms[i][0]);
                    } else {
                        while (B_.size() <= java.lang.Math.abs(terms[i][1])) {
                            B_.add(0);
                        }
                        B_.set(java.lang.Math.abs(terms[i][1]), terms[i][0]);
                    }
                }
            }
            break;
            case 'C':
            {
                A.clearPolynomial('C');
                for (int i = 0; i < terms.length; i++) {
                    if (terms[i][1] >= 0) {
                        while (C.size() <= terms[i][1]) {
                            C.add(0);
                        }
                        C.set(terms[i][1], terms[i][0]);
                    } else {
                        while (C_.size() <= java.lang.Math.abs(terms[i][1])) {
                            C_.add(0);
                        }
                        C_.set(java.lang.Math.abs(terms[i][1]), terms[i][0]);
                    }
                }
            }
            break;
            case 'R':
            {
                A.clearPolynomial('R');
                for (int i = 0; i < terms.length; i++) {
                    if (terms[i][1] >= 0) {
                        while (R.size() <= terms[i][1]) {
                            R.add(0);
                        }
                        R.set(terms[i][1], terms[i][0]);
                    } else {
                        while (R_.size() <= java.lang.Math.abs(terms[i][1])) {
                            R_.add(0);
                        }
                        R_.set(java.lang.Math.abs(terms[i][1]), terms[i][0]);
                    }
                }
            }
            break;
        }
    }

    public String print(char poly) {

        Polynomial temp = new Polynomial();
        Polynomial temp_ = new Polynomial();

        switch (poly) {
            case 'A':
                temp.head = A.head;
                temp_.head = A_.head;
                break;
            case 'B':
                temp.head = B.head;
                temp_.head = B_.head;
                break;
            case 'C':
                temp.head = C.head;
                temp_.head = C_.head;
                break;
            case 'R':
                temp.head = R.head;
                temp_.head = R_.head;
                break;
        }

        String polynomial = "";

        for(int index = 0; index < temp.size(); index++) {
            if(temp.get(index) != (Object)0) {
                if (index == 0)
                    polynomial = temp.get(index) + polynomial;
                else if (index == 1) {
                    if(temp.get(index)==(Object)1)
                        polynomial = "x" + polynomial;
                    else if(temp.get(index)==(Object)(-1))
                        polynomial = "-x" + polynomial;
                    else
                        polynomial = temp.get(index) + "x" + polynomial;
                }
                else {
                    if(temp.get(index)==(Object)1)
                        polynomial = "x^" + index  + polynomial;
                    else if(temp.get(index)==(Object)(-1))
                        polynomial = "-x^" + index  + polynomial;
                    else
                        polynomial = temp.get(index) + "x^" + index  + polynomial;
                }
                polynomial = " + " + polynomial;
            }
        }
        if(polynomial.length()>0)
            polynomial = polynomial.substring(2);

        if(temp_.size()>0 && temp.size()>0) {
            polynomial += " + ";
        }

        for(int index = 0; index < temp_.size(); index++) {
            if(temp_.get(index) != (Object)0) {
                if (index == 0)
                    polynomial += temp_.get(index);
                else {
                    if(temp_.get(index)==(Object)1)
                        polynomial += "x^" + -1*index;
                    else if(temp_.get(index)==(Object)(-1))
                        polynomial += "-x^" + -1*index;
                    else
                        polynomial += temp_.get(index) + "x^" + -1*index;
                }
                polynomial += " + ";
            }
        }

        if(temp_.size()>0) {
            polynomial = polynomial.substring(0, polynomial.length()-2);
        }

        if(polynomial.length() == 0)
            polynomial += 0;

        return polynomial;
    }

    public void clearPolynomial(char poly) {
        switch (poly)
        {
            case 'A':
                A.clear();
                A_.clear();
                break;
            case 'B':
                B.clear();
                B_.clear();
                break;
            case 'C':
                C.clear();
                C_.clear();
                break;
            case 'R':
                R.clear();
                R_.clear();
                break;
        }
    }


    public float evaluatePolynomial(char poly, float value) {
        double result=0;
        switch (poly)
        {
            case 'A':
            {
                SLNode temp=A.head;
                int index=0;
                while (temp!=null)
                {
                    result=result+(int)(temp.val)* java.lang.Math.pow(value,index);
                    temp=temp.next;
                    index++;
                }
                temp=A_.head;
                index=0;
                while (temp!=null)
                {
                    result=result+(int)(temp.val)* java.lang.Math.pow(value,index*-1);
                    temp=temp.next;
                    index++;
                }
            }
            break;
            case 'B':
            {
                SLNode temp=B.head;
                int index=0;
                while (temp!=null)
                {
                    result=result+(int)(temp.val)* java.lang.Math.pow(value,index);
                    temp=temp.next;
                    index++;
                }
                temp=B_.head;
                index=0;
                while (temp!=null)
                {
                    result=result+(int)(temp.val)* java.lang.Math.pow(value,index*-1);
                    temp=temp.next;
                    index++;
                }
            }
            break;
            case 'C':
            {
                SLNode temp=C.head;
                int index=0;
                while (temp!=null)
                {
                    result=result+(int)(temp.val)* java.lang.Math.pow(value,index);
                    temp=temp.next;
                    index++;
                }
                temp=C_.head;
                index=0;
                while (temp!=null)
                {
                    result=result+(int)(temp.val)* java.lang.Math.pow(value,index*-1);
                    temp=temp.next;
                    index++;
                }
            }
            break;
            case 'R':
            {
                SLNode temp=R.head;
                int index=0;
                while (temp!=null)
                {
                    result=result+(int)(temp.val)* java.lang.Math.pow(value,index);
                    temp=temp.next;
                    index++;
                }
                temp=R_.head;
                index=0;
                while (temp!=null)
                {
                    result=result+(int)(temp.val)* java.lang.Math.pow(value,index*-1);
                    temp=temp.next;
                    index++;
                }
            }
            break;
        }
        return (float)result;
    }


    public int[][] add(char poly1, char poly2) {

        R.clear();
        R_.clear();

        Polynomial temp1 = new Polynomial();
        Polynomial temp2 = new Polynomial();

        switch (poly1) {
            case 'A':
                temp1.head = A.head;
                break;
            case 'B':
                temp1.head = B.head;
                break;
            case 'C':
                temp1.head = C.head;
                break;
        }

        switch (poly2) {
            case 'A':
                temp2.head = A.head;
                break;
            case 'B':
                temp2.head = B.head;
                break;
            case 'C':
                temp2.head = C.head;
                break;
        }

        int size = temp1.size() > temp2.size() ? temp2.size() : temp1.size();

        for(int index = 0; index < size; index++) {
            R.add((int)temp1.get(index) + (int)temp2.get(index));
        }

        if(temp1.size() > temp2.size()) {
            for(int index = size; index < temp1.size(); index++)
                R.add(temp1.get(index));
        }
        else {
            for(int index = size; index < temp2.size(); index++)
                R.add(temp2.get(index));
        }

        Polynomial temp1_ = new Polynomial();
        Polynomial temp2_ = new Polynomial();

        switch (poly1) {
            case 'A':
                temp1_.head = A_.head;
                break;
            case 'B':
                temp1_.head = B_.head;
                break;
            case 'C':
                temp1_.head = C_.head;
                break;
        }

        switch (poly2) {
            case 'A':
                temp2_.head = A_.head;
                break;
            case 'B':
                temp2_.head = B_.head;
                break;
            case 'C':
                temp2_.head = C_.head;
                break;
        }

        int size_ = temp1_.size() > temp2_.size() ? temp2_.size() : temp1_.size();

        for(int index = 0; index < size_; index++) {
            R_.add((int)temp1_.get(index) + (int)temp2_.get(index));
        }

        if(temp1_.size() > temp2_.size()) {
            for(int index = size_; index < temp1_.size(); index++)
                R_.add(temp1_.get(index));
        }
        else {
            for(int index = size_; index < temp2_.size(); index++)
                R_.add(temp2_.get(index));
        }

        size = 0;
        for(int index = 0; index < R.size(); index ++) {
            if(R.get(index) != (Object) 0)
                size++;
        }

        size_ = 0;
        for(int index = 0; index < R_.size(); index ++) {
            if(R_.get(index) != (Object) 0)
                size_++;
        }

        int [][] result = new int [size+size_][2];
        for(int index = 0, i=0; index < R.size(); index ++, i++) {
            if(R.get(index) != (Object) 0) {
                result[size-i-1][1] = index;
                result[size-i-1][0] = (int)R.get(index);
            }
            else i--;
        }
        for(int index = 0, i=size; index < R_.size(); index ++, i++) {
            if(R_.get(index) != (Object) 0) {
                result[i][1] = -1*index;
                result[i][0] = (int)R_.get(index);
            }
            else i--;
        }
        return result;
    }


    public int[][] subtract(char poly1, char poly2) {

        R.clear();
        R_.clear();

        Polynomial temp1 = new Polynomial();
        Polynomial temp2 = new Polynomial();

        switch (poly1) {
            case 'A':
                temp1.head = A.head;
                break;
            case 'B':
                temp1.head = B.head;
                break;
            case 'C':
                temp1.head = C.head;
                break;
        }

        switch (poly2) {
            case 'A':
                temp2.head = A.head;
                break;
            case 'B':
                temp2.head = B.head;
                break;
            case 'C':
                temp2.head = C.head;
                break;
        }

        int size = temp1.size() > temp2.size() ? temp2.size() : temp1.size();

        for(int index = 0; index < size; index++) {
            R.add((int)temp1.get(index) - (int)temp2.get(index));
        }

        if(temp1.size() > temp2.size()) {
            for(int index = size; index < temp1.size(); index++)
                R.add(temp1.get(index));
        }
        else {
            for(int index = size; index < temp2.size(); index++)
                R.add(temp2.get(index));
        }

        Polynomial temp1_ = new Polynomial();
        Polynomial temp2_ = new Polynomial();

        switch (poly1) {
            case 'A':
                temp1_.head = A_.head;
                break;
            case 'B':
                temp1_.head = B_.head;
                break;
            case 'C':
                temp1_.head = C_.head;
                break;
        }

        switch (poly2) {
            case 'A':
                temp2_.head = A_.head;
                break;
            case 'B':
                temp2_.head = B_.head;
                break;
            case 'C':
                temp2_.head = C_.head;
                break;
        }

        int size_ = temp1_.size() > temp2_.size() ? temp2_.size() : temp1_.size();

        for(int index = 0; index < size_; index++) {
            R_.add((int)temp1_.get(index) - (int)temp2_.get(index));
        }

        if(temp1_.size() > temp2_.size()) {
            for(int index = size_; index < temp1_.size(); index++)
                R_.add(temp1_.get(index));
        }
        else {
            for(int index = size_; index < temp2_.size(); index++)
                R_.add(-1*(int)temp2_.get(index));
        }

        size = 0;
        for(int index = 0; index < R.size(); index ++) {
            if(R.get(index) != (Object) 0)
                size++;
        }

        size_ = 0;
        for(int index = 0; index < R_.size(); index ++) {
            if(R_.get(index) != (Object) 0)
                size_++;
        }

        int [][] result = new int [size+size_][2];
        for(int index = 0, i=0; index < R.size(); index ++, i++) {
            if(R.get(index) != (Object) 0) {
                result[size-i-1][1] = index;
                result[size-i-1][0] = (int)R.get(index);
            }
            else i--;
        }
        for(int index = 0, i=size; index < R_.size(); index ++, i++) {
            if(R_.get(index) != (Object) 0) {
                result[i][1] = -1*index;
                result[i][0] = (int)R_.get(index);
            }
            else i--;
        }
        return result;
    }


    public int[][] multiply(char poly1, char poly2) {

        R.clear();
        R_.clear();

        Polynomial temp1 = new Polynomial();
        Polynomial temp2 = new Polynomial();

        switch (poly1) {
            case 'A':
                temp1.head = A.head;
                break;
            case 'B':
                temp1.head = B.head;
                break;
            case 'C':
                temp1.head = C.head;
                break;
        }

        switch (poly2) {
            case 'A':
                temp2.head = A.head;
                break;
            case 'B':
                temp2.head = B.head;
                break;
            case 'C':
                temp2.head = C.head;
                break;
        }

        Polynomial temp1_ = new Polynomial();
        Polynomial temp2_ = new Polynomial();

        switch (poly1) {
            case 'A':
                temp1_.head = A_.head;
                break;
            case 'B':
                temp1_.head = B_.head;
                break;
            case 'C':
                temp1_.head = C_.head;
                break;
        }

        switch (poly2) {
            case 'A':
                temp2_.head = A_.head;
                break;
            case 'B':
                temp2_.head = B_.head;
                break;
            case 'C':
                temp2_.head = C_.head;
                break;
        }

        ArrayList <Point> productsDynamic = new ArrayList <Point>();
        Point tempPoint = new Point();

        for(int index1 = 0; index1 < temp1.size(); index1++) {
            for(int index2 = 0; index2 < temp2.size(); index2++) {
                tempPoint.x = (int)temp1.get(index1) * (int)temp2.get(index2);
                tempPoint.y = index1 + index2;
                boolean fnd = false;
                for(int i=0; i<productsDynamic.size(); i++) {
                    if(productsDynamic.get(i).y == tempPoint.y) {
                        productsDynamic.get(i).x += tempPoint.x;
                        fnd = true;
                        break;
                    }
                }
                if(!fnd && tempPoint.x != 0)
                    productsDynamic.add(new Point(tempPoint));
            }
        }
        for(int index1 = 0; index1 < temp1.size(); index1++) {
            for(int index2 = 0; index2 < temp2_.size(); index2++) {
                tempPoint.x = (int)temp1.get(index1) * (int)temp2_.get(index2);
                tempPoint.y = index1 - index2;
                boolean fnd = false;
                for(int i=0; i<productsDynamic.size(); i++) {
                    if(productsDynamic.get(i).y == tempPoint.y) {
                        productsDynamic.get(i).x += tempPoint.x;
                        fnd = true;
                        break;
                    }
                }
                if(!fnd && tempPoint.x != 0)
                    productsDynamic.add(new Point(tempPoint));
            }
        }
        for(int index1 = 0; index1 < temp1_.size(); index1++) {
            for(int index2 = 0; index2 < temp2.size(); index2++) {
                tempPoint.x = (int)temp1_.get(index1) * (int)temp2.get(index2);
                tempPoint.y = -1*index1 + index2;
                boolean fnd = false;
                for(int i=0; i<productsDynamic.size(); i++) {
                    if(productsDynamic.get(i).y == tempPoint.y) {
                        productsDynamic.get(i).x += tempPoint.x;
                        fnd = true;
                        break;
                    }
                }
                if(!fnd && tempPoint.x != 0)
                    productsDynamic.add(new Point(tempPoint));
            }
        }
        for(int index1 = 0; index1 < temp1_.size(); index1++) {
            for(int index2 = 0; index2 < temp2_.size(); index2++) {
                tempPoint.x = (int)temp1_.get(index1) * (int)temp2_.get(index2);
                tempPoint.y = -1*index1 - index2;
                boolean fnd = false;
                for(int i=0; i<productsDynamic.size(); i++) {
                    if(productsDynamic.get(i).y == tempPoint.y) {
                        productsDynamic.get(i).x += tempPoint.x;
                        fnd = true;
                        break;
                    }
                }
                if(!fnd && tempPoint.x != 0)
                    productsDynamic.add(new Point(tempPoint));
            }
        }

        int [][] products = new int[productsDynamic.size()][2];
        for(int i=0; i<productsDynamic.size(); i++) {
            products[i][0] = productsDynamic.get(i).x;
            products[i][1] = productsDynamic.get(i).y;
        }

        R.setPolynomial('R', products);

        return products;
    }

    private static boolean checkValidation(String x)
    {
        if(x.charAt(0)!='(')return false;
        if(x.length()<5)return false;
        int i=0;
        while (i<x.length()) {
            if(x.charAt(i)!=' '){
                int counterComma = 0;
                for (; i < x.length(); i++) {
                    if (x.charAt(i) != ' ') {
                        if (x.charAt(i) == ',' && counterComma == 1)
                            break;
                        if (x.charAt(i) == ',' && counterComma == 0) counterComma++;
                    }
                }
                if (i != x.length()) {
                    int index = i - 1, commas = 0;
                    if (x.charAt(index) == ')') index--;
                    while (x.charAt(index) != '(') {
                        if (x.charAt(index) != ' ') {
                            if ((x.charAt(index) < '0' || x.charAt(index) > '9') && x.charAt(index) != ',' && !(x.charAt(index) == '-' && (x.charAt(index + 1) >= '0' && x.charAt(index + 1) <= '9')))
                                return false;
                            if (x.charAt(index) == ',') commas++;
                            if (commas > 1) return false;
                            index--;
                        }
                        else index--;
                    }
                } else {
                    i--;
                    int index = i, commas = 0;
                    if (x.charAt(index) == ')') index--;
                    if (x.charAt(i) != ')') return false;
                    while (x.charAt(index) != '(') {
                        if (x.charAt(index) != ' ') {
                            if ((x.charAt(index) < '0' || x.charAt(index) > '9') && x.charAt(index) != ',' && !(x.charAt(index) == '-' && (x.charAt(index + 1) >= '0' && x.charAt(index + 1) <= '9')))
                                return false;
                            if (x.charAt(index) == ',') commas++;
                            if (commas > 1) return false;
                            index--;
                            i++;
                        }
                        else index--;
                    }
                }
            }
            i++;
        }
        return true;
    }


    public static void main(String[] args) {
        while ( true ) {
            Scanner scan = new Scanner(System.in);
            int s = 0;
            do {
                try {
                    System.out.println("Please choose an action");
                    System.out.println("----------------------");
                    System.out.println("1- Set a polynomial variable ");
                    System.out.println("2- Print the value of a polynomial variable");
                    System.out.println("3- Add two polynomials ");
                    System.out.println("4- Subtract two polynomials");
                    System.out.println("5- Multiply two polynomials");
                    System.out.println("6- Evaluate a polynomial at some point ");
                    System.out.println("7- Clear a polynomial variable");
                    System.out.println("8- Exit");
                    System.out.println("====================================================================");
                    String tempooo=scan.nextLine();
                    if (!(tempooo.equals("1")||tempooo.equals("2")||tempooo.equals("3")||tempooo.equals("4")||tempooo.equals("5")||tempooo.equals("6")||tempooo.equals("7")||tempooo.equals("8")))
                        throw new RuntimeException("Invalid input");
                    else s=Integer.parseInt(tempooo);
                } catch (RuntimeException ex) {
                    System.out.println(ex.getMessage());
                }
            } while (s < 1 || s > 8);
            String p = "";
            switch (s) {
                case 1: {
                    do {
                        try {
                            System.out.println("Insert the variable name: A, B or C");
                            p = scan.next().toUpperCase();
                            String tempooooo=scan.nextLine();
                            if (!p.equals("A") && !p.equals("B") && !p.equals("C") && p.length() != 1)
                                throw new RuntimeException("invalid variable");
                        } catch (RuntimeException ex) {
                            System.out.println(ex.getMessage());
                        }
                    } while (!p.equals("A") && !p.equals("B") && !p.equals("C"));
                    String x = "";
                    int temp_index=0;
                    boolean checker=false;
                    ArrayList<String>y=new ArrayList<>();
                    do {
                        try {
                            System.out.println("Insert the polynomial terms in the form: ");
                            System.out.println("(coeff1, exponent1), (coeff2, exponent2), .. ");
                            y.add(temp_index,scan.nextLine());
                            String temp=y.get(temp_index);
                            temp=temp.replaceAll("\\s","");
                            checker=checkValidation(temp);
                            if (!checker)
                                throw new RuntimeException("Invalid Input");
                        } catch (RuntimeException ex) {
                            System.out.println(ex.getMessage());
                        }
                        temp_index++;

                    } while (!checker);
                    temp_index--;
                    x=y.get(temp_index).replaceAll("\\s","");
                    int openCounter=0;
                    for(int i=0;i<x.length();i++)
                        if(x.charAt(i)=='(')openCounter++;
                    int[][] terms = new int[openCounter][2];
                    int index=0;
                    String temp = "";
                    for(int i=0;i<x.length();i++)
                    {
                        if(x.charAt(i)!='('&&x.charAt(i)!=')'&&x.charAt(i)!=',')
                        {
                            temp=temp+x.charAt(i);
                        }
                        if(x.charAt(i)==','&&x.charAt(i+1)!=')'&&x.charAt(i+1)!='(')
                        {
                            terms[index][0]=Integer.parseInt(temp);
                            temp="";
                        }
                        else if(x.charAt(i)==')') {
                            terms[index][1] = Integer.parseInt(temp);
                            index++;
                            temp="";
                        }
                    }
                    A.setPolynomial(p.charAt(0),terms);
                    System.out.println("Polynomial " + p.charAt(0) + " is set");
                }
                break;
                case 2: {
                    Polynomial temp = new Polynomial();
                    Polynomial temp_ = new Polynomial();
                    do{
                        try {
                            do {
                                try {
                                    System.out.println("Insert the variable name: A, B, C or R");
                                    p = scan.next().toUpperCase();
                                    if (!p.equals("A") && !p.equals("B") && !p.equals("C") && !p.equals("R") || p.length() != 1)
                                        throw new RuntimeException("Invalid Variable");
                                } catch (RuntimeException ex) {
                                    System.out.println(ex.getMessage());
                                }
                            } while (!p.equals("A") && !p.equals("B") && !p.equals("C") && !p.equals("R") || p.length() != 1);
                            switch (p.charAt(0)) {
                                case 'A':
                                    temp.head=A.head;
                                    temp_.head=A_.head;
                                    break;
                                case 'B':
                                    temp.head=B.head;
                                    temp_.head=B_.head;
                                    break;
                                case 'C':
                                    temp.head=C.head;
                                    temp_.head=C_.head;
                                    break;
                                case 'R':
                                    temp.head=R.head;
                                    temp_.head=R_.head;
                                    break;
                            }
                            if(temp.isEmpty()&&temp_.isEmpty())
                                throw new RuntimeException("Variable not set");
                        }
                        catch (RuntimeException ex)
                        {
                            System.out.println(ex.getMessage());
                        }
                    } while (temp.isEmpty()&&temp_.isEmpty());
                    System.out.println("Value in "+ p.charAt(0) + ": " + A.print(p.charAt(0)));
                }
                break;
                case 3: {
                    Polynomial temp = new Polynomial();
                    Polynomial temp_ = new Polynomial();
                    do {
                        try {
                            do {
                                try {
                                    System.out.println("Insert first operand variable name: A, B or C");
                                    p = scan.next().toUpperCase();
                                    if (!p.equals("A") && !p.equals("B") && !p.equals("C") || p.length() != 1)
                                        throw new RuntimeException("Invalid Variable");
                                } catch (RuntimeException ex) {
                                    System.out.println(ex.getMessage());
                                }
                            } while (!p.equals("A") && !p.equals("B") && !p.equals("C") || p.length() != 1);
                            switch (p.charAt(0)) {
                                case 'A':
                                    temp.head=A.head;
                                    temp_.head=A_.head;
                                    break;
                                case 'B':
                                    temp.head=B.head;
                                    temp_.head=B_.head;
                                    break;
                                case 'C':
                                    temp.head=C.head;
                                    temp_.head=C_.head;
                                    break;
                            }
                            if(temp.isEmpty()&&temp_.isEmpty())
                                throw new RuntimeException("Variable not set");
                        }
                        catch (RuntimeException ex)
                        {
                            System.out.println(ex.getMessage());
                        }
                    } while (temp.isEmpty()&&temp_.isEmpty());
                    String p_ = "";
                    do {
                        try {
                            do {
                                try {
                                    System.out.println("Insert second operand variable name: A, B or C");
                                    p_ = scan.next().toUpperCase();
                                    if (!p_.equals("A") && !p_.equals("B") && !p_.equals("C") || p_.length() != 1)
                                        throw new RuntimeException("Invalid Variable");
                                } catch (RuntimeException ex) {
                                    System.out.println(ex.getMessage());
                                }
                            } while (!p_.equals("A") && !p_.equals("B") && !p_.equals("C") || p_.length() != 1);
                            switch (p_.charAt(0)) {
                                case 'A':
                                    temp.head=A.head;
                                    temp_.head=A_.head;
                                    break;
                                case 'B':
                                    temp.head=B.head;
                                    temp_.head=B_.head;
                                    break;
                                case 'C':
                                    temp.head=C.head;
                                    temp_.head=C_.head;
                                    break;
                            }
                            if(temp.isEmpty()&&temp_.isEmpty())
                                throw new RuntimeException("Variable not set");
                        }
                        catch (RuntimeException ex)
                        {
                            System.out.println(ex.getMessage());
                        }
                    } while (temp.isEmpty()&&temp_.isEmpty());
                    int [][] result = A.add(p.charAt(0), p_.charAt(0));
                    System.out.print("Result set in R: ("+result[0][0]+","+result[0][1] +")");
                    for(int i=1; i<result.length; i++) {
                        System.out.print(", ("+result[i][0]+","+result[i][1]+")");
                    }
                    System.out.println();
                }
                break;
                case 4: {
                    Polynomial temp = new Polynomial();
                    Polynomial temp_ = new Polynomial();
                    do {
                        try {
                            do {
                                try {
                                    System.out.println("Insert first operand variable name: A, B or C");
                                    p = scan.next().toUpperCase();
                                    if (!p.equals("A") && !p.equals("B") && !p.equals("C") || p.length() != 1)
                                        throw new RuntimeException("Invalid Variable");
                                } catch (RuntimeException ex) {
                                    System.out.println(ex.getMessage());
                                }
                            } while (!p.equals("A") && !p.equals("B") && !p.equals("C") || p.length() != 1);
                            switch (p.charAt(0)) {
                                case 'A':
                                    temp.head=A.head;
                                    temp_.head=A_.head;
                                    break;
                                case 'B':
                                    temp.head=B.head;
                                    temp_.head=B_.head;
                                    break;
                                case 'C':
                                    temp.head=C.head;
                                    temp_.head=C_.head;
                                    break;
                            }
                            if(temp.isEmpty()&&temp_.isEmpty())
                                throw new RuntimeException("Variable not set");
                        }
                        catch (RuntimeException ex)
                        {
                            System.out.println(ex.getMessage());
                        }
                    } while (temp.isEmpty()&&temp_.isEmpty());
                    String p_ = "";
                    do {
                        try {
                            do {
                                try {
                                    System.out.println("Insert second operand variable name: A, B or C");
                                    p_ = scan.next().toUpperCase();
                                    if (!p_.equals("A") && !p_.equals("B") && !p_.equals("C") || p_.length() != 1)
                                        throw new RuntimeException("Invalid Variable");
                                } catch (RuntimeException ex) {
                                    System.out.println(ex.getMessage());
                                }
                            } while (!p_.equals("A") && !p_.equals("B") && !p_.equals("C") || p_.length() != 1);
                            switch (p_.charAt(0)) {
                                case 'A':
                                    temp.head=A.head;
                                    temp_.head=A_.head;
                                    break;
                                case 'B':
                                    temp.head=B.head;
                                    temp_.head=B_.head;
                                    break;
                                case 'C':
                                    temp.head=C.head;
                                    temp_.head=C_.head;
                                    break;
                            }
                            if(temp.isEmpty()&&temp_.isEmpty())
                                throw new RuntimeException("Variable not set");
                        }
                        catch (RuntimeException ex)
                        {
                            System.out.println(ex.getMessage());
                        }
                    } while (temp.isEmpty()&&temp_.isEmpty());
                    int [][] result = A.subtract(p.charAt(0), p_.charAt(0));
                    if(result.length>0) {
                        System.out.print("Result set in R: ("+result[0][0]+","+result[0][1] +")");
                        for(int i=1; i<result.length; i++) {
                            System.out.print(", ("+result[i][0]+","+result[i][1]+")");
                        }
                        System.out.println();
                    }
                    else
                        System.out.println("Result set in R: (0,0)");
                }
                break;
                case 5:{
                    Polynomial temp = new Polynomial();
                    Polynomial temp_ = new Polynomial();
                    do {
                        try {
                            do {
                                try {
                                    System.out.println("Insert first operand variable name: A, B or C");
                                    p = scan.next().toUpperCase();
                                    if (!p.equals("A") && !p.equals("B") && !p.equals("C") || p.length() != 1)
                                        throw new RuntimeException("Invalid Variable");
                                } catch (RuntimeException ex) {
                                    System.out.println(ex.getMessage());
                                }
                            } while (!p.equals("A") && !p.equals("B") && !p.equals("C") || p.length() != 1);
                            switch (p.charAt(0)) {
                                case 'A':
                                    temp.head=A.head;
                                    temp_.head=A_.head;
                                    break;
                                case 'B':
                                    temp.head=B.head;
                                    temp_.head=B_.head;
                                    break;
                                case 'C':
                                    temp.head=C.head;
                                    temp_.head=C_.head;
                                    break;
                            }
                            if(temp.isEmpty()&&temp_.isEmpty())
                                throw new RuntimeException("Variable not set");
                        }
                        catch (RuntimeException ex)
                        {
                            System.out.println(ex.getMessage());
                        }
                    } while (temp.isEmpty()&&temp_.isEmpty());
                    String p_ = "";
                    do {
                        try {
                            do {
                                try {
                                    System.out.println("Insert second operand variable name: A, B or C");
                                    p_ = scan.next().toUpperCase();
                                    if (!p_.equals("A") && !p_.equals("B") && !p_.equals("C") || p_.length() != 1)
                                        throw new RuntimeException("Invalid Variable");
                                } catch (RuntimeException ex) {
                                    System.out.println(ex.getMessage());
                                }
                            } while (!p_.equals("A") && !p_.equals("B") && !p_.equals("C") || p_.length() != 1);
                            switch (p_.charAt(0)) {
                                case 'A':
                                    temp.head=A.head;
                                    temp_.head=A_.head;
                                    break;
                                case 'B':
                                    temp.head=B.head;
                                    temp_.head=B_.head;
                                    break;
                                case 'C':
                                    temp.head=C.head;
                                    temp_.head=C_.head;
                                    break;
                            }
                            if(temp.isEmpty()&&temp_.isEmpty())
                                throw new RuntimeException("Variable not set");
                        }
                        catch (RuntimeException ex)
                        {
                            System.out.println(ex.getMessage());
                        }
                    } while (temp.isEmpty()&&temp_.isEmpty());
                    int [][] result = A.multiply(p.charAt(0), p_.charAt(0));
                    System.out.print("Result set in R: ("+result[0][0]+","+result[0][1] +")");
                    for(int i=1; i<result.length; i++) {
                        System.out.print(", ("+result[i][0]+","+result[i][1]+")");
                    }
                    System.out.println();
                }
                break;
                case 6:
                {
                    Polynomial temp = new Polynomial();
                    String p_ = "";
                    do {
                        try {
                            do {
                                try {
                                    System.out.println("Insert variable name: A, B or C");
                                    p_ = scan.next().toUpperCase();
                                    if (!p_.equals("A") && !p_.equals("B") && !p_.equals("C") || p_.length() != 1)
                                        throw new RuntimeException("Invalid Variable");
                                } catch (RuntimeException ex) {
                                    System.out.println(ex.getMessage());
                                }
                            } while (!p_.equals("A") && !p_.equals("B") && !p_.equals("C") || p_.length() != 1);
                            switch (p_.charAt(0)) {
                                case 'A':
                                    temp.head=A.head;
                                    break;
                                case 'B':
                                    temp.head=B.head;
                                    break;
                                case 'C':
                                    temp.head=C.head;
                                    break;
                            }
                            if(temp.isEmpty())
                                throw new RuntimeException("Variable not set");
                        }
                        catch (RuntimeException ex)
                        {
                            System.out.println(ex.getMessage());
                        }
                    } while (temp.isEmpty());

                    System.out.println("Enter the value:");
                    float value=0;
                    boolean check=true;
                    do {
                        try {
                            check=true;
                            if(!scan.hasNextFloat())
                            {
                                check=false;
                                throw new RuntimeException("invalid input");
                            }
                            else{
                                value = scan.nextFloat();
                            }
                        } catch (RuntimeException ex) {
                            System.out.println(ex.getMessage());
                        }
                    }while (!check);
                    System.out.println(A.evaluatePolynomial(p_.charAt(0),value));
                }
                break;
                case 7:
                {
                    Polynomial temp = new Polynomial();
                    String p_ = "";
                    do {
                        try {
                            do {
                                try {
                                    System.out.println("Insert variable name: A, B or C");
                                    p_ = scan.next().toUpperCase();
                                    if (!p_.equals("A") && !p_.equals("B") && !p_.equals("C") || p_.length() != 1)
                                        throw new RuntimeException("Invalid Variable");
                                } catch (RuntimeException ex) {
                                    System.out.println(ex.getMessage());
                                }
                            } while (!p_.equals("A") && !p_.equals("B") && !p_.equals("C") || p_.length() != 1);
                            switch (p_.charAt(0)) {
                                case 'A':
                                    temp.head=A.head;
                                    break;
                                case 'B':
                                    temp.head=B.head;
                                    break;
                                case 'C':
                                    temp.head=C.head;
                                    break;
                            }
                            if(temp.isEmpty())
                                throw new RuntimeException("Variable not set");
                        }
                        catch (RuntimeException ex)
                        {
                            System.out.println(ex.getMessage());
                        }
                    } while (temp.isEmpty());
                    A.clearPolynomial(p_.charAt(0));
                    System.out.println(p_.charAt(0)+" is Cleared");
                }
                break;
                case 8:System.exit(0);
            }
        }
    }
}
