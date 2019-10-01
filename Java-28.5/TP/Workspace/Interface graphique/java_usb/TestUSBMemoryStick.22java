public class TestUSBMemoryStick extends USBMemoryStick
{
	private Block[] tab =super.blocks.toArray(new Block[super.blocks.size()]);
	public void defragmentation(){
		Block g;
		for(int i=0;i<tab.length ;i++){
			if(tab[i].getName().equals("vide")){
				int j=i;
				for(j=i;j<tab.length && tab[j].getName().equals("vide");j++);
				if(j<tab.length){		
					g=tab[i];
					tab[i]=tab[i+1];
					tab[i]=g;
				}
			}
		}
	}
}
