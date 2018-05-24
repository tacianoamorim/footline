package outro;

public class TEste2 {
	public static void main(String[] args) {
		String clube[] = new String[20];
		clube[0] = "Clube1";
		clube[1] = "Clube2";
		clube[2] = "Clube3";
		clube[3] = "Clube4";
		clube[4] = "Clube5";
		clube[5] = "Clube6";
		clube[6] = "Clube7";
		clube[7] = "Clube8";
		clube[8] = "Clube9";
		clube[9] = "Clube10";
		clube[10] = "Clube11";
		clube[11] = "Clube12";
		clube[12] = "Clube13";
		clube[13] = "Clube14";
		clube[14] = "Clube15";
		clube[15] = "Clube16";
		clube[16] = "Clube17";
		clube[17] = "Clube18";
		clube[18] = "Clube19";
		clube[19] = "Clube20";
		tabela(clube);
	}
	public static void tabela(String[] clube){
		for (int i=0; i<20; i++){
			for(int j=0; j<20; j++){
				if (i!=j){
					System.out.print(clube[i]);
					System.out.print(" x ");
					System.out.println(clube[j]);
				}
			}
		}
	}
}