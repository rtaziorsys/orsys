/*
 * LIBRE DE DROIT
 */
package com.dev4tests.junit.examen;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.dev4tests.junit.examen.EvaluateurNiveau;



/**
 * @author olivier
 */
@RunWith(Parameterized.class)
public class EvaluateurNiveauParametresTest {

    private String cours;
    private String examen;
    private String attendu;
    private static EvaluateurNiveau evaluateur;

    @Parameters
    public static Collection<Object[]> dataTests() {

        Object[][] data = new Object[][]{{"0", "0", "D"}, 
            {"15", "14", "D"}, {"1", "29", "C"}, {"15", "34", "C"}, 
            {"15", "35", "B"} , {"20", "49", "B"},{"20", "50", "A"},
            {"25", "75", "A"}};

        return Arrays.asList(data);
    }

    public EvaluateurNiveauParametresTest(String cours, String examen, String attendu) {
        this.cours = cours;
        this.examen = examen;
        this.attendu = attendu;
    }
    
    @BeforeClass
    public static void setEvaluateurNiveau() {
    	evaluateur = EvaluateurNiveau.getEvaluateurNiveau();
    }

    @Test
    public void testAvecParametres() throws Exception {
        String note = evaluateur.evaluerNiveau(cours, examen);
        assertEquals(attendu, note);
    }

}
