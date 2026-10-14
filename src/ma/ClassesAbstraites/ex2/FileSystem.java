package ma.ClassesAbstraites.ex2;

public class FileSystem {

	private FsItem[] items;
	private int count;

	public FileSystem() {
		this.items = new FsItem[4];
		this.count = 0;
	}

	// Ajoute un élément racine 
	
	public void addRoot(FsItem item) {
		if (count == items.length) {
			FsItem[] tmp = new FsItem[items.length * 2];
			System.arraycopy(items, 0, tmp, 0, items.length);
			items = tmp;
		}
		items[count++] = item;
	}

	// Liste l’ensemble du système
	
	public void listAll() {
		for (int i = 0; i < count; i++) {
			FsItem f = items[i];
			if (f instanceof Directory) {
				((Directory) f).list(0);
			} else {
				System.out.println(f);
			}
		}
	}

	
	// Taille totale de tous les éléments racine 
	
	public long totalSize() {
		long sum = 0;
		for (int i = 0; i < count; i++) {
			sum += items[i].getSize();
		}
		return sum;
	}

}
