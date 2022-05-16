package disjointset;

public class Main {

    public static void main(String[] args) {
		DisjointSet set = new DisjointSet(5);
		set.print();
		set.union(3, 4);
		System.out.println("Result union 3 and 4 : ");

		set.print();
		set.printRank();
		set.printNumberSet();
		set.printNumberElement();

		set.union(1, 2);
		System.out.println("Result union 1 and 2 : ");
		set.print();
		set.printRank();
		set.printNumberSet();
		set.printNumberElement();

		set.union(1, 3);
		System.out.println("Result union 1 and 3 : ");
		set.print();
		set.printRank();
		set.printNumberSet();
		set.printNumberElement();

		System.out.println("Final result : ");
		set.print();
		set.printRank();
		set.printNumberSet();
		set.printNumberElement();
	}
}
