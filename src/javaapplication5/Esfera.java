/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

import org.la4j.matrix.Matrix;
import org.la4j.matrix.dense.Basic2DMatrix;
import org.la4j.vector.Vectors;
import org.la4j.vector.dense.BasicVector;
import org.la4j.vector.Vector;
import org.la4j.vector.AbstractVector;
import java.lang.Math;
/**
 *
 * @author Erick
 */
public class Esfera extends Objeto{
   static double t;
    double [] centro;
    double raio;
    int [] cor;
    public void getNormal(float ponto){}; 
    public void Trans(float x){};
    
    public Esfera(double x,double y,double z,double raio,int[]cores){
    this.centro = new double[]{x, y, z};
    this.raio = raio;
    this.cor = new int[]{cores[0],cores[1],cores[2]};
    }
    
    boolean Interseçao(Vector vetor){
        Vector vetord = new BasicVector(vetor);
        Vector vetorcentro = new BasicVector(centro);
            double a = vetord.product(vetord);
            double b = -2*(vetord.product(vetorcentro));
	    double c = (vetorcentro.product(vetorcentro))-(raio*raio);

   	    double delta = (b*b) - (4 * a * c);
	     
                    if (delta >= 0)
	     {
	       
               double x1  = (-b + Math.sqrt(delta)) / (2.0 * a);
	       double x2 = (-b - Math.sqrt(delta)) / (2.0 * a);
               
               if (x1 <= x2) 
		  { 
		   t = x1; 
                   return true;
                  }		
	       
       	       else if (x2 <= x1) 
		  { 
		    t = x2;
                    return true;
                    
                  }
               
             }
     return false;         
    }
    public double getT(){
        return this.t;
    }
    @Override
    boolean Interseçao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

    