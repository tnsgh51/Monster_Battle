package Server;

public class S_Analysis {
	private static S_Analysis s = null;
	
	public static S_Analysis getInstance(S_TC s_TC) {
		if(s== null) {
			s = new S_Analysis(s_TC);
		}

		return s;
	}
	
	private S_Analysis(S_TC s_TC) {

	}

	
	
	
}
