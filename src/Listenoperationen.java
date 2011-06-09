import java.util.Iterator;
import java.util.TreeSet;


public class Listenoperationen {
	private TreeSet<Einwohner> liste = new TreeSet<Einwohner>();
	
	private Einwohner ermittleObjekt(String name, String vorname) {
		for (Iterator iterator = liste.iterator(); iterator.hasNext();) {
			Einwohner einwohner = (Einwohner) iterator.next();
			if(einwohner.getVorname().equals(vorname) && einwohner.getName().equals(name)) {
				return einwohner;
			}
		}
		return null;
	}
	
	public String hinzufuegen(String anrede, String name, String vorname, String gebName, String eMail, String familienstand) {
		
		if(ermittleObjekt(name, vorname)== null) {
			Einwohner neuerEinwohner = new Einwohner(name, vorname, gebName, eMail, anrede, familienstand);
			liste.add(neuerEinwohner);
			return "Einwohner hinzugefügt";
		} else {
			return "Einwohner existiert schon";
		}

	}
	
	public boolean anzeigen(String name, String vorname) {
		if(ermittleObjekt(name, vorname)!= null) {
			Einwohner ew = ermittleObjekt(name, vorname);
			System.out.println(ew.toString());
			return true;
		} else {
			return false;
		}
	}
	
	public boolean suchen(String name, String vorname) {
		if(ermittleObjekt(name, vorname)!= null) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean loeschen(String name, String vorname) {
		if(ermittleObjekt(name, vorname)!= null) {
			Einwohner ew = ermittleObjekt(name, vorname);
			return liste.remove(ew);
		} else {
			return false;
		}
	}
	
	public void listeAusgeben() {
		for (Iterator iterator = liste.iterator(); iterator.hasNext();) {
			Einwohner einwohner = (Einwohner) iterator.next();
			System.out.println(einwohner.toString());
		}
	}
}
