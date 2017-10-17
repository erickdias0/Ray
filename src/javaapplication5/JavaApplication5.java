/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.*;
import javax.swing.*;
import org.la4j.matrix.Matrix;
import org.la4j.matrix.dense.Basic2DMatrix;
import org.la4j.matrix.dense.Basic1DMatrix;
import org.la4j.vector.Vectors;
import org.la4j.vector.dense.BasicVector;
import org.la4j.vector.Vector;
import org.la4j.vector.AbstractVector;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import org.la4j.vector.dense.DenseVector;
import org.la4j.inversion.MatrixInvertor;
import org.la4j.inversion.GaussianInvertor;
import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 * @author Erick
 */

public class JavaApplication5 {
 /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
      // TODO code application logic here
   int imagem[][];
   Cena cn = new Cena(); 
   Luz lz = new Luz();
   GaussianInvertor invertor = new GaussianInvertor();
    ArrayList <Esfera> obj = new ArrayList<Esfera>();
    int[]cor = {125,20,30};
    Esfera f = new Esfera(0,0,2,1.5,cor);
    int[]cor2 = {13,200,3};
    Esfera f2 = new Esfera(0,0,4,2.5,cor2);
    int[]cor3 = {45,84,200};
    Esfera f3 = new Esfera(0,0,6,3,cor3);
    Camera c = new Camera();
    FileWriter arq = new FileWriter("c:\\raytracer.ppm");
    PrintWriter printar = new PrintWriter(arq);
    printar.printf("P3\r\n%d %d\r\n255\r\n", c.altura,c.largura);
    Matrix d = new Basic1DMatrix();
    Matrix kI = new Basic2DMatrix(c.K);        
    kI = kI.inverse(invertor);
    obj.add(f3);
    obj.add(f2);
    obj.add(f);
    Vector amb = new BasicVector(cn.coramb);
    Vector luz = new BasicVector(lz.li);
    Vector temp = new BasicVector(luz.multiply(amb));
    
    luz = luz.normalize();
    for(int i=0;i<obj.size();i++){
    
    
    
        for(int x=0;x<c.largura;x++){
            for(int y=0;y<c.altura;y++){
                double [][]arrayd = {{y,x,1}};
                Matrix raio = new Basic2DMatrix(arrayd);
    
                raio = raio.transpose();
                d   = kI.multiply(raio);
                double[]arrayaux = {d.get(0,0),d.get(1,0),d.get(2,0)};
                Vector vetord = new BasicVector(arrayaux);
                
                if(obj.get(0).Interseçao(vetord)){
                    luz =luz.multiply(f.getT());
                    temp = temp.multiply(Math.max(0,luz.get(0) ));
                    System.out.println(temp.get(1));
                    
                    
                    printar.printf("%f %f %f ",obj.get(0).cor[0]*((obj.get(0).cor_epecular)+(obj.get(0).cor_difusa)),obj.get(0).cor[1]*((obj.get(0).cor_epecular)+(obj.get(0).cor_difusa)),obj.get(0).cor[2]*((obj.get(0).cor_epecular)+(obj.get(0).cor_difusa)));
                    
                } else if(obj.get(1).Interseçao(vetord)) {
                    printar.printf("%f %f %f ",obj.get(1).cor[0]*((obj.get(1).cor_epecular)+(obj.get(1).cor_difusa)),obj.get(1).cor[1]*((obj.get(1).cor_epecular)+(obj.get(1).cor_difusa)),obj.get(1).cor[2]*((obj.get(1).cor_epecular)+(obj.get(1).cor_difusa)));
     
                    
                }
                 else if(obj.get(2).Interseçao(vetord)) {
                    printar.printf("%f %f %f ",obj.get(2).cor[0]*((obj.get(2).cor_epecular)+(obj.get(2).cor_difusa)),obj.get(2).cor[1]*((obj.get(2).cor_epecular)+(obj.get(2).cor_difusa)),obj.get(2).cor[2]*((obj.get(2).cor_epecular)+(obj.get(2).cor_difusa)));
                 } 
                else{
                    printar.printf("0 0 0 ");
                }
        }
       }
        
    }
    arq.close();
    }
} 