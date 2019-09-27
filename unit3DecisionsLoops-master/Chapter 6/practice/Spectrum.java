 

import java.util.Scanner;
public class Spectrum
{ 
    static Scanner s = new Scanner(System.in);
    static double wavelength;
    
    public static void main(String[] args)
    {
        System.out.print("Enter a wavelength(e.g. 7e-4): ");
        wavelength = s.nextDouble();
        
        
        System.out.print("\n\nType\t\twavelengths(m)\tFrequency(Hz)\n");
        if (wavelength > 10e-1)
        {
            System.out.print("Radio Waves\t<10e-1\t\t<3e9");
        }
        else if (wavelength > 10e-3)
        {
            System.out.print("Microwaves\t10e-3 to 10e-1\t\t3e9 to 3e11");
        }
        else if (wavelength > 7e-7)
        {
            System.out.print("Infrared\t7e-7 to 10e-3\t\t3e11 to 4e14");
        }
        else if (wavelength > 4e-7)
        {
            System.out.print("Visible light\t4e-7 to 7e-7\t\t4e14 to 7.5e14");
        }
        else if (wavelength > 10e-8)
        {
            System.out.print("Ultraviolet\t10e-8 to 4e-7\t\t7.5e14 to 3e16");
        }
        else if (wavelength > 10e-11)
        {
            System.out.print("X-rays\t10e-11 to 10e-8\t\t3e16 to 3e19");
        }
        else if (wavelength < 10e-11)
        {
            System.out.print("Gamma rays\t<10e-11\t\t>3e19");
        }
        
       
        
    }
}
