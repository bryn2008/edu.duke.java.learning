package course2.week1;

import edu.duke.*;
import java.io.*;

/**
 * ImageInversion is a program that will invert any image selected and save a new image.
 * 
 * Bryn Lloyd 
 * v0.01 16/12/2015
 */

public class ImageInversion {
	
	//Chose the java proram (myObj) to run the java program you want
	public static void main (String [] args){
		
		ImageInversion myObj = new ImageInversion();
		myObj.selectAndConvert();
	}
	
	
    public ImageResource makeInversion(ImageResource inImage)
    {
        //I made a blank image of the same size
        ImageResource outImage = new ImageResource(inImage.getWidth(),inImage.getHeight());
        //for each pixel in outImage    
            for(Pixel pixel: outImage.pixels()){
                //look at the corrosponding pixel in inImage
                Pixel inPixel = inImage.getPixel(pixel.getX(),pixel.getY());
                //computer inPixel's red + inPixel's blue + inPixel's green
                //devode that sum by 3 (call it averagws)
               
                //int average = (inPixel.getRed()+inPixel.getBlue()+inPixel.getGreen())/3;
                
                //set pixels's red to average
                pixel.setRed(255-inPixel.getRed());
                //set pixel's green to average
                pixel.setGreen(255-inPixel.getGreen());
                //set pixel's blue to average
                pixel.setBlue(255-inPixel.getBlue());
            }
        //outImage is your answer
        return outImage;
    }
    
    public void selectAndConvert()
    {
        DirectoryResource dr = new DirectoryResource();
        for(File f: dr.selectedFiles()){
            ImageResource inImage = new ImageResource(f);
            ImageResource inv = makeInversion(inImage);
            
          //System.out.println(inImage); 
          
            //Gets the file name and sets the string fname to it 
            String fname = inImage.getFileName();
            //Sets the string newName to contain the "gray-" and the old name
            String newName = "inv-" + fname;
            
          //System.out.println(fname + " is the old name and the new name is " + newName);
            
            //sets the file name of the new image resource to the new "gray-" file name
            inv.setFileName(newName); 
            //draws the new image resources
            inv.draw();
            
          //System.out.println(gray);
          
            //saves the image resources to the root folder of the program
            inv.save();
            //note, this method overwites any files old with the new name
            //this means any image would have to be placed in the root folder
            //this would avoid overwiting any old files
        }
    }
}