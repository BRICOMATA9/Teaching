import java.util.Vector;

public class TabEnsemble {

	Vector<Ensemble> TE;
	
	public TabEnsemble(){
		TE=new Vector<Ensemble>();
	}
	
	public void lireTabEnsemble(int m) throws IllegalNumberException {
		Ensemble e;
		if (m<0) throw new IllegalNumberException();
		for(int i=0;i<m;i++){
			e=new Ensemble();
			e.lireEnsemble();
			TE.add(i,e);
		}
	}
	
	public void afficheTabEnsemble(){
		 for(Ensemble e:TE) System.out.print(e);
	}
	
	public void insereEnsemble(Ensemble Es){
		int i;
		for (i=0;i<TE.size() && TE.elementAt(i).sommeEnsemble()<Es.sommeEnsemble();i++);		
		TE.add(i,Es);
	}
}
