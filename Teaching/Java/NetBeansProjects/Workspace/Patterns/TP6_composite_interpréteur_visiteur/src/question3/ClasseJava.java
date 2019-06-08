package question3;

import java.util.Iterator;
import question1.Contexte;

import java.io.*;

/**
 * Utilitaire de generation de classe Java a parir de votre Visiteur
 * VisiteurInstToJava
 */
public class ClasseJava {
	private static final String lineSeparator = System.getProperties().getProperty("line.separator");

	private String nomDeLaClasse;
	private String nomDuPaquetage;
	private VisiteurInstruction<String> vi;
	private Instruction inst;

	public ClasseJava(String nomDeLaClasse, Instruction inst, VisiteurInstruction<String> vi) {
		this(nomDeLaClasse, null, inst, vi);
	}

	public ClasseJava(String nomDeLaClasse, String nomDuPaquetage, Instruction inst, VisiteurInstruction<String> vi) {
		this.nomDeLaClasse = nomDeLaClasse;
		this.nomDuPaquetage = nomDuPaquetage;
		this.vi = vi;
		this.inst = inst;
	}

	public String enTete() {
		String str = new String();
		if (nomDuPaquetage != null)	str = str + "package " + nomDuPaquetage + ";" + lineSeparator;
		str = str
				+ lineSeparator
				+ "/** NFP121 tp6, question3"
				+ lineSeparator
				+ "   source Java genere par lintermediaire de votre visiteur \"VisiteurInstToJava\""
				+ lineSeparator + "*/" + lineSeparator;
		return str;
	}

	public String declarations() {
		String str = lineSeparator;
		Contexte ctxt = vi.contexte();
		Iterator<String> it = ctxt.iterator();
		while (it.hasNext()) {
			String identifiant = it.next();
			String valeur = Integer.toString(ctxt.lire(identifiant));
			str = str + "    " + "int " + identifiant + "=" + valeur + ";"
					+ lineSeparator;
		}
		return str;
	}

	public String instructions() {
		return inst.accepter(vi);
	}

	public String sourceComplet() {
		return sourceComplet(nomDeLaClasse);
	}

	private String sourceComplet(String className) {
		StringBuffer sb = new StringBuffer();

		sb.append(enTete());
		sb.append("public class " + className + "{" + lineSeparator
				+ lineSeparator);
		sb.append("  "
				+ "public static void main(String[] args)throws Exception{");
		sb.append(declarations() + instructions());
		sb.append(lineSeparator + "  }" + lineSeparator);
		sb.append(enPied());

		return sb.toString();
	}

	public String enPied() {
		return lineSeparator + "}" + lineSeparator;
	}

	public void enFichier() throws IOException {
		new File("question3/" + nomDeLaClasse + " .java").delete();
		new File("question3/" + nomDeLaClasse + " .class").delete();
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(new File(
					"question3/" + nomDeLaClasse + ".java")));
			out.write(this.sourceComplet());
			out.close();
		} catch (IOException e) {
		}
	}

}
