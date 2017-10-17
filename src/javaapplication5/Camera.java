/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;
import org.la4j.matrix.dense.Basic2DMatrix;
import org.la4j.vector.dense.BasicVector;

/**
 *
 * @author Erick
 */
public class Camera {
    int altura=800,largura=600;
    double janela[][] = {{3},{2.50}};
    double K[][] ={{this.altura/this.janela[0][0],0,(this.altura)/2},{0,this.largura/this.janela[1][0],(this.largura)/2},{0,0,1}};
    
    
   
}