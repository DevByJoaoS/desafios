package idwall.desafio.string;

/**
 * Created by Rodrigo Catão Araujo on 06/02/2018.
 */
public class IdwallFormatter extends StringFormatter {

    /**
     * Should format as described in the challenge
     *
     * @param text
     * @return
     */
    @Override
    public String format(String text) {
    	int x = 0;
    	String formatedString = "";
    	while(x < text.length()) {
    		String stringToCheck;
    		if(x +40 > text.length()) {
    			stringToCheck = text.substring(x, text.length());
    		}
    		else {
    			stringToCheck = text.substring(x, x+41);
    		}
    		int finalIndex = x + verifyIndex(stringToCheck);
    		String formatedPart = text.substring(x, finalIndex);
    		formatedString += "\n" + formatedPart;
    		x = finalIndex;
    	}
    	return formatedString;
    }
    
    
    public int verifyIndex(String text) {
    	if(text.length() < 40) {
    		return text.length();
    	}
    	if(text.charAt(text.length() - 1) != ' ') {
    		for(int i= text.length() - 1; i>0 ;i--) {
    			if(text.charAt(i) == ' ')
    				return i+1;
    			if( i-2 > 0 && text.substring(i-1, i).equals("\n"))
    				return i;
    		}
    	}
    	return text.length();
    }
}
