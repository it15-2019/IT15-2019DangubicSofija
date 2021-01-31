package geometry;

import java.util.Arrays;
import java.util.HashMap;

public class Test {

	public static void main(String[] args) {
		
		Point p = new Point();
		p.setX(10);
		p.setY(20);
		p.setSelected(true);
		
		System.out.println("X coordinate of point p is: " + p.getX() + '\n' +
						   "Y coordinate of point p is: " + p.getY() + '\n' +
						   "Point p is selected: " + p.isSelected());
	
		double result = p.distance(40, 50);
		System.out.println("Distance between points is: " + result);
	
		Point p1 = new Point();
		p.setX(15);
		p.setY(27);
		p.setSelected(true);

		Rectangle r1 = new Rectangle();
		Line l1 = new Line();
		Circle c1 = new Circle();
		
		//1. Inicijalizovati x koordinatu tacke p
		//na vrednost y koordinate tacke p
		p.setX(p.getY());
		System.out.println("1. X of p = " + p.getX());
		
		//2. Postaviti za pocetnu tacku linije l1 tacku p, a 
		//za krajnju tacku linije l1 tacku p1
		l1.setStartPoint(p);
		l1.setEndPoint(p1);
		System.out.println("2. X of start point of line l1 = " + l1.getStartPoint().getX() + '\n' +
						   	  "Y of start point of line l1 = " + l1.getStartPoint().getY());
		
		//3. Postaviti y koordinatu krajnje tacke l1 na 23
		l1.getEndPoint().setY(23);
		System.out.println("3. Y of end point of line l1 = " + l1.getEndPoint().getY());
		
		//4. Inicijalizovati x koordinatu pocetne tacke linije l1
		//na vrednost y koordinate krajnje tacke linije l1
		l1.getStartPoint().setX(l1.getEndPoint().getY());
		System.out.println("4. X of start point of line l1 = " + l1.getStartPoint().getX());
		
		//5. Postaviti x koordinatu krajnje tacke l1 na vrednost 
		//duzine linije l1 umanjene za vrednost zbira x i y
		//koordinate pocetne tacke linije l1
		l1.getEndPoint().setX((int) (l1.length() - (l1.getStartPoint().getX() + l1.getStartPoint().getY())));
		System.out.println("5. X of end point of line l1 = " + l1.getEndPoint().getX());
		
		//6. Postaviti x koordinatu tacke gore levo pravougaonika 
		//r1 na vrednost 10 i y koordinatu na vrednost 15
		r1.setUpperLeftPoint(p);
		r1.getUpperLeftPoint().setX(10);
		r1.getUpperLeftPoint().setY(15);
		System.out.println("6. X of upper left point of rectangle r1 = " + r1.getUpperLeftPoint().getX() + '\n' +
						      "Y of upper left point of rectangle r1 = " + r1.getUpperLeftPoint().getY());
		
		//7. Postaviti centar kruga c1 na koordinate tacke 
		//gore levo od r1
		c1.setCenter(r1.getUpperLeftPoint());
		System.out.println("7. X of center of circle c1 = " + c1.getCenter().getX() + '\n' +
							  "Y of center of circle c1 = " + c1.getCenter().getY());
		
		//8. Postaviti x koordinatu centra kruga c1 na vrednost razlike
		//povrsine pravougaonika r1 i y koordinate pocetne tacke linije l1
		r1.setWidth(20);
		r1.setHeight(30);
		c1.getCenter().setX(r1.area() -  l1.getStartPoint().getY());
		System.out.println("8. X of center of circle c1 = " + c1.getCenter().getX());
	
		Point p2 = new Point(50, 100);
		Line l2 = new Line(p2, new Point(400, 500));
		Rectangle r2 = new Rectangle(p1, 50, 80);
		Circle c2 = new Circle(new Point(300, 300), 60);
		
		System.out.println(p2); //System.out.println(p2.toString());
		System.out.println(l2);
		System.out.println(r2);
		System.out.println(c2);
	
		int a = 5;
		int b = 5;
		
		System.out.println(a == b);
		
		String s1 = new String("Hello world!");
		String s2 = new String("Hello world!");
		
		System.out.println(s1 == s2); //poredjenje po referenci
		System.out.println(c1 == c2); //poredjenje po referenci
		System.out.println(s1.equals(s2)); //poredjenje po vrednosti
		
		//kod slozenih tipova poredjenje sa == je poredjenje po referenci 
		//a kod prostih je to poredjenje po vrednosti (int vs string)
		
		System.out.println(p2 instanceof Point);
		System.out.println(p2 instanceof Object);
		
		System.out.println(p2.equals(p1));
		System.out.println(p2.equals(c2));
		
		Donut d = new Donut();
		
		System.out.println(d instanceof Donut);
		System.out.println(d instanceof Circle);
		System.out.println(d instanceof SurfaceShape);
		System.out.println(d instanceof Shape);
		
		// Circle d1 = new Donut() - dinamicko povezivanje
		
		Point p4 = new Point(10, 10);
		Point p5 = new Point(5, 5);
		Point p6 = new Point(2, 2);
		Point p7 = new Point(20, 20);
		
		Point[] points = {p4, p5, p6, p7};
		
		System.out.println("Nesortiran niz tacaka:");
		for (int i = 0; i < points.length; i++) {
			System.out.println(points[i]);
		}
		
		Arrays.sort(points); //sortiranje niza
		
		System.out.println("Sortiran niz tacaka:");
		for (int i = 0; i < points.length; i++) {
			System.out.println(points[i]);
		}
		
		//HashMap
		
		HashMap<String, Shape> map = new HashMap<String, Shape>();
		map.put("point", p1);
		map.put("rectangle", r1);
		map.put("Point", p2);
		
		System.out.println("Point from map is: " + map.get("point"));
		System.out.println("Point from map is: " + map.get("Point"));
	
		Point p3 = new Point(40, 40);
		map.put("point", p3);
		
		System.out.println("Point from map is: " + map.get("point"));
		
		Circle c4 = new Circle(p6, 40);
		
		System.out.println("Circle c4 from map have radius: " + c4.getRadius());
		
		try {
			c4.setRadius(50);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Finally se uvek izvrsava");
		}
		
		System.out.println("Circle c4 from map have radius: " + c4.getRadius());
		
		
	
	
	
	}

}
