package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class Gantt extends PApplet
{	

	public ArrayList<Task> tasks = new ArrayList<Task>();
	public float bound = width * 0.05f;
	public int value[] = new int[9];
	public int value1[] = new int[9];
	public int flag;
	public float y;
	public float x;
	public int days[] = new int[9];
	public int days2[] = new int[9];
	public int days3[] = new int[9];
	public int start_days[] = new int[9];
	public void settings()
	{
		size(800, 600);
	}

	public void loadTasks()
	{
		Table t = loadTable("tasks.csv","header");
		for(TableRow row:t.rows()){
			Task c = new Task(row);
			tasks.add(c);
		}
	}

	public void printTasks()
	{
		float bound = width * 0.05f;
		float z = 0;
		for(int i = 0; i< 9;i++){
			float y= map(i,0,tasks.size(),height*0.1f,height-200);
			fill(255);
			text(tasks.get(i).Get_task(),40,y+30);
					
							if(flag==0)
							{
								days[i] = tasks.get(i).Get_end()-tasks.get(i).Get_start();
								days2[i] = tasks.get(i).Get_end()-tasks.get(i).Get_start();
								days3[i] = tasks.get(i).Get_end()-tasks.get(i).Get_start();

								start_days[i]=tasks.get(i).Get_start();
							}
							
							if(i == (flag-1))
							{
								//days[i]+=value[i];
								colorMode(HSB);
								stroke(0);
								fill(0+z,255,255);
								rect(bound+100+(start_days[i]-1+value1[i])*((width-bound-bound-120)/29),y+10,(days[i]+value[i])*(width-bound-bound-120)/29,30,5);
								z+=29;
								
							}
							else
							{
								colorMode(HSB);
								stroke(0);
								fill(0+z,255,255);
								rect(bound+100+(start_days[i]-1)*((width-bound-bound-120)/29),y+10,days2[i]*(width-bound-bound-120)/29,30,5);
								z+=29;
							}
						

			
	
		}
	}
	
	public void mousePressed()
	{
		float z = 0;
		for(int i = 0; i< 9;i++){
		if(mouseY>=70&&mouseY<100&&i==0)
			{
				flag=1;
				if(mouseX>bound+100+(days[i]+value[i])*(width-bound-bound-120)/29&&x<bound+100+(start_days[i]-1+value1[i])*((width-bound-bound-120)/29)+(days[i]+value[i])*(width-bound-bound-120)/29)
				{
					z=(int)((mouseX-bound-100)-(bound+100+(start_days[i]-1+value1[i])*((width-bound-bound-120)/29)))/((width-bound-bound-120)/29);
					value[i]=(int)z-4;	
					days2[i]=days[i]+value[i];
					
				}
				else if(mouseX<bound+100+(days[i]+value[i])*(width-bound-bound-120)/29)
				{
					z=(int)((mouseX-bound-100)-(bound+100+(start_days[i]-1+value1[i])*((width-bound-bound-120)/29)))/((width-bound-bound-120)/29);
					value[i]=-(int)z-4;	
					days2[i]=days[i]+value[i];
					
				}
						
			}
			if(mouseY>=107.77778&&mouseY<137.77778&&i==1)
			{
				flag=2;
				if(mouseX>bound+100+(days[i]+value[i])*(width-bound-bound-120)/29)
				{
					z=(int)((mouseX-bound-100)-(bound+100+(start_days[i]-1+value1[i])*((width-bound-bound-120)/29)))/((width-bound-bound-120)/29);
					value[i]=(int)z-4;	
					days2[i]=days[i]+value[i];

				}
				else if(mouseX<bound+100+(days[i]+value[i])*(width-bound-bound-120)/29)
				{
					z=(int)((mouseX-bound-100)-(bound+100+(start_days[i]-1+value1[i])*((width-bound-bound-120)/29)))/((width-bound-bound-120)/29);
					value[i]=-(int)z-4;	
					days2[i]=days[i]+value[i];

				}
			}
			if(mouseY>=145.55556&&mouseY<175.55556&&i==2)
			{
				flag=3;
				if(mouseX>bound+100+(days[i]+value[i])*(width-bound-bound-120)/29)
				{
					z=(int)((mouseX-bound-100)-(bound+100+(start_days[i]-1+value1[i])*((width-bound-bound-120)/29)))/((width-bound-bound-120)/29);
					value[i]=(int)z-2;	
					days2[i]=days[i]+value[i];
					
				}
				else if(mouseX<bound+100+(days[i]+value[i])*(width-bound-bound-120)/29)
				{
					z=(int)((mouseX-bound-100)-(bound+100+(start_days[i]-1+value1[i])*((width-bound-bound-120)/29)))/((width-bound-bound-120)/29);
					value[i]=-(int)z-2;	
					days2[i]=days[i]+value[i];
				}
			}
			if(mouseY>=183.33334&&mouseY<213.33334&&i==3)
			{
				flag=4;
				if(mouseX>bound+100+(days[i]+value[i])*(width-bound-bound-120)/29)
				{
					z=(int)((mouseX-bound-100)-(bound+100+(start_days[i]-1+value1[i])*((width-bound-bound-120)/29)))/((width-bound-bound-120)/29);
					value[i]=(int)z-4;	
					days2[i]=days[i]+value[i];
				}
				else if(mouseX<bound+100+(days[i]+value[i])*(width-bound-bound-120)/29)
				{
					z=(int)((mouseX-bound-100)-(bound+100+(start_days[i]-1+value1[i])*((width-bound-bound-120)/29)))/((width-bound-bound-120)/29);
					value[i]=-(int)z-4;	
					days2[i]=days[i]+value[i];
				}
			}
			if(mouseY>=221.11111&&mouseY<251.11111&&i==4)
			{
				flag=5;
				if(mouseX>bound+100+(days[i]+value[i])*(width-bound-bound-120)/29)
				{
					z=(int)((mouseX-bound-100)-(bound+100+(start_days[i]-1+value1[i])*((width-bound-bound-120)/29)))/((width-bound-bound-120)/29);
					value[i]=(int)z-3;	
					days2[i]=days[i]+value[i];
				}
				else if(mouseX<bound+100+(days[i]+value[i])*(width-bound-bound-120)/29)
				{
					z=(int)((mouseX-bound-100)-(bound+100+(start_days[i]-1+value1[i])*((width-bound-bound-120)/29)))/((width-bound-bound-120)/29);
					value[i]=-(int)z-3;	
					days2[i]=days[i]+value[i];
				}
			}
			if(mouseY>=258.8889&&mouseY<288.8889&&i==5)
			{
				flag=6;
				if(mouseX>bound+100+(days[i]+value[i])*(width-bound-bound-120)/29)
				{
					z=(int)((mouseX-bound-100)-(bound+100+(start_days[i]-1+value1[i])*((width-bound-bound-120)/29)))/((width-bound-bound-120)/29);
					value[i]=(int)z-2;	
					days2[i]=days[i]+value[i];
				}
				else if(mouseX<bound+100+(days[i]+value[i])*(width-bound-bound-120)/29)
				{
					z=(int)((mouseX-bound-100)-(bound+100+(start_days[i]-1+value1[i])*((width-bound-bound-120)/29)))/((width-bound-bound-120)/29);
					value[i]=-(int)z-2;	
					days2[i]=days[i]+value[i];
				}
			}
			if(mouseY>=296.6667&&mouseY<326.6667&&i==6)
			{
				flag=7;
				if(mouseX>bound+100+(days[i]+value[i])*(width-bound-bound-120)/29)
				{
					z=(int)((mouseX-bound-100)-(bound+100+(start_days[i]-1+value1[i])*((width-bound-bound-120)/29)))/((width-bound-bound-120)/29);
					value[i]=(int)z-4;	
					days2[i]=days[i]+value[i];
				}
				else if(mouseX<bound+100+(days[i]+value[i])*(width-bound-bound-120)/29)
				{
					z=(int)((mouseX-bound-100)-(bound+100+(start_days[i]-1+value1[i])*((width-bound-bound-120)/29)))/((width-bound-bound-120)/29);
					value[i]=-(int)z-4;	
					days2[i]=days[i]+value[i];
				}
			}
			if(mouseY>=334.44446&&mouseY<364.44446&&i==7)
			{
				flag=8;
				if(mouseX>bound+100+(days[i]+value[i])*(width-bound-bound-120)/29)
				{
					z=(int)((mouseX-bound-100)-(bound+100+(start_days[i]-1+value1[i])*((width-bound-bound-120)/29)))/((width-bound-bound-120)/29);
					value[i]=(int)z-4;	
					days2[i]=days[i]+value[i];
				}
				else if(mouseX<bound+100+(days[i]+value[i])*(width-bound-bound-120)/29)
				{
					z=(int)((mouseX-bound-100)-(bound+100+(start_days[i]-1+value1[i])*((width-bound-bound-120)/29)))/((width-bound-bound-120)/29);
					value[i]=-(int)z-4;	
					days2[i]=days[i]+value[i];
				}
			}
			if(mouseY>=372.22223&&mouseY<402.22223&&i==8)
			{
				flag=9;
				if(mouseX>bound+100+(days[i]+value[i])*(width-bound-bound-120)/29)
				{
					z=(int)((mouseX-bound-100)-(bound+100+(start_days[i]-1+value1[i])*((width-bound-bound-120)/29)))/((width-bound-bound-120)/29);
					value[i]=(int)z-2;
					days2[i]=days[i]+value[i];	
				}
				else if(mouseX<bound+100+(days[i]+value[i])*(width-bound-bound-120)/29)
				{
					z=(int)((mouseX-bound-100)-(bound+100+(start_days[i]-1+value1[i])*((width-bound-bound-120)/29)))/((width-bound-bound-120)/29);
					value[i]=-(int)z-2;	
					days2[i]=days[i]+value[i];
				}
			}
				
		}
		
	}
  
	public void mouseDragged()
	{
		float z = 0;
		
		for(int i = 0; i< 9;i++){
			if(mouseY>=70&&mouseY<100&&i==0)
			{
				flag=1;
				if(mouseX>bound+100+(days[i]+value[i])*(width-bound-bound-120)/29&&x<bound+100+(start_days[i]-1+value1[i])*((width-bound-bound-120)/29)+(days[i]+value[i])*(width-bound-bound-120)/29)
				{
					z=(int)((mouseX-bound-100)-(bound+100+(start_days[i]-1+value1[i])*((width-bound-bound-120)/29)))/((width-bound-bound-120)/29);
					value[i]=(int)z-4;	
					days2[i]=days[i]+value[i];
					
				}
				else if(mouseX<bound+100+(days[i]+value[i])*(width-bound-bound-120)/29)
				{
					z=(int)((mouseX-bound-100)-(bound+100+(start_days[i]-1+value1[i])*((width-bound-bound-120)/29)))/((width-bound-bound-120)/29);
					value[i]=-(int)z-4;	
					days2[i]=days[i]+value[i];
					
				}
						
			}
			if(mouseY>=107.77778&&mouseY<137.77778&&i==1)
			{
				flag=2;
				if(mouseX>bound+100+(days[i]+value[i])*(width-bound-bound-120)/29)
				{
					z=(int)((mouseX-bound-100)-(bound+100+(start_days[i]-1+value1[i])*((width-bound-bound-120)/29)))/((width-bound-bound-120)/29);
					value[i]=(int)z-4;	
					days2[i]=days[i]+value[i];

				}
				else if(mouseX<bound+100+(days[i]+value[i])*(width-bound-bound-120)/29)
				{
					z=(int)((mouseX-bound-100)-(bound+100+(start_days[i]-1+value1[i])*((width-bound-bound-120)/29)))/((width-bound-bound-120)/29);
					value[i]=-(int)z-4;	
					days2[i]=days[i]+value[i];

				}
			}
			if(mouseY>=145.55556&&mouseY<175.55556&&i==2)
			{
				flag=3;
				if(mouseX>bound+100+(days[i]+value[i])*(width-bound-bound-120)/29)
				{
					z=(int)((mouseX-bound-100)-(bound+100+(start_days[i]-1+value1[i])*((width-bound-bound-120)/29)))/((width-bound-bound-120)/29);
					value[i]=(int)z-2;	
					days2[i]=days[i]+value[i];
					
				}
				else if(mouseX<bound+100+(days[i]+value[i])*(width-bound-bound-120)/29)
				{
					z=(int)((mouseX-bound-100)-(bound+100+(start_days[i]-1+value1[i])*((width-bound-bound-120)/29)))/((width-bound-bound-120)/29);
					value[i]=-(int)z-2;	
					days2[i]=days[i]+value[i];
				}
			}
			if(mouseY>=183.33334&&mouseY<213.33334&&i==3)
			{
				flag=4;
				if(mouseX>bound+100+(days[i]+value[i])*(width-bound-bound-120)/29)
				{
					z=(int)((mouseX-bound-100)-(bound+100+(start_days[i]-1+value1[i])*((width-bound-bound-120)/29)))/((width-bound-bound-120)/29);
					value[i]=(int)z-4;	
					days2[i]=days[i]+value[i];
				}
				else if(mouseX<bound+100+(days[i]+value[i])*(width-bound-bound-120)/29)
				{
					z=(int)((mouseX-bound-100)-(bound+100+(start_days[i]-1+value1[i])*((width-bound-bound-120)/29)))/((width-bound-bound-120)/29);
					value[i]=-(int)z-4;	
					days2[i]=days[i]+value[i];
				}
			}
			if(mouseY>=221.11111&&mouseY<251.11111&&i==4)
			{
				flag=5;
				if(mouseX>bound+100+(days[i]+value[i])*(width-bound-bound-120)/29)
				{
					z=(int)((mouseX-bound-100)-(bound+100+(start_days[i]-1+value1[i])*((width-bound-bound-120)/29)))/((width-bound-bound-120)/29);
					value[i]=(int)z-3;	
					days2[i]=days[i]+value[i];
				}
				else if(mouseX<bound+100+(days[i]+value[i])*(width-bound-bound-120)/29)
				{
					z=(int)((mouseX-bound-100)-(bound+100+(start_days[i]-1+value1[i])*((width-bound-bound-120)/29)))/((width-bound-bound-120)/29);
					value[i]=-(int)z-3;	
					days2[i]=days[i]+value[i];
				}
			}
			if(mouseY>=258.8889&&mouseY<288.8889&&i==5)
			{
				flag=6;
				if(mouseX>bound+100+(days[i]+value[i])*(width-bound-bound-120)/29)
				{
					z=(int)((mouseX-bound-100)-(bound+100+(start_days[i]-1+value1[i])*((width-bound-bound-120)/29)))/((width-bound-bound-120)/29);
					value[i]=(int)z-2;	
					days2[i]=days[i]+value[i];
				}
				else if(mouseX<bound+100+(days[i]+value[i])*(width-bound-bound-120)/29)
				{
					z=(int)((mouseX-bound-100)-(bound+100+(start_days[i]-1+value1[i])*((width-bound-bound-120)/29)))/((width-bound-bound-120)/29);
					value[i]=-(int)z-2;	
					days2[i]=days[i]+value[i];
				}
			}
			if(mouseY>=296.6667&&mouseY<326.6667&&i==6)
			{
				flag=7;
				if(mouseX>bound+100+(days[i]+value[i])*(width-bound-bound-120)/29)
				{
					z=(int)((mouseX-bound-100)-(bound+100+(start_days[i]-1+value1[i])*((width-bound-bound-120)/29)))/((width-bound-bound-120)/29);
					value[i]=(int)z-4;	
					days2[i]=days[i]+value[i];
				}
				else if(mouseX<bound+100+(days[i]+value[i])*(width-bound-bound-120)/29)
				{
					z=(int)((mouseX-bound-100)-(bound+100+(start_days[i]-1+value1[i])*((width-bound-bound-120)/29)))/((width-bound-bound-120)/29);
					value[i]=-(int)z-4;	
					days2[i]=days[i]+value[i];
				}
			}
			if(mouseY>=334.44446&&mouseY<364.44446&&i==7)
			{
				flag=8;
				if(mouseX>bound+100+(days[i]+value[i])*(width-bound-bound-120)/29)
				{
					z=(int)((mouseX-bound-100)-(bound+100+(start_days[i]-1+value1[i])*((width-bound-bound-120)/29)))/((width-bound-bound-120)/29);
					value[i]=(int)z-4;	
					days2[i]=days[i]+value[i];
				}
				else if(mouseX<bound+100+(days[i]+value[i])*(width-bound-bound-120)/29)
				{
					z=(int)((mouseX-bound-100)-(bound+100+(start_days[i]-1+value1[i])*((width-bound-bound-120)/29)))/((width-bound-bound-120)/29);
					value[i]=-(int)z-4;	
					days2[i]=days[i]+value[i];
				}
			}
			if(mouseY>=372.22223&&mouseY<402.22223&&i==8)
			{
				flag=9;
				if(mouseX>bound+100+(days[i]+value[i])*(width-bound-bound-120)/29)
				{
					z=(int)((mouseX-bound-100)-(bound+100+(start_days[i]-1+value1[i])*((width-bound-bound-120)/29)))/((width-bound-bound-120)/29);
					value[i]=(int)z-2;
					days2[i]=days[i]+value[i];	
				}
				else if(mouseX<bound+100+(days[i]+value[i])*(width-bound-bound-120)/29)
				{
					z=(int)((mouseX-bound-100)-(bound+100+(start_days[i]-1+value1[i])*((width-bound-bound-120)/29)))/((width-bound-bound-120)/29);
					value[i]=-(int)z-2;	
					days2[i]=days[i]+value[i];
				}
			}
				
		}
	}

	
	
	public void setup() 
	{
		loadTasks();
		//printTasks();
	}
	
	public void draw()
	{	
		colorMode(HSB);
		background(0);

		float bound = width * 0.05f;
		stroke(255);
		
		for(int i=1;i<31;i++){
			
			float x = map(i,1,31,bound+100,width-bound);
			fill(255);
			text((int)i,x-5,30);
			line(x,bound,x,height-bound);
		}

		printTasks();
	}
}
