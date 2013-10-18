package io.github.christiangaertner.moebelplaner.graphics.blending;

/**
 *
 * @author Christian
 */
public interface IColorBlender {

    public int normal(int a, int b);
    
    public int average(int a, int b);
    
    public int add(int a, int b);
    
    public int subtract(int a, int b);
    
    public int multiply(int a, int b);
    
    public int divide(int a, int b);
    
    public int difference(int a, int b);
    
    public int darkenonly(int a, int b);
    
    public int lightenonly(int a, int b);
    
    public int screen(int a, int b);
    
    public int overlay(int a, int b);
    
    public int hardlight(int a, int b);
    
    public int softlight(int a, int b);
    
    public int colorburn(int a, int b);
    
    public int exclusion(int a, int b);
    
    public int hardmix(int a, int b);
    
    public int vividlight(int a, int b);
    
    public int colordoge(int a, int b);
}
