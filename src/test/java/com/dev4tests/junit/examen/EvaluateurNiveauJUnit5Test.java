package com.dev4tests.junit.examen;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import com.dev4tests.junit.examen.EvaluateurNiveau;
import com.dev4tests.junit.examen.EvaluateurNiveau.MauvaisFormatException;
import com.dev4tests.junit.examen.EvaluateurNiveau.ValeurHorsBornesException;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
 
 
@DisplayName("Tests fonctionnels de la classe EvaluateurNiveau")
class EvaluateurNiveauJUnit5Test {
	
	private static EvaluateurNiveau evaluateur;

	
	@BeforeAll
	 public static void setEvaluateurNiveau() {
    	evaluateur = EvaluateurNiveau.getEvaluateurNiveau();
    }
	
    @DisplayName("Tests aux limites EvaluateurNiveau")
    @ParameterizedTest(name = "{index} => cours={0}, examen={1}, attendu={2}")
    @CsvFileSource(resources = "/test-data.csv")
    void testsLimitesEvaluateurNiveau( String cours , String examen , String attendu) throws Exception {
        assertEquals( evaluateur.evaluerNiveau(cours, examen) , attendu );
    }
    
    @Test
    public void testMauvaisFormatCours() {
    	 Assertions.assertThrows(MauvaisFormatException.class, () -> {
    		 evaluateur.evaluerNiveau("1C", "70");
    	    });
    }
   
    @Test
    public void testMauvaisFormatExamen() {
    	 Assertions.assertThrows(MauvaisFormatException.class, () -> {
    		 evaluateur.evaluerNiveau("20", "XXX");
    	 });
    }
    
    @Test
    public void testValeurHorsBornesCours() {
    	 Assertions.assertThrows(ValeurHorsBornesException.class, () -> {
    		 evaluateur.evaluerNiveau("26", "70");
    	    });
    }
   
    @Test
    public void testValeurHorsBornesExamen() {
    	 Assertions.assertThrows(ValeurHorsBornesException.class, () -> {
    		 evaluateur.evaluerNiveau("20", "76");
    	 });
    }
    
}

