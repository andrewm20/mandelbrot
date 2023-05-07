import java.awt.Color;
public class Mandelbrot /*extends Thread*/ {
    // public ImaginaryNum point;
    // public Color color;
    // public Mandelbrot(ImaginaryNum point){
    //     this.point = point;
    //     this.color = null;
    // }
    // public void run(){
    //     int steps = calculateCount(this.point);
    //     if( steps > 100){
    //         this.color = Color.BLACK;
    //     }else if (steps > 50){
    //         this.color = Color.CYAN;
    //     }else if (steps > 30){
    //         this.color = Color.BLUE;
    //     }else if (steps > 20){
    //         this.color = Color.GREEN;
    //     }else if (steps > 15){
    //         this.color = Color.ORANGE;
    //     }else if (steps > 12){
    //         this.color = Color.PINK;
    //     }else if (steps > 10){
    //         this.color = Color.MAGENTA;
    //     }else if (steps > 7){
    //         this.color = Color.WHITE;
    //     }else if (steps > 4){
    //         this.color = Color.LIGHT_GRAY;
    //     }
    // }
    public static void main(String[] args){
        Long startTime = System.currentTimeMillis();
        Picture output = new Picture(20001,20001);
        output.setOriginUpperLeft();        
        for (int i = 6000; i >= -14000; i --){
            for(int j = -10000; j <= 0; j ++){
                // Mandelbrot[] threads = new Mandelbrot[4];
                // for(int k = 0;k < 4;k++){
                //     threads[k] = new Mandelbrot(new ImaginaryNum((i-k)*.00025, (j)*.00025));
                //     threads[k].run();
                // }
                // for(int k = 0;k < 4;k++){
                //     try{
                //         threads[k].join();
                //         if (threads[k].color != null){
                //             output.set(i+k+6000,j+6000, threads[k].color);
                //             output.set(i+k+6000,6000-j, threads[k].color);
                //         }
                //     }catch (Exception e){
                //         System.out.println(e);
                //     }
                // }
                int steps = calculateCount(new ImaginaryNum(i*.000125, j*.000125));
                if( steps > 200){
                    output.set(i+14000,j+10000, Color.BLACK);
                    output.set(i+14000,(10000-j), Color.BLACK);
                }else if (steps > 100){
                    output.set(i+14000,j+10000, Color.CYAN);
                    output.set(i+14000,(10000-j), Color.CYAN);
                }else if (steps > 50){
                    output.set(i+14000,j+10000, Color.BLUE);
                    output.set(i+14000,(10000-j), Color.BLUE);
                }else if (steps > 30){
                    output.set(i+14000,j+10000, Color.MAGENTA);
                    output.set(i+14000,(10000-j), Color.MAGENTA);
                }else if (steps > 20){
                    output.set(i+14000,j+10000, Color.ORANGE);
                    output.set(i+14000,(10000-j), Color.ORANGE);
                }else if (steps > 15){
                    output.set(i+14000,j+10000, Color.PINK);
                    output.set(i+14000,(10000-j), Color.PINK);
                }else if (steps > 12){
                    output.set(i+14000,j+10000, Color.GREEN);
                    output.set(i+14000,(10000-j), Color.GREEN);
                }else{
                    output.set(i+14000,j+10000, Color.WHITE);
                    output.set(i+14000,(10000-j), Color.WHITE);
                }
            }
        }
        output.save("output.png");
        Long endTime = System.currentTimeMillis();
        System.out.println("Took " + (int) ((endTime-startTime)/1000) +" seconds");
        
        
        
    }
    public static int calculateCount(ImaginaryNum a){
        return (iterate(a,new ImaginaryNum(0,0),0));
    }
    public static int iterate(ImaginaryNum c,ImaginaryNum previousVal, int iterationCount){
        if(iterationCount > 200){
            return iterationCount;
        }
        ImaginaryNum returnValue = ImaginaryNum.add( ImaginaryNum.mult(previousVal,previousVal),c);
        if (returnValue.radius() > 2){
            return iterationCount;
        }
        return iterate(c, returnValue, iterationCount+1);
    }
}
