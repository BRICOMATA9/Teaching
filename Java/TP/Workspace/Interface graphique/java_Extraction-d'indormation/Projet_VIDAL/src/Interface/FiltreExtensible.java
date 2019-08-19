package Interface;

import java.io.File; 
import java.util.*; 
import javax.swing.filechooser.*;

public class FiltreExtensible extends FileFilter{
	//Description et extensions acceptees par le filtre
	private String description;
	private List<String> extensions;
	//Constructeur a partir de la description
	public FiltreExtensible(String description){
		this.description = description;
		this.extensions = new ArrayList<String>();
	}
	//Implementation de FileFilter
	public boolean accept(File file){
		if(file.isDirectory() || extensions.size()==0) { 
			return true; 
		} 
		String nomFichier = file.getName().toLowerCase(); 
		for(String extension : extensions){
			if(nomFichier.endsWith(extension)){
				return true;
			}	
		}
		return false;
	}
	public String getDescription(){
		return description;
	}	

	public void addExtension(String extension){
		if(extension == null){
			new Dialogue("Une extension ne peut etre null.");	
		}	
		extensions.add(extension);
	}
}