package com.dev4tests.junit.examen;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;  //do not confuse with 'org.junit.Test'!
import org.mockito.Mock;

import com.dev4tests.junit.examen.Evaluateur;
import com.dev4tests.junit.examen.LigneNotesExamen;

import static org.mockito.Mockito.*;
//other imports


class MockEvaluateurTest {


  @Mock
  private Evaluateur evaluateur;

  @BeforeEach
  public void programmerBouchon() throws Exception {
	  evaluateur = mock(Evaluateur.class);
	  when( evaluateur.evaluerNiveau("15","30") ).thenReturn("C");
  }
  
  
  @Test
  void testLigneExamen() throws Exception {
     LigneNotesExamen lne = new LigneNotesExamen("MATHEMATIQUES", "15", "30", "0001", evaluateur);
     System.out.println( lne );
     assertEquals( lne.getNiveau() ,"C");
  }
}

