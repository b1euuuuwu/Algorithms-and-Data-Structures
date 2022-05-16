package disjointset;

public class DisjointSet {
	private Set[] sets;
	private int size;

	public DisjointSet(int itemNum) {
		this.size = itemNum;
		this.sets = new Set[size + 1];
		for (int i = 1; i <= this.size; i++) {
			this.sets[i] = new Set(i);
		}
	}

	public int find(int item) {
		int parent = this.sets[item].getParent(); if (item == parent) {
			return item;
		}
		else {
			parent = find(parent);
			this.sets[item].setParent(parent);
			return parent;
		}
	}

	public void union(int firstItem, int secondItem) {
		int firstItemParent = find(firstItem);
		int secondItemParent = find(secondItem);

		if (firstItemParent != secondItemParent) {
			int firstRank = this.sets[firstItemParent].getRank();
			int secondRank = this.sets[secondItemParent].getRank();

			if (firstRank < secondRank) {
				this.sets[firstItemParent].setParent(secondItemParent);
			}
			else if (firstRank > secondRank) {
				this.sets[secondItemParent].setParent(firstItemParent);
			}
			else {
				this.sets[secondItemParent].setParent(firstItemParent);
				this.sets[firstItemParent].setRank(firstRank + 1);
			}
		}
	}
	public void print(){
		for (int i = 1; i <= this.size; i++) {
			System.out.println("Parent of " + i + " = " + find(i));
		}
		System.out.print("\n"); }

	public void printRank() {
		for (int i = 1; i <= this.size; i++) {
			System.out.println("Rank of " + i + " = " + this.sets[i].getRank());
		}
		System.out.print("\n");
	}

	public int printNumberSet() {
		int counter = 0;
		for (int i = 1; i <= this.size; i++) {
			if (i == find(i)) {
				counter++;
			}
		}
		System.out.println("The number of the sets : " + counter + "\n");
		return counter;
	}

	public void printNumberElement() {
		int counter = 0;
		for(int i = 1; i <= this.size; i++) {
			if (i == find(i)) {
				for (int j = 1; j <= this.size; j++) {
					if (this.sets[j].getParent() == i) { counter++;
					} }
				System.out.println("S" + i + " has " + counter + " elements." );
			}
		}
		System.out.print("\n");
	}
}
