package disjointset;

public class Set {
	private int parent;
	private int rank;

	public Set(int parent) {
		this.parent = parent;
		this.rank = 0;
	}

	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
}
