package ma.ClassesAbstraites.ex2;

public abstract class FsItem {

	protected String name;

	public FsItem(String name) {

		this.name = name;
	}

	public String getName() {
		return name;
	}

	public abstract long getSize(); // retourne la taille en octets

	@Override
	public String toString() {
		return "\n" + name + "(" + getSize() + " B )";
	}

}
