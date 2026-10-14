package ma.ClassesAbstraites.ex2;

public class Directory extends FsItem {

	private FsItem[] children;
	private int count;

	public Directory(String name) {
		super(name);
		this.children = new FsItem[4];
		this.count = 0;
	}

	public void add(FsItem item) {
		if (count == children.length) {
			FsItem[] tmp = new FsItem[children.length * 2];
			System.arraycopy(children, 0, tmp, 0, children.length);
			children = tmp;
		}
		children[count++] = item;
	}

	@Override
	public long getSize() {
		long total = 0;
		for (int i = 0; i < count; i++) {
			total += children[i].getSize();
		}
		return total;
	}

	public void list(int indent) {
		System.out.println("  ".repeat(indent) + this); // affichage du dossier avec decalage d'espace
		for (int i = 0; i < count; i++) { // parcourt toud les enfants du dossier
			FsItem f = children[i];
			if (f instanceof Directory) { // test d'appartenance (si l'enfant est un sous-dossier)
				((Directory) f).list(indent + 1); // appel recurcif en augmentant l'indentation
			} else {
				System.out.println("  ".repeat(indent + 1) + f); // sinon affichage de resultat
			}
		}
	}
}
