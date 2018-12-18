  /*
 * LIBRE DE DROIT
 */
package com.dev4tests.junit.examen;

/**
 *
 * @author olivier charles
 * @version 2.0
 * @
 * 
 */
public class EvaluateurNiveau implements Evaluateur {
    
    private static final int MIN_COURS   = 0;
    private static final int MIN_EXAMEN  = 0;
    private static final int MAX_COURS   = 25;
    private static final int MAX_EXAMEN  = 75;
    
    private static final int MIN = 0;
    private static final int LIMITE_DC = 30;
    private static final int LIMITE_CB = 50;
    private static final int LIMITE_BA = 70;
    private static final int MAX = 100;
    
    
    // Patron singleton
    private static EvaluateurNiveau instance = null;
    private EvaluateurNiveau() {
    }
    public static EvaluateurNiveau getEvaluateurNiveau() {
    	if ( instance == null )
    		instance = new EvaluateurNiveau();
        return instance;
    }
    
        
    public boolean isInRange( int value, int min, int max )
    {
        return( value >= min && value <= max );
    }
    
    String  niveau( int  somme )
    {   
        String niv = "";
        if (   isInRange(  somme ,   MIN ,   LIMITE_DC-1 )) {  niv = "D"; } 
        else if (   isInRange(  somme , LIMITE_DC ,   LIMITE_CB-1 )) { niv="C";}
        else if (   isInRange(  somme , LIMITE_CB ,   LIMITE_BA-1 )) {niv="B";}
        else if (   isInRange(  somme , LIMITE_BA ,   MAX )) {  niv="A"; }
        return  niv;
    }
    
    
    public boolean isInt( String sval )
    {
        try { Integer.valueOf( sval);}
        catch( Exception e ) { return false;}
        return true;
    }
    
    public String evaluerNiveau(  String scours,  String sexamen ) 
            throws Exception
    {
         String niveau = ""; 
         String message = "Format Cours ["+  MIN_COURS+".."+  MAX_COURS+
                   "] Examen ["+  MIN_EXAMEN+".."+  MAX_EXAMEN+"]";
        if (   isInt( scours) && isInt( sexamen ))
        {
            int cours = Integer.valueOf( scours );
            int examen = Integer.valueOf( sexamen );
            niveau = "";
            if ( isInRange( cours, MIN_COURS, MAX_COURS )
              && isInRange( examen, MIN_EXAMEN, MAX_EXAMEN ))
            {
                 niveau =   niveau(  cours +  examen  );
            }
            else {
                throw new ValeurHorsBornesException( "Valeur(s) hors bornes. " + message );
            }
        }
        else
        {
            throw new MauvaisFormatException("Mauvais format, entiers attendus. "+ message ); 
        }
        return  niveau;
    }
    
    public static class MauvaisFormatException extends Exception {
    	/**
		 * 
		 */
		private static final long serialVersionUID = -4361392291589634666L;

		public MauvaisFormatException( String message ) {
    		super( message );
    	}
    }
    
    public static class ValeurHorsBornesException extends Exception {
    	/**
		 * 
		 */
		private static final long serialVersionUID = -6517435681925360921L;

		public ValeurHorsBornesException( String message ) {
    		super( message );
    	}
    }
    
    
}
