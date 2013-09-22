package io.github.christiangaertner.moebelplaner.graphics.blending;

/**
 *
 * @author Christian
 */
public interface IColorBlender {

    public int normal(int a, int b, int o);
    
    public int average(int a, int b, int o);
    
    public int add(int a, int b, int o);
    
    public int subtract(int a, int b, int o);
    
    public int multiply(int a, int b, int o);
    
    public int divide(int a, int b, int o);
    
    public int difference(int a, int b, int o);
    
    public int darkenonly(int a, int b, int o);
    
    public int lightenonly(int a, int b, int o);
    
    public int screen(int a, int b, int o);
    
    public int overlay(int a, int b, int o);
    
    public int hardlight(int a, int b, int o);
    
    public int softlight(int a, int b, int o);
    
    public int colorburn(int a, int b, int o);
}
